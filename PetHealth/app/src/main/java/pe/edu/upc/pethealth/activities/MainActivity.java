package pe.edu.upc.pethealth.activities;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.fragments.ChatsFragment;
import pe.edu.upc.pethealth.fragments.HomeFragment;
import pe.edu.upc.pethealth.fragments.MyPetsFragment;
import pe.edu.upc.pethealth.fragments.NotificationsFragment;
import pe.edu.upc.pethealth.fragments.ProfileFragment;
import pe.edu.upc.pethealth.fragments.SearchFragment;

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

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateAccordingTo(R.id.navigation_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //this adds items to the action bar if present
        getMenuInflater().inflate(R.menu.navigation_app_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.navigation_logout:
                finish();
                System.exit(0);
                return true;
            case R.id.navigation_profile:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, new ProfileFragment()).commit();
                return true;
            case R.id.navigation_search:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, new SearchFragment()).commit();
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
