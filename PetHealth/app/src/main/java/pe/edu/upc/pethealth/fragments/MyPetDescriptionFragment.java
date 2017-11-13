package pe.edu.upc.pethealth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.androidnetworking.widget.ANImageView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.activities.MainActivity;
import pe.edu.upc.pethealth.models.MyPet;

public class MyPetDescriptionFragment extends Fragment {

    TextView nameTextView;
    ANImageView myPetImageView;
    TextView descriptionTextView;
    TextView raceTextView;
    TextView ageTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyPet myPet = MyPet.from(getArguments());
        String petName = myPet.getName()+"'s Description";
        ((MainActivity)getActivity()).setFragmentToolbar(petName,true,getFragmentManager());
        View view = inflater.inflate(R.layout.fragment_my_pet_description, container, false);

        nameTextView = (TextView) view.findViewById(R.id.petNameTextView);
        myPetImageView  =(ANImageView) view.findViewById(R.id.myPetImageView);
        raceTextView = (TextView) view.findViewById(R.id.petRaceTextView);
        ageTextView= (TextView) view.findViewById(R.id.petAgeTextView);
        descriptionTextView = (TextView) view.findViewById(R.id.petDescriptionTextView);

        nameTextView.setText(myPet.getName());
        myPetImageView.setImageUrl(myPet.getImage());
        raceTextView.setText(myPet.getRace());
        ageTextView.setText((myPet.getAge()));
        descriptionTextView.setText(myPet.getDescription());
        return view;
    }
}
