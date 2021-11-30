package tn.esprit.revision4glcs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.revision4glcs.R;
import tn.esprit.revision4glcs.models.Voiture;
import tn.esprit.revision4glcs.utils.AppDataBase;

public class RentAdapter extends RecyclerView.Adapter<RentAdapter.RentViewHolder> {

    private List<Voiture> voitureList;
    private Context mContext;

    public RentAdapter(List<Voiture> voitureList, Context mContext) {
        this.voitureList = voitureList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext)
                .inflate(R.layout.single_row_rent, parent, false);

        return new RentViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RentViewHolder holder, int position) {
        Voiture singleItem = voitureList.get(position);

        holder.imgCar.setImageResource(singleItem.getImage());
        holder.tvMarque.setText(singleItem.getMarque());
        holder.tvModel.setText(singleItem.getModel());
        holder.tvEtat.setText(singleItem.getEtat());
        holder.tvPrix.setText(String.valueOf(singleItem.getPrix()) + " DT");

        holder.btnAdd.setOnClickListener(view ->{
            try{
                AppDataBase.getInstance(mContext).voitureDao().insert(singleItem);
            }catch(Exception exception) {
                Toast.makeText(mContext, "Voiture existe!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return voitureList.size();
    }

    class RentViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCar, btnAdd;
        private TextView tvMarque, tvModel, tvEtat, tvPrix;

        public RentViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCar = itemView.findViewById(R.id.imgCar);
            btnAdd = itemView.findViewById(R.id.btnAdd);

            tvMarque = itemView.findViewById(R.id.tvMarque);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvEtat = itemView.findViewById(R.id.tvEtat);
            tvPrix = itemView.findViewById(R.id.tvPrix);

        }
    }
}
