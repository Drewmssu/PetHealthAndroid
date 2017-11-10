package pe.edu.upc.pethealth.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.activities.MainActivity;
import pe.edu.upc.pethealth.models.MyTip;

public class MyTipDetailFragment extends Fragment {

    ANImageView tipDetailANImageView;
    TextView tittleDetailTextView;
    TextView descriptionDetailTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_tip_detail, container, false);
        ((MainActivity)getActivity()).setFragmentToolbar("Tip",true,getFragmentManager());

        MyTip myTip = MyTip.from(getArguments());
        tipDetailANImageView = (ANImageView) view.findViewById(R.id.detailImageView);
        tittleDetailTextView =(TextView) view.findViewById(R.id.tittleDetailTextView);
        descriptionDetailTextView=(TextView) view.findViewById(R.id.descriptionDetailTextView);

        tipDetailANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        tipDetailANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        tipDetailANImageView.setImageUrl(myTip.getImage());
        tittleDetailTextView.setText(myTip.getTittle());
        descriptionDetailTextView.setText(myTip.getDescription());
        return  view;
    }
}
