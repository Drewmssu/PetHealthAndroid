package pe.edu.upc.pethealth.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.fragments.ChatsFragment;
import pe.edu.upc.pethealth.fragments.HomeFragment;
import pe.edu.upc.pethealth.fragments.MyPetsFragment;
import pe.edu.upc.pethealth.fragments.NotificationsFragment;
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
            return navigateAccordingTo(item.getItemId());
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Person person = new Person(1,R.mipmap.ic_launcher,"123456@gmail.com","Renato","Castro","76249104","Av.Salvarry","966991826");

        Toolbar myToolBar= (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(myToolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

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

    private boolean navigateAccordingTo(int id){
        try{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content,getFragmentFor(id)).commit();
            return true;
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    private Fragment getFragmentFor(int id){
        switch (id){
            case R.id.navigation_home: return new HomeFragment();
            case R.id.navigation_mypets: return new MyPetsFragment();
            case R.id.navigation_chat: return new ChatsFragment();
            case R.id.navigation_notifications: return new NotificationsFragment();
        }
        return null;
    }
}
