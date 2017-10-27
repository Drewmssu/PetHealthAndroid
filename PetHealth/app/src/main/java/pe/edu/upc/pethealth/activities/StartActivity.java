package pe.edu.upc.pethealth.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.User;
import pe.edu.upc.pethealth.network.PetHealthApiService;

public class StartActivity extends AppCompatActivity {

    private ImageView logoImageView;
    private EditText userEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private Button signUpBtutton;
    private User user;
    private TextView signUptextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        user = new User();
        logoImageView = (ImageView) findViewById(R.id.logoImageView);
        userEditText = (EditText) findViewById(R.id.emailEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextView);
        signInButton = (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        signUptextView = (TextView) findViewById(R.id.signUpTextView);
        signUptextView.setPaintFlags(signUptextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        signUptextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, SignUpActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.navigation_app_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void attemptLogin() {


        // Reset errors.
        userEditText.setError(null);
        passwordEditText.setError(null);
        final Context context = this;

        // Store values at the time of the login attempt.
        String email = userEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError(getString(R.string.error_field_required));
            focusView = passwordEditText;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            userEditText.setError(getString(R.string.error_field_required));
            focusView = userEditText;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

            AndroidNetworking.post(PetHealthApiService.LOGIN_URL)
                    .addBodyParameter("username", email)
                    .addBodyParameter("password", password)
                    .setTag(getString(R.string.app_name))
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // do anything with response
                            try {
                                if ("success".equalsIgnoreCase(response.getString("status"))) {
                                   // user = user.from(response.getJSONObject("userLog"));
                                    Intent intent = new Intent(context, MainActivity.class);
                                    //intent.putExtras(user.toBundle());
                                    context.startActivity(intent);
                                } else {
                                    Log.d(getString(R.string.app_name), "User and password are incorrect");
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.d(getString(R.string.app_name), anError.getLocalizedMessage());
                        }
                    });
        }
    }

    private boolean isEmailValid(String email) {
        if(email.equals("admin"))
            return true;
        else
            return false;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        if(password.equals("admin"))
            return true;
        else
            return false;
    }
}
