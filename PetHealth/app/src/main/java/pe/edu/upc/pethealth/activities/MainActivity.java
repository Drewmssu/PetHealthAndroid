package pe.edu.upc.pethealth.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.fragments.ChatsFragment;
import pe.edu.upc.pethealth.fragments.HomeFragment;
import pe.edu.upc.pethealth.fragments.MyPetsFragment;
import pe.edu.upc.pethealth.fragments.NotificationsFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

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
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateAccordingTo(R.id.navigation_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //this adds items to the action bar if present
        getMenuInflater().inflate(R.menu.navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.action_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
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
