package com.fest.utkarsh.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.fest.utkarsh.R;

public class SplashActivity extends Activity {

    class Splash implements Runnable{
        Splash(){
        }

        public void run(){
            SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Splash(), (long) 3000);


        // added some comment
        // added some more comment

    }
}
