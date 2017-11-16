package pe.edu.upc.pethealth.activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.User;
import pe.edu.upc.pethealth.network.PetHealthApiService;

public class AddPetActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText raceEditText;
    EditText birthDateEditText;
    EditText descriptionEditText;
    Button addButton;
    DatePickerDialog datePickerDialog;
    private User user;

    Calendar calendar = Calendar.getInstance();
    int yy= calendar.get(Calendar.YEAR);
    int mm = calendar.get(Calendar.MONTH);
    int dd = calendar.get(Calendar.DAY_OF_MONTH);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_petToolbar);
        setSupportActionBar(myToolbar);
        user = User.from(getIntent().getExtras());
       // getActionBar().setDisplayHomeAsUpEnabled(true);
        nameEditText = (EditText) findViewById(R.id.petNameTextView);
        raceEditText = (EditText) findViewById(R.id.petRaceEditText);
        descriptionEditText = (EditText) findViewById(R.id.petDescriptionEditText);
        addButton = (Button) findViewById(R.id.addPetButton); 
        birthDateEditText = (EditText) findViewById(R.id.birthDateEditText);
        birthDateEditText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Esconde el teclado en caso se haya clickeado algun otro view antes de este
                //para luego recien clickear el datepicker
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(birthDateEditText.getWindowToken(), 0);

                //Asignando el valor escogido en calendar al EditText para que se muestre
                datePickerDialog = new DatePickerDialog(AddPetActivity.this,
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
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attempToAddPet();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void attempToAddPet() {

        nameEditText.setError(null);
        raceEditText.setError(null);
        descriptionEditText.setError(null);
        birthDateEditText.setError(null);
        final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        View focusView = null;
        Boolean cancel = false;
        final Context context = this;
        final String name = nameEditText.getText().toString();
        final String race = raceEditText.getText().toString();
        final String birthDate = birthDateEditText.getText().toString();
        final String description = descriptionEditText.getText().toString();

        if(TextUtils.isEmpty(name)) {
            nameEditText.setError("This field is required");
            focusView = nameEditText;
            cancel = true;
        }

        if(TextUtils.isEmpty(race)) {
            raceEditText.setError("This field is required");
            focusView = raceEditText;
            cancel = true;
        }

        if(TextUtils.isEmpty(birthDate)) {
            birthDateEditText.setError("This field is required");
            focusView = birthDateEditText;
            cancel = true;
        }

        if(TextUtils.isEmpty(description)) {
            descriptionEditText.setError("This field is required");
            focusView = descriptionEditText;
            cancel = true;
        }
        if(cancel) {
            focusView.requestFocus();
        } else {
            JSONObject pet = new JSONObject();
            try {
                pet.put("ownerId", user.getUserId());
                pet.put("name", name);
                pet.put("race",race);
                pet.put("description",description);
                pet.put("birthDate",format.format(format.parse(birthDate)));
                pet.put("animalType",1);
            }catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(pet);
            AndroidNetworking.post(PetHealthApiService.ADD_PET_URL)
                    .addJSONObjectBody(pet)
                    .setTag(getString(R.string.app_name))
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if ("success".equalsIgnoreCase(response.getString("message"))) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                    builder.setMessage("Your Pet was successfully added");
                                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                            finish();
                                        }
                                    });
                                    AlertDialog alertDialog = builder.create();
                                    alertDialog.show();
                                } else {
                                    Log.d(getString(R.string.app_name), "Error with the Resgistration of Pet");
                                }
                            }catch (JSONException e) {
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
