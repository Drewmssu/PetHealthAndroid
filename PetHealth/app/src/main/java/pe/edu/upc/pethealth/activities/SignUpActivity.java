package pe.edu.upc.pethealth.activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.DocumentType;
import pe.edu.upc.pethealth.network.PetHealthApiService;

public class SignUpActivity extends AppCompatActivity {

    Button doneButton;
    EditText birthDateEditText;
    DatePickerDialog datePickerDialog;
    List<DocumentType> documentTypeList;
    DocumentType documentType;
    String tag;
    Spinner documentTypeSpinner;
    EditText nameEditText;
    EditText lastNameEditText;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText addressEditText;
    EditText dniEditText;
    EditText emailEditText;

    //Crea el calendario para la vista con la fecha de hoy
    Calendar calendar = Calendar.getInstance();
    int yy = calendar.get(Calendar.YEAR);
    int mm = calendar.get(Calendar.MONTH);
    int dd = calendar.get(Calendar.DAY_OF_MONTH);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        documentTypeSpinner = (Spinner) findViewById(R.id.documentTypeSpinner);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        nameEditText =(EditText) findViewById(R.id.nameEditText);
        lastNameEditText=(EditText) findViewById(R.id.lastNameEditText);
        usernameEditText =(EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        addressEditText = (EditText) findViewById(R.id.addressTextInputEditText);
        dniEditText = (EditText) findViewById(R.id.dniEditText);
        emailEditText =(EditText) findViewById(R.id.emailEditText);
        birthDateEditText = (EditText) findViewById(R.id.birthDateEditText);
        birthDateEditText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Esconde el teclado en caso se haya clickeado algun otro view antes de este
                //para luego recien clickear el datepicker
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(birthDateEditText.getWindowToken(), 0);

                //Asignando el valor escogido en calendar al EditText para que se muestre
                datePickerDialog = new DatePickerDialog(SignUpActivity.this,
                        new DatePickerDialog.OnDateSetListener(){

                            @Override
                            public void onDateSet(DatePicker datePicker, int selectedYY, int selectedMM, int selectedDD) {
                                yy = selectedYY;
                                mm = selectedMM;
                                dd = selectedDD;
                                birthDateEditText.setText(dd + "/" + (mm+1) + "/" + yy);
                            }
                        },yy,mm,dd);
                calendar.set(yy,mm,dd);
                datePickerDialog.show();
            }
        });
        doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptToSignUp();
            }
        });

        documentTypeList = new ArrayList<DocumentType>();
        tag = "PetHealth";
        updateDocumentTypeList();
    }

    private void updateDocumentTypeList(){

        AndroidNetworking.get(PetHealthApiService.DOCTYPE_URL)
                .setTag(tag)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if("error".equalsIgnoreCase(response.getString("status"))){
                                Log.d(tag,response.getString("message"));
                                return;
                            }
                            documentTypeList = DocumentType.from(response.getJSONArray("documents"));

                            ArrayList<String> shortenings = new ArrayList<String>();
                            for (int i =0; i<documentTypeList.size();i++){
                                shortenings.add(documentTypeList.get(i).getShortening());
                            }

                            Spinner documentTypeSpinner = (Spinner)findViewById(R.id.documentTypeSpinner);
                            documentTypeSpinner.setAdapter(new ArrayAdapter<String>(
                                    SignUpActivity.this, android.R.layout.simple_spinner_item, shortenings));

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(tag, anError.getErrorBody());
                    }
                });
    }

    private void attemptPerson(JSONObject person){
        final Context context = this;
        System.out.println(person);
        AndroidNetworking.post(PetHealthApiService.SIGNUP_CUSTOMER)
                .addJSONObjectBody(person)
                .setTag(getString(R.string.app_name))
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if ("done".equalsIgnoreCase(response.getString("status"))){
                                Intent intent = new Intent(context, StartActivity.class);
                                context.startActivity(intent);
                            } else {
                                Log.d(getString(R.string.app_name), "Error with the Resgistration of Person");
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(getString(R.string.app_name), anError.getLocalizedMessage());
                    }
                });
    }
    private void attemptToSignUp() {
        //Reset Errors
        nameEditText.setError(null);
        passwordEditText.setError(null);
        usernameEditText.setError(null);
        lastNameEditText.setError(null);
        addressEditText.setError(null);
        dniEditText.setError(null);
        emailEditText.setError(null);
        birthDateEditText.setError(null);

        //Store values
        final String name = nameEditText.getText().toString();
        final String lastName= lastNameEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        final String address  =addressEditText.getText().toString();
        final String dni = dniEditText.getText().toString();
        final String birthDate = birthDateEditText.getText().toString();
        String email = emailEditText.getText().toString();
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        View focusView = null;
        Boolean cancel = false;

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            JSONObject user = new JSONObject();
            try {
                user.put("username",username);
                user.put("password",password);
                user.put("mail",email);

            }catch (JSONException e){
                e.printStackTrace();
            }

            AndroidNetworking.post(PetHealthApiService.SIGNUP_USER)
                    .addJSONObjectBody(user)
                    .setTag(getString(R.string.app_name))
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // do anything with response
                            try {
                                if ("done".equalsIgnoreCase(response.getString("status"))) {
                                    JSONObject person = new JSONObject();
                                    try {
                                        person.put("userId",response.getJSONObject("user").getString("UserId"));
                                        person.put("name", name);
                                        person.put("lastName",lastName);
                                        person.put("nrodocumento",dni);
                                        person.put("tipodocumento",1);
                                        person.put("adress",address);
                                        person.put("birthdate", format.parse(birthDate));
                                        person.put("phone","966991826");
                                        attemptPerson(person);
                                    }catch (JSONException e){
                                        e.printStackTrace();
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    Log.d(getString(R.string.app_name), "Error with the Resgistration of User");
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
}
