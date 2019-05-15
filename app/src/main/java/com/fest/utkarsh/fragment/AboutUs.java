package com.fest.utkarsh.fragment;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fest.utkarsh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUs extends Fragment {


    WebView webViewOne, webViewTwo;
    public AboutUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        webViewOne=(WebView)view.findViewById(R.id.web_view_etsa);
        webViewTwo=(WebView)view.findViewById(R.id.web_view_tech);
        webViewOne.loadUrl("http://uiit.ac.in/about/etsa.php");
        WebSettings webSettingsOne=webViewOne.getSettings();
        webSettingsOne.setJavaScriptEnabled(true);
        webViewOne.setWebViewClient(new WebViewClient());
        webViewTwo.loadUrl("http://www.uiit.ac.in/about/technical_team.php");
        WebSettings webSettingsTwo=webViewTwo.getSettings();
        webSettingsTwo.setJavaScriptEnabled(true);
        webViewTwo.setWebViewClient(new WebViewClient());


        return view;
    }

}
