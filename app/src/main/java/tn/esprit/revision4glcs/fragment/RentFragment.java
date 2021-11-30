package tn.esprit.revision4glcs.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.revision4glcs.R;
import tn.esprit.revision4glcs.adapters.RentAdapter;
import tn.esprit.revision4glcs.models.Voiture;

public class RentFragment extends Fragment {

    private RecyclerView recyclerRent;
    private RentAdapter adapter;

    private List<Voiture> voitures = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_rent, container, false);

        recyclerRent = rootView.findViewById(R.id.recyclerRent);

        voitures.add(new Voiture(1, R.drawable.kia_picanto, "KIA", "Picanto", "Disponible", 90));
        voitures.add(new Voiture(2, R.drawable.kia_rio, "KIA", "Picanto", "Disponible", 90));
        voitures.add(new Voiture(3, R.drawable.polo8, "Volswagen", "Polo 8", "Disponible", 90));
        voitures.add(new Voiture(4, R.drawable.polo_sedan, "Volswagen", "Polo Sedan", "Disponible", 90));
        voitures.add(new Voiture(5, R.drawable.renault_kaptur, "Renault", "Kaptur", "Disponible", 90));
        voitures.add(new Voiture(6, R.drawable.renault_symbol, "Renault", "Symbol", "Disponible", 90));
        voitures.add(new Voiture(7, R.drawable.seat_ibiza, "SEAT", "Ibiza", "Disponible", 90));
        voitures.add(new Voiture(8, R.drawable.seat_leon, "SEAT", "Leon", "Disponible", 250));

        adapter = new RentAdapter(voitures, getActivity());

        recyclerRent.setAdapter(adapter);

        recyclerRent.setLayoutManager(new LinearLayoutManager(getActivity()
                , LinearLayoutManager.VERTICAL, false));

        return rootView;
    }
}
