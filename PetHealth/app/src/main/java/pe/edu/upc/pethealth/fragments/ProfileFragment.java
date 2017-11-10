package pe.edu.upc.pethealth.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.widget.ANImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.activities.MainActivity;
import pe.edu.upc.pethealth.models.Person;
import pe.edu.upc.pethealth.network.PetHealthApiService;

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
        ((MainActivity)getActivity()).setFragmentToolbar("Profile",true,getFragmentManager());
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Bundle b = getArguments();
        AndroidNetworking.get(PetHealthApiService.CUSTOMER_URL+"/"+String.valueOf(b.getInt("user_id")))
                .setPriority(Priority.LOW)
                .setTag(R.string.app_name)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject res = response.getJSONArray("res").getJSONObject(0);
                            person = new Person(res.getInt("id"),
                                    res.getString("name"),
                                    res.getString("lastname"),
                                    res.getString("nrodocumento"),
                                    res.getString("phone"),
                                    res.getString("address")
                                    );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
        //person = new Person(1,"Jesus","Cueto","76219104","966991826","Av.Salaveryy 2526");
        tittleTextView = (TextView) view.findViewById(R.id.tittleTextView);
        photoANImageView = (ANImageView) view.findViewById(R.id.photoANImageView);
        nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        lastNameTextView = (TextView) view.findViewById(R.id.lastNameTextView);
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
