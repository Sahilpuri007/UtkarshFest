package com.fest.utkarsh.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fest.utkarsh.dal.Data;
import com.fest.utkarsh.helper.Console;
import com.fest.utkarsh.prop.Event;
import com.fest.utkarsh.R;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegEvent extends Fragment {


    TextInputEditText txtname, txtemail, txtclgname, txtphone;
    Spinner spinCat, spinEvent, spinMem;
    Button btnregevent;
    String categoryls[] = {"Cultural", "Dexteria", "Atlantus"};
    String eventcul[] = {"Dharhohar", "Footloose", "Dramaturgy", "Asthetica", "Dance Off", "Rampage", "Debate", "Drawing/Painting"};
    String eventdex[] = {"Quibble", "Design X", "Winshoot", "Google Hunt", "Web Weaver", "Problematic"};
    String eventatl[] = {"CS 1.6", "CS Go", "Tekken", "NFS", "FIFA", "Mario Mod", "Chrome Run"};//check for more
    String s[] = {"Single"};
    String sd[] = {"Single", "Double"};
    String g[] = {"Group"};
    String sg[] = {"Single", "Group"};
    String test[] = {"test"};


    public RegEvent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_reg_event, container, false);
        txtname = (TextInputEditText) view.findViewById(R.id.name);
        txtemail = (TextInputEditText) view.findViewById(R.id.email);
        txtclgname = (TextInputEditText) view.findViewById(R.id.clgname);
        txtphone = (TextInputEditText) view.findViewById(R.id.phone);
        spinCat = (Spinner) view.findViewById(R.id.catSpinner);
        spinEvent = (Spinner) view.findViewById(R.id.eventSpinner);
        spinMem = (Spinner) view.findViewById(R.id.memberSpinner);
        btnregevent = (Button) view.findViewById(R.id.btnregevent);

        // ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,test);
        //spinEvent.setAdapter(arrayAdapter);
        //spinMem.setAdapter(arrayAdapter);
        //spinCat.setAdapter(arrayAdapter);
        ArrayAdapter catadp = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, categoryls);
        spinCat.setAdapter(catadp);

        spinCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String scat = spinCat.getSelectedItem().toString();

                if (scat.equals("Cultural")) {
                    ArrayAdapter eventadp = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, eventcul);
                    spinEvent.setAdapter(eventadp);
                }
                if (scat.equals("Dexteria")) {
                    ArrayAdapter eventadp = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, eventdex);
                    spinEvent.setAdapter(eventadp);
                }
                if (scat.equals("Atlantus")) {
                    ArrayAdapter eventadp = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, eventatl);
                    spinEvent.setAdapter(eventadp);
                }

                spinEvent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String event = spinEvent.getSelectedItem().toString();

                        if (event.equals("Dharhohar") || event.equals("Footloose") || event.equals("Dramaturgy") || event.equals("Asthetica")  || event.equals("CS 1.6") || event.equals("CS Go")) {
                            ArrayAdapter memadp = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, g);
                            spinMem.setAdapter(memadp);
                        }
                        if (event.equals("Dance Off") || event.equals("Quibble")) {
                            ArrayAdapter memadp = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, sd);
                            spinMem.setAdapter(memadp);
                        }
                        if (event.equals("Rampage")) {
                            ArrayAdapter memadp = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, sg);
                            spinMem.setAdapter(memadp);
                        }
                        if (event.equals("Debate") || event.equals("Drawing/Painting") || event.equals("Design X") || event.equals("Winshoot") || event.equals("Google Hunt") || event.equals("Web Weaver") || event.equals("Aperture") || event.equals("Problematic") || event.equals("Tekken") || event.equals("NFS") || event.equals("FIFA") || event.equals("Mario Mod") || event.equals("Chrome Run")) {
                            ArrayAdapter memadp = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, s);
                            spinMem.setAdapter(memadp);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        btnregevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Console.Log("BTN REG EVENT", "Clicked or not");
                if(validate()==false)
                {
                    Console.Toast(getActivity().getApplicationContext(), "Not Valid");
                }
                else
                {
                    Console.Toast(getActivity().getApplicationContext(), "Valid");
                    //Console.Toast(getActivity().getApplicationContext(),name+"");
                    register();
                }

                //insertRegEvent();//FUNCTION CALL,DECLARATION AT BOTTOM
            }
        });


        return view;
    }

    private void register() {
        Console.Toast(getActivity(),"called");
        String name = txtname.getText().toString();
        String email = txtemail.getText().toString();
        String college = txtclgname.getText().toString();
        String phone = txtphone.getText().toString();
        Event event =new Event();

        event.setName(name);
        event.setEmail(email);
        event.setCollege(college);
        event.setPhone(phone);
        event.setCategory(spinCat.getSelectedItem().toString());
        event.setEvent(spinEvent.getSelectedItem().toString());
        event.setMember(spinMem.getSelectedItem().toString());
        String data = event.postData();
        Data d = new Data();
        Console.Toast(getActivity().getApplicationContext()," "+data);
        int ret = d.insert(getActivity().getParent(),data,"regevent.php");
        Console.Toast(getActivity().getApplicationContext()," "+ret);
        if(ret == 0)
        {
            Console.Toast(getActivity(),"Event Registered Succesfully");
            //Intent intent = new Intent(getActivity(), DrawerMain.class);//set Class here!!!!!!!!
            //startActivity(intent);
        }
        else if (ret == 1) {
            Console.Toast(getActivity(), "Event Registeration Unsuccesfully. Check all the details and try again!!");
        }


    }

    private boolean validate(){

        String MobilePattern = "[0-9]{10}";
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (isEmpty(txtname)) {
            txtname.setError("Name is required");

        }
        if (isEmpty(txtemail)) {
            txtemail.setError("Email is required");
            if(txtemail.getText().toString().matches(emailPattern))
            {
                txtemail.setError("Please Enter Valid E-mail id");
            }

            //to be changed

        }

        if (isEmpty(txtphone)) {
            txtphone.setError("Contact Number is required");

        }
        if (isEmpty(txtclgname)) {
            txtclgname.setError("College Name is required");

        }

        if(!txtphone.getText().toString().matches(MobilePattern)) {

            txtphone.setError("Please enter valid 10 digit phone number");
            return false;
        }
        return true;

    }

    private boolean isEmpty (TextInputEditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);

    }
    private  boolean isEmail(TextInputEditText text){
        CharSequence email = text.getText().toString();
        return(Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

}

