package com.fest.utkarsh.helper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Console {
    public  static void Toast(Context context, String msg)
    {
        Toast.makeText((Context) context,msg,Toast.LENGTH_LONG).show();
    }
    public static void Log(String LogName,String msg)
    {
        Log.d(LogName,msg);
    }
}

