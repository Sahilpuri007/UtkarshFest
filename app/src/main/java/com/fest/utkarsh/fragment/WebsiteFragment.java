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
import android.widget.ImageView;
import android.widget.TextView;

import com.fest.utkarsh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebsiteFragment extends Fragment {

    TextView txtutk,txtuiit;
    ImageView imguiit, imgutkarsh;
    WebView webView;

    public WebsiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        View view = inflater.inflate(R.layout.fragment_website, container, false);
        txtutk=(TextView)view.findViewById(R.id.txt_utk);
        txtuiit=(TextView)view.findViewById(R.id.txt_uiit);
        imguiit=(ImageView)view.findViewById(R.id.img_uiit);
        imgutkarsh=(ImageView)view.findViewById(R.id.img_utk);
        webView=(WebView)view.findViewById(R.id.web_view);

        imguiit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtuiit.setText("U.I.I.T WEBSITE");
                txtutk.setText("Utkarsh website");
                webView.loadUrl("http://www.uiit.ac.in");
                WebSettings webSettings=webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
            }
        });
        imgutkarsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtutk.setText("UTKARSH WEBSITE");
                txtuiit.setText("Uiit Website");
                webView.loadUrl("http://www.utkarsh.uiit.ac.in");
                WebSettings webSettings=webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());

            }
        });

        return view;
    }
}
