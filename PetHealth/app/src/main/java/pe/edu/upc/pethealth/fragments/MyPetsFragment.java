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
import pe.edu.upc.pethealth.adapters.MyPetAdapters;
import pe.edu.upc.pethealth.models.MyPet;
import pe.edu.upc.pethealth.models.MyPetsRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPetsFragment extends Fragment {

    private RecyclerView myPetsRecyclerView;
    private MyPetAdapters myPetAdapters;
    private RecyclerView.LayoutManager myPetLayoutManager;
    List<MyPet> myPets;

    public MyPetsFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_pets, container, false);
        myPetsRecyclerView = (RecyclerView) view.findViewById(R.id.myPetsRecyclerView);
        myPets = new ArrayList<>();
        myPetAdapters = new MyPetAdapters(MyPetsRepository.getMyPets());
        myPetLayoutManager = new LinearLayoutManager(view.getContext());
        myPetsRecyclerView.setAdapter(myPetAdapters);
        myPetsRecyclerView.setLayoutManager(myPetLayoutManager);
        return view;

    }

}
