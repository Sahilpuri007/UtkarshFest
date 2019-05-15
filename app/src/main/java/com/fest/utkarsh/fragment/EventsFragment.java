package com.fest.utkarsh.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fest.utkarsh.activity.AtlPlayerActivity;
import com.fest.utkarsh.activity.AtlantusTabActivity;
import com.fest.utkarsh.activity.CulturalTabActivity;
import com.fest.utkarsh.activity.DexPlayerActivity;
import com.fest.utkarsh.activity.DexteriaTabActivity;
import com.fest.utkarsh.R;
import com.fest.utkarsh.activity.UtPlayerActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {


    Button btn,btn2,btn3,btn4,btn5,btn6;
    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        btn =(Button)view.findViewById(R.id.btn_one);
        btn2 =(Button)view.findViewById(R.id.btn_two);
        btn3 =(Button)view.findViewById(R.id.btn_three);
        btn4 =(Button)view.findViewById(R.id.btn__four);
        btn5 =(Button)view.findViewById(R.id.btn_five);
        btn6 =(Button)view.findViewById(R.id.btn_six);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AtlantusTabActivity.class);//what do you want to display next
                startActivity(intent);            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AtlPlayerActivity.class);//what do you want to display next
                startActivity(intent);            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CulturalTabActivity.class);//what do you want to display next
                startActivity(intent);           }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UtPlayerActivity.class);//what do you want to display next
                startActivity(intent);            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DexteriaTabActivity.class);//what do you want to display next
                startActivity(intent);            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DexPlayerActivity.class);//what do you want to display next
                startActivity(intent);           }
        });
        return view;
    }


}
