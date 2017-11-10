package pe.edu.upc.pethealth.fragments;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.activities.MainActivity;
import pe.edu.upc.pethealth.adapters.MyPetAdapters;
import pe.edu.upc.pethealth.models.MyPet;
import pe.edu.upc.pethealth.network.PetHealthApiService;
import pe.edu.upc.pethealth.repositories.MyPetsRepository;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyPetsFragment extends Fragment {

    private RecyclerView myPetsRecyclerView;
    private MyPetAdapters myPetAdapters;
    private RecyclerView.LayoutManager myPetLayoutManager;
    private FloatingActionButton addPetFloatingActionButton;
    List<MyPet> myPets;

    public MyPetsFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).setFragmentToolbar("My Pets",false,getFragmentManager());
        View view =  inflater.inflate(R.layout.fragment_my_pets, container, false);
        myPetsRecyclerView = (RecyclerView) view.findViewById(R.id.myPetsRecyclerView);
        myPets = new ArrayList<>();
        myPetAdapters = new MyPetAdapters(myPets);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            myPetLayoutManager = new GridLayoutManager(view.getContext(), 1);
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            myPetLayoutManager = new GridLayoutManager(view.getContext(), 2);
        }
        myPetsRecyclerView.setAdapter(myPetAdapters);
        myPetsRecyclerView.setLayoutManager(myPetLayoutManager);
        addPetFloatingActionButton = (FloatingActionButton) view.findViewById(R.id.addPetFloatingActionButton);
        addPetFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "title", Snackbar.LENGTH_LONG)
                        .setAction("title2", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });
        updatePets();
        return view;
    }

    private void updatePets(){
        AndroidNetworking.get(PetHealthApiService.PET_URL)
                .setPriority(Priority.LOW)
                .setTag(R.string.app_name)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            myPets = MyPet.from(response.getJSONArray("content"));
                            myPetAdapters.setMyPets(myPets);
                            myPetAdapters.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }


}
