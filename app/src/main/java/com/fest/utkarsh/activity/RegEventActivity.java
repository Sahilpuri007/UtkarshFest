package com.fest.utkarsh.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.fest.utkarsh.dal.Data;
import com.fest.utkarsh.helper.Console;
import com.fest.utkarsh.prop.Event;
import com.fest.utkarsh.R;

public class RegEventActivity extends AppCompatActivity {

    TextInputEditText txtname, txtemail, txtclgname, txtphone;
    Spinner spinCat, spinEvent, spinMem;
    Button btnregevent;
    String categoryls[] = {"Cultural", "Dexteria", "Atlantus"};
    String eventcul[] = {"Dharhohar", "Footloose", "Dramaturgy", "Asthetica", "Dance Off", "Rampage", "Debate", "Drawing/Painting"};
    String eventdex[] = {"Quibble", "Design X", "Winshoot", "Google Hunt", "Web Weaver", "Problematic"};
    String eventatl[] = {"CS 1.6", "CS Go", "Tekken", "NFS", "FIFA", "Mario Mod", "Chrome Run","PUBG"};//check for more
    String s[] = {"Single"};
    String sd[] = {"Single", "Double"};
    String g[] = {"Group"};
    String sg[] = {"Single", "Group"};
    //String test[] = {"test"};
    private Toolbar toolbar_reg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_event);
        toolbar_reg = (Toolbar) findViewById(R.id.toolbar_registeration);
        setSupportActionBar(toolbar_reg);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);
        txtname = (TextInputEditText)findViewById(R.id.name);
        txtemail = (TextInputEditText)findViewById(R.id.email);
        txtclgname = (TextInputEditText)findViewById(R.id.clgname);
        txtphone = (TextInputEditText)findViewById(R.id.phone);
        spinCat = (Spinner)findViewById(R.id.catSpinner);
        spinEvent = (Spinner)findViewById(R.id.eventSpinner);
        spinMem = (Spinner)findViewById(R.id.memberSpinner);
        btnregevent = (Button)findViewById(R.id.btnregevent);
        // ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,test);
        //spinEvent.setAdapter(arrayAdapter);
        //spinMem.setAdapter(arrayAdapter);
        //spinCat.setAdapter(arrayAdapter);
        ArrayAdapter catadp = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, categoryls);
        spinCat.setAdapter(catadp);

        spinCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String scat = spinCat.getSelectedItem().toString();

                if (scat.equals("Cultural")) {
                    ArrayAdapter eventadp = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, eventcul);
                    spinEvent.setAdapter(eventadp);
                }
                if (scat.equals("Dexteria")) {
                    ArrayAdapter eventadp = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, eventdex);
                    spinEvent.setAdapter(eventadp);
                }
                if (scat.equals("Atlantus")) {
                    ArrayAdapter eventadp = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, eventatl);
                    spinEvent.setAdapter(eventadp);
                }

                spinEvent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String event = spinEvent.getSelectedItem().toString();

                        if (event.equals("Dharhohar") || event.equals("Footloose") || event.equals("Dramaturgy") || event.equals("Asthetica")  || event.equals("CS 1.6") || event.equals("CS Go") ||event.equals("CS Go"))  {
                            ArrayAdapter memadp = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, g);
                            spinMem.setAdapter(memadp);
                        }
                        if (event.equals("Dance Off") || event.equals("Quibble")) {
                            ArrayAdapter memadp = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, sd);
                            spinMem.setAdapter(memadp);
                        }
                        if (event.equals("Rampage")) {
                            ArrayAdapter memadp = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, sg);
                            spinMem.setAdapter(memadp);
                        }
                        if (event.equals("Debate") || event.equals("Drawing/Painting") || event.equals("Design X") || event.equals("Winshoot") || event.equals("Google Hunt") || event.equals("Web Weaver") || event.equals("Aperture") || event.equals("Problematic") || event.equals("Tekken") || event.equals("NFS") || event.equals("FIFA") || event.equals("Mario Mod") || event.equals("Chrome Run")) {
                            ArrayAdapter memadp = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, s);
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
                    //Console.Toast(getApplicationContext(), "Not Valid");
                }
                else
                {
                    //Console.Toast(getApplicationContext(), "Valid");
                    //Console.Toast(getActivity().getApplicationContext(),name+"");
                    register();
                }

                //insertRegEvent();//FUNCTION CALL,DECLARATION AT BOTTOM
            }
        });
    }
    private void register() {
       // Console.Toast(getApplicationContext(),"called");
        String name = txtname.getText().toString();
        String email = txtemail.getText().toString();
        String college = txtclgname.getText().toString();
        String phone = txtphone.getText().toString();
        Event event =new Event();
        //int toastDuration= 10000;
        event.setName(name);
        event.setEmail(email);
        event.setCollege(college);
        event.setPhone(phone);
        event.setCategory(spinCat.getSelectedItem().toString());
        event.setEvent(spinEvent.getSelectedItem().toString());
        event.setMember(spinMem.getSelectedItem().toString());
        String data = event.postData();
        Data d = new Data();
        //Console.Toast(getApplicationContext()," "+data);
        int ret = d.insert(getParent(),data,"regevent.php");
       //Console.Toast(getApplicationContext()," "+ret);
        if(ret == 0)
        {
            //success("UTKARSH REGISTRATIONS","Event Registered Succesfully");
            //Toast.makeText(getApplicationContext(),"Event Registered Succesfully",Toast.).show();
            Console.Toast(getApplicationContext(),"Event Registered Succesfully");
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);//set Class here!!!!!!!!
            startActivity(intent);
        }
        else if (ret == 1) {
            //unsuccess("UTKARSH REGISTRATIONS","Event Registeration Unsuccesfully.");
            Console.Toast(getApplicationContext(), "Event Registeration Unsuccesfull. Check all the details and try again!!");
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
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        // or call onBackPressed()
        return true;
    }


    public void success(String title,String message)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_abcd);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);//set Class here!!!!!!!!
                startActivity(intent);
            }
        });
    }

    public void unsuccess(String title,String message){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_abcd);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mess();
            }
        });



    }

    private void mess() {
        Console.Toast(getApplicationContext(),"Check all the details and try again!!");
    }

}
