package pe.edu.upc.pethealth.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.models.MyTip;

public class MyTipDetailActivity extends AppCompatActivity {

    ANImageView tipDetailANImageView;
    TextView tittleDetailTextView;
    TextView descriptionDetailTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tip_detail);
        MyTip myTip = MyTip.from(getIntent().getExtras());
        tipDetailANImageView = (ANImageView) findViewById(R.id.detailImageView);
        tittleDetailTextView =(TextView) findViewById(R.id.tittleDetailTextView);
        descriptionDetailTextView=(TextView) findViewById(R.id.descriptionDetailTextView);

        tipDetailANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        tipDetailANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        tipDetailANImageView.setImageUrl(myTip.getImage());
        tittleDetailTextView.setText(myTip.getTittle());
        descriptionDetailTextView.setText(myTip.getDescription());
    }
}
