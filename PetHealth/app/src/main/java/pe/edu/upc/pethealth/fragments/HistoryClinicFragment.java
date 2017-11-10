package pe.edu.upc.pethealth.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.activities.MainActivity;

public class HistoryClinicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO make sure that you put the bundle of the history clinic in the Arguments for this to work
        // HistoryClinic hc = getArguments();
        View view = inflater.inflate(R.layout.fragment_history_clinic, container, false);
        ((MainActivity)getActivity()).setFragmentToolbar("History Clinic",true,getFragmentManager());
        return view;
    }
}
