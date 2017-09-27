package pe.edu.upc.pethealth.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.MyPet;

public class MyPetDescriptionActivity extends AppCompatActivity {
    ImageView myPetImageView;
    TextView nameTextView;
    TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pet_description);

        MyPet myPet = MyPet.from(getIntent().getExtras());
        myPetImageView = (ImageView) findViewById(R.id.myPetImageView);
        nameTextView = (TextView) findViewById(R.id.petNameTextView);
        descriptionTextView = (TextView) findViewById(R.id.myPetDescriptionTextView);

        myPetImageView.setImageResource(myPet.getImage());
        nameTextView.setText(myPet.getName());
        descriptionTextView.setText(myPet.getDescription());

    }
}
