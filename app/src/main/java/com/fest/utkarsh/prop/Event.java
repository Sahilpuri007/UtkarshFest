package com.fest.utkarsh.prop;

import com.fest.utkarsh.helper.Console;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Event {

    String name,email,college,phone,category,event,member;

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public HashMap<String,String> insert()
    {
        HashMap<String,String>param= new HashMap<>();
        param.put("name",getName());
        param.put("email",getEmail());
        param.put("college",getCollege());
        param.put("contact",getPhone());
        param.put("category",getCategory());
        param.put("event",getEvent());
        param.put("member",getMember());
        return param;
    }
    public String encodeData(HashMap<String,String> param)
    {
        StringBuilder result =new StringBuilder();
        boolean first=true;
        try{
            for(Map.Entry<String,String> entry :param.entrySet()) {
                if (first)
                    first=false;
                else
                    result.append("&");
                result.append(URLEncoder.encode(entry.getKey(),"UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(),"UTF-8"));
            }
        }
        catch (Exception e)
        {
            Console.Log("Data",e.toString());
        }
        return result.toString();
    }
    public String postData()
    {
        HashMap<String,String>param=insert();
        return encodeData(param);
    }
}
