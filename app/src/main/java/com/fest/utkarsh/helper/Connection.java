package com.fest.utkarsh.helper;

import java.net.HttpURLConnection;
import java.net.URL;


public class Connection {
    public static HttpURLConnection getConnection(String filename)
    {
        HttpURLConnection connection=null;
        String path="http://utkarsh.uiit.ac.in/phps/"+filename;//#working
        try
        {
            URL url=new URL(path);
            connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.connect();
        }
        catch (Exception e)
        {
            Console.Log("Connection",e.toString());
        }
        return connection;
    }
}
