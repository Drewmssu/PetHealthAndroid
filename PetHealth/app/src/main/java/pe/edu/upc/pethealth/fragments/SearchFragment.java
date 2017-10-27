package pe.edu.upc.pethealth.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.adapters.SearchAdapters;
import pe.edu.upc.pethealth.models.Veterinary;
import pe.edu.upc.pethealth.repositories.VeterinariesRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private RecyclerView searchRecyclerView;
    private SearchAdapters searchAdapters;
    private RecyclerView.LayoutManager searchLayoutManager;
    private List<Veterinary> veterinaries;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchRecyclerView = (RecyclerView) view.findViewById(R.id.searchRecyclerView);
        veterinaries = new ArrayList<>();
        searchAdapters = new SearchAdapters(VeterinariesRepository.getList());
        searchLayoutManager = new LinearLayoutManager(view.getContext());
        searchRecyclerView.setAdapter(searchAdapters);
        searchRecyclerView.setLayoutManager(searchLayoutManager);
        return view;
    }

}
