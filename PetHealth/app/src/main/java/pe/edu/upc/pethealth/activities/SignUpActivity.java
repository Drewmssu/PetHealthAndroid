package pe.edu.upc.pethealth.activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import java.util.Calendar;
import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.DocumentType;
import pe.edu.upc.pethealth.network.PetHealthApiService;

public class SignUpActivity extends AppCompatActivity {

    Button doneButton;
    EditText birthDateEditText;
    DatePickerDialog datePickerDialog;
    RecyclerView documentTypeListRecyclerView;
    List<DocumentType> documentTypeList;
    DocumentType documentType;
    String tag;
    Spinner documentTypeSpinner;

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
                Context context = view.getContext();
                Intent intent = new Intent(context,StartActivity.class);
                context.startActivity(intent);
            }
        });

        documentTypeList = new ArrayList<>();
        documentType= DocumentType.from(getIntent().getExtras());
        tag = "PetHealth";

        updateDocumentTypeList();
    }

    private void updateDocumentTypeList(){
        String _id = Integer.toString(documentType.getId());

        AndroidNetworking.get(PetHealthApiService.DOCTYPE_URL)
                .addQueryParameter("id", _id)
                .addQueryParameter("name", documentType.getName())
                .addQueryParameter("shortening", documentType.getShortening())
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
                            documentTypeList = DocumentType.from(response.getJSONArray("documentTypeList"));

                            //adapter setDocumentTypes(documentTypeList);
                            //adapter notifyDataSetChanged();
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
}
