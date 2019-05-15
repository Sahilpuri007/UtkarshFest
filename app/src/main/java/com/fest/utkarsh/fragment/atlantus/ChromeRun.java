package com.fest.utkarsh.fragment.atlantus;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fest.utkarsh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChromeRun extends Fragment {

    Button btnregister;
    public ChromeRun() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        View view = inflater.inflate(R.layout.fragment_chrome_run, container, false);
        btnregister = (Button) view.findViewById(R.id.btn_one);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getActivity(), HomeActivity.class);//what do you want to display next
                //startActivity(intent);
                //Fragment fragment = new RegEvent();
                //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.replace(R.id.content_main, fragment);
                //fragmentTransaction.commit();

            }
        });
        return view;
    }

}
