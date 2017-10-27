package pe.edu.upc.pethealth.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.pethealth.R;

public class StartActivity extends AppCompatActivity {

    private ImageView logoImageView;
    private EditText userEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private TextView signUptextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
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

        // Store values at the time of the login attempt.
        String email = userEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordEditText.setError(getString(R.string.error_invalid_password));
            focusView = passwordEditText;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            userEditText.setError(getString(R.string.error_field_required));
            focusView = userEditText;
            cancel = true;
        } else if (!isEmailValid(email)) {
            userEditText.setError(getString(R.string.error_invalid_email));
            focusView = userEditText;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            Context context = this;
            Intent intent = new Intent(context,MainActivity.class);
            context.startActivity(intent);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
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
