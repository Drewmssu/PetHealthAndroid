package pe.edu.upc.pethealth.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.MyPet;

public class MyPetDescriptionActivity extends AppCompatActivity {

    TextView nameTextView;
    ImageView myPetImageView;
    TextView descriptionTextView;
    TextView raceTextView;
    TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pet_description);

        MyPet myPet = MyPet.from(getIntent().getExtras());
        nameTextView = (TextView) findViewById(R.id.petNameTextView);
        myPetImageView  =(ImageView) findViewById(R.id.myPetImageView);
        raceTextView = (TextView) findViewById(R.id.petRaceTextView);
        ageTextView= (TextView) findViewById(R.id.petAgeTextView);
        descriptionTextView = (TextView) findViewById(R.id.petDescriptionTextView);

        nameTextView.setText(myPet.getName());
        myPetImageView.setImageResource(myPet.getImage());
        raceTextView.setText(myPet.getRace());
        ageTextView.setText(Integer.toString(myPet.getAge()));
        descriptionTextView.setText(myPet.getDescription());

    }
}
