package com.fest.utkarsh.dal;

import android.content.Context;

import com.fest.utkarsh.helper.Connection;
import com.fest.utkarsh.helper.Console;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;


public class Data {
    public int insert(Context context,String data,String filename)
    {
        HttpURLConnection connection= null;
        StringBuilder stringBuilder =new StringBuilder();
        String line="";
        try
        {
            connection=Connection.getConnection(filename);
            OutputStream outputStream=connection.getOutputStream();
            OutputStreamWriter outputStreamWriter =new OutputStreamWriter(outputStream,"UTF-8");
            BufferedWriter bufferedWriter =new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader =new InputStreamReader(inputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
            if(bufferedReader !=null){
                while((line = bufferedReader.readLine()) !=null){
                    stringBuilder.append(line+"\n");
                    Console.Log("ERROR IN DATA",""+stringBuilder);
                }
            }
            else
            {
                Console.Log("Connection Error","Server didnt send any data");
            }
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            Console.Log("jsonObject",jsonObject.toString());
            int x=jsonObject.getInt("code");//php return
            connection.disconnect();
            return x;
        }
        catch (Exception e)
        {
            Console.Log("DATA",e.toString());
            return -1;
        }
    }

}
