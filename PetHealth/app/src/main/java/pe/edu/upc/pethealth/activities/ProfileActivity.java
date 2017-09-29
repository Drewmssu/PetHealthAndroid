package pe.edu.upc.pethealth.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.Person;

public class ProfileActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private ImageView profilePictureImageView;
    private TextView nameTextView;
    private TextView lastNameTextView;
    private TextView dniTextView;
    private TextView addressTextView;
    private TextView phoneTextView;
    private TextView mailTextView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_mypets:
                    mTextMessage.setText(R.string.title_mypets);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_chat:
                    mTextMessage.setText(R.string.title_chat);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Person person = Person.from(getIntent().getExtras());
        profilePictureImageView = (ImageView) findViewById(R.id.personProfilePictureImageView);
        nameTextView = (TextView) findViewById(R.id.personNameTextView);
        lastNameTextView = (TextView) findViewById(R.id.personLastNameTextView);
        dniTextView = (TextView) findViewById(R.id.personDniTextView);
        addressTextView = (TextView) findViewById(R.id.personAddressTextView);
        phoneTextView = (TextView) findViewById(R.id.personPhoneTextView);
        mailTextView = (TextView) findViewById(R.id.personMailTextView);

        profilePictureImageView.setImageResource(person.getPhoto());
        nameTextView.setText(person.getName());
        lastNameTextView.setText(person.getLastName());
        dniTextView.setText(person.getDni());
        addressTextView.setText(person.getAddress());
        phoneTextView.setText(person.getPhone());
        mailTextView.setText(person.getMail());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
