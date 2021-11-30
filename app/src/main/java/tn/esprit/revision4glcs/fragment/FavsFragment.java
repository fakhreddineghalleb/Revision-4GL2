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
import tn.esprit.revision4glcs.adapters.FavsAdapter;
import tn.esprit.revision4glcs.adapters.RentAdapter;
import tn.esprit.revision4glcs.models.Voiture;
import tn.esprit.revision4glcs.utils.AppDataBase;

public class FavsFragment extends Fragment {

    private RecyclerView recyclerFav;
    private FavsAdapter adapter;

    private List<Voiture> voitures = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_favs, container, false);

        recyclerFav = rootView.findViewById(R.id.recyclerFavs);

        voitures = AppDataBase.getInstance(getActivity()).voitureDao().getAll();

        adapter = new FavsAdapter(voitures, getActivity());

        recyclerFav.setAdapter(adapter);

        recyclerFav.setLayoutManager(new LinearLayoutManager(getActivity()
                , LinearLayoutManager.VERTICAL, false));
        return rootView;
    }
}
