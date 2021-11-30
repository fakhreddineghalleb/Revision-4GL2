package tn.esprit.revision4glcs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.revision4glcs.R;
import tn.esprit.revision4glcs.models.Voiture;
import tn.esprit.revision4glcs.utils.AppDataBase;

public class FavsAdapter extends RecyclerView.Adapter<FavsAdapter.FavsViewHolder> {

    private List<Voiture> voitureList;
    private Context mContext;

    public FavsAdapter(List<Voiture> voitureList, Context mContext) {
        this.voitureList = voitureList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FavsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext)
                .inflate(R.layout.single_row_favs, parent, false);

        return new FavsViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull FavsViewHolder holder, int position) {
        Voiture singleItem = voitureList.get(position);

        holder.imgCar.setImageResource(singleItem.getImage());
        holder.tvMarque.setText(singleItem.getMarque());
        holder.tvModel.setText(singleItem.getModel());
        holder.tvEtat.setText(singleItem.getEtat());
        holder.tvPrix.setText(String.valueOf(singleItem.getPrix()) + " DT");

        holder.btnDelete.setOnClickListener(view ->{
            AppDataBase.getInstance(mContext).voitureDao().delete(singleItem);
            voitureList.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return voitureList.size();
    }

    class FavsViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCar, btnDelete;
        private TextView tvMarque, tvModel, tvEtat, tvPrix;

        public FavsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCar = itemView.findViewById(R.id.imgCar);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            tvMarque = itemView.findViewById(R.id.tvMarque);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvEtat = itemView.findViewById(R.id.tvEtat);
            tvPrix = itemView.findViewById(R.id.tvPrix);

        }
    }
}
