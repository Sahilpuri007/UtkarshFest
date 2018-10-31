package com.fest.utkarsh.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fest.utkarsh.AtlantusTabActivity;
import com.fest.utkarsh.CulturalTabActivity;
import com.fest.utkarsh.DexteriaTabActivity;
import com.fest.utkarsh.R;
import com.fest.utkarsh.RegEventActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ImageView img1,img2,img3;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        img1 =(ImageView)view.findViewById(R.id.imgcul);
        img2 =(ImageView)view.findViewById(R.id.imgatl);
        img3 =(ImageView)view.findViewById(R.id.imgdex);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CulturalTabActivity.class);//what do you want to display next
                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AtlantusTabActivity.class);//what do you want to display next
                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DexteriaTabActivity.class);//what do you want to display next
                startActivity(intent);
            }
        });


        return view;
    }

}
