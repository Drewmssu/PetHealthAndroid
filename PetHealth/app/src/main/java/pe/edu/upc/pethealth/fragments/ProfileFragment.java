package pe.edu.upc.pethealth.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView tittleTextView;
    ANImageView photoANImageView;
    TextView nameTextView;
    TextView lastNameTextView;
    TextView dniTextView;
    TextView mailTextView;
    TextView phoneTextView;
    TextView addressTextView;
    Button editButton;
    Person person;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
      //  person = new Person(1,R.mipmap.ic_launcher_round,"Jesus","Cueto","76219104","juanjesus@gmail.com","966991826","Av.Salaveryy 2526");
        tittleTextView = (TextView) view.findViewById(R.id.tittleTextView);
        photoANImageView = (ANImageView) view.findViewById(R.id.photoANImageView);
        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        lastNameTextView = (TextView) view.findViewById(R.id.lastnameTextView);
        dniTextView = (TextView) view.findViewById(R.id.dniTextView);
        mailTextView = (TextView) view.findViewById(R.id.mailTextView);
        phoneTextView =(TextView) view.findViewById(R.id.phoneTextView);
        addressTextView = (TextView) view.findViewById(R.id.addressTextView);
        editButton = (Button) view.findViewById(R.id.editValuesButton);

        photoANImageView.setDefaultImageResId(R.mipmap.ic_launcher_round);
        photoANImageView.setErrorImageResId(R.mipmap.ic_launcher_round);
        photoANImageView.setImageUrl("https://www.facebook.com/photo.php?fbid=540765639424050&set=a.204856629681621.1073741825.100004718550830&type=3&theater");
        nameTextView.setText(person.getName());
        lastNameTextView.setText(person.getLastName());
        dniTextView.setText(person.getDni());
        mailTextView.setText(person.getMail());
        phoneTextView.setText(person.getPhone());
        addressTextView.setText(person.getAddress());
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

}
