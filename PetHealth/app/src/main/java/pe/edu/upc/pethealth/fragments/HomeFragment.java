package pe.edu.upc.pethealth.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.adapters.MyTipAdapters;
import pe.edu.upc.pethealth.models.MyTip;
import pe.edu.upc.pethealth.models.MyTipsRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView myTipRecyclerView;
    MyTipAdapters myTipAdapters;
    RecyclerView.LayoutManager myTipLayoutManager;
    List<MyTip> myTips;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        myTipRecyclerView = (RecyclerView) view.findViewById(R.id.myTipRecyclerView);
        myTips = new ArrayList<>();
        myTipAdapters = new MyTipAdapters(MyTipsRepository.getMyTips());
        myTipLayoutManager = new LinearLayoutManager(view.getContext());
        myTipRecyclerView.setAdapter(myTipAdapters);
        myTipRecyclerView.setLayoutManager(myTipLayoutManager);
        return view;
    }

}
