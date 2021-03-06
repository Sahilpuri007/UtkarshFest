package com.fest.utkarsh.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.fest.utkarsh.R;
import com.fest.utkarsh.fragment.AboutApp;
import com.fest.utkarsh.fragment.AboutUs;
import com.fest.utkarsh.fragment.ContactUs;
import com.fest.utkarsh.fragment.EventsFragment;
import com.fest.utkarsh.fragment.FbFragment;
import com.fest.utkarsh.fragment.HomeFragment;
import com.fest.utkarsh.fragment.Queries;
import com.fest.utkarsh.fragment.SpecialEvents;
import com.fest.utkarsh.fragment.WebsiteFragment;
import com.fest.utkarsh.utils.SharedPrefManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {

    Context mContext = this;
    private String mUsername, mEmail;
    private ImageView mProfileImageView;
    SharedPrefManager sharedPrefManager;
    private TextView mFullNameTextView, mEmailTextView;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragment=new HomeFragment();
        fragManag();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            //}
        //});

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);

        mFullNameTextView = (TextView) header.findViewById(R.id.textView_name_drawer);
        mEmailTextView = (TextView) header.findViewById(R.id.textView_email_drawer);
        mProfileImageView = (ImageView) header.findViewById(R.id.imageView_email_drawer);

        sharedPrefManager = new SharedPrefManager(mContext);
        mUsername = sharedPrefManager.getName();
        mEmail = sharedPrefManager.getUserEmail();
        String uri = sharedPrefManager.getPhoto();
        Uri mPhotoUri = Uri.parse(uri);
        mFullNameTextView.setText(mUsername);
        mEmailTextView.setText(mEmail);

        Picasso.get()
                .load(mPhotoUri)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(mProfileImageView);

        configSigIn();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            fragment=new HomeFragment();

        } else if (id == R.id.nav_events) {
            fragment=new EventsFragment();
        }else if (id == R.id.nav_sp) {
            fragment=new SpecialEvents();
        }else if (id == R.id.nav_register) {

            Intent intent = new Intent(this,RegEventActivity.class);//what do you want to display next
            startActivity(intent);
        } else if (id == R.id.nav_videos) {
            Intent intent = new Intent(HomeActivity.this, VideoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_website) {
            fragment=new WebsiteFragment();

        }else if (id == R.id.nav_fb) {
            fragment=new FbFragment();

        } else if (id == R.id.nav_about_app) {
            fragment=new AboutApp();
        }
        else if (id == R.id.nav_about_us) {
            fragment=new AboutUs();
        }
        else if (id == R.id.nav_queries) {
            fragment=new Queries();
        }

        else if (id == R.id.nav_contact_us) {
            fragment=new ContactUs();
        }else if (id == R.id.nav_sign_out) {
            signOut();
        }
        fragManag();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void configSigIn(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        /*mGoogleApiClient  = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, (GoogleApiClient.OnConnectionFailedListener) this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();*/
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        mAuth = FirebaseAuth.getInstance();
    }
    private void signOut() {
        mAuth.signOut();
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        //sharedPrefManager.clear();
                    }
                });
    }
    public void fragManag(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main,fragment);
        fragmentTransaction.commit();

    }
}
