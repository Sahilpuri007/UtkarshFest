package com.fest.utkarsh.fragments.dexteria;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fest.utkarsh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoogleHunt extends Fragment {


    public GoogleHunt() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_google_hunt, container, false);
    }

}