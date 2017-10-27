package pe.edu.upc.pethealth.activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

import pe.edu.upc.pethealth.R;

public class SingUpActivity extends AppCompatActivity {

    Button doneButton;
    EditText birthDateEditText;
    DatePickerDialog datePickerDialog;

    Calendar calendar = Calendar.getInstance();
    int yy = calendar.get(Calendar.YEAR);
    int mm = calendar.get(Calendar.MONTH);
    int dd = calendar.get(Calendar.DAY_OF_MONTH);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        birthDateEditText = (EditText) findViewById(R.id.birthDateEditText);
        birthDateEditText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Esconde el teclado en caso se haya clickeado algun otro view antes de este
                //para luego recien clickear el datepicker
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(birthDateEditText.getWindowToken(), 0);

                //Asignando el valor escogido en calendar al EditText para que se muestre
                datePickerDialog = new DatePickerDialog(SingUpActivity.this,
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
    }
}
