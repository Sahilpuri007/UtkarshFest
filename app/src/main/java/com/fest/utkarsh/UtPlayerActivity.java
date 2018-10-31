package com.fest.utkarsh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fest.utkarsh.utils.PlayerConfig;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class UtPlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private final Context mContext = this;
    YouTubePlayerView youTubePlayerView;
    Button btn,btn2;
    //YouTubePlayer.OnInitializedListener onInitializedListener;
    //private Toolbar toolbar_player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut_player);
        btn =(Button)findViewById(R.id.btn_player);
        btn2 =(Button)findViewById(R.id.btn_player2);
        youTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(PlayerConfig.API_KEY,this);
        //toolbar_player = (Toolbar) findViewById(R.id.toolbar_player);
        //toolbar_player.setSupportActionBar(toolbar_player);
        //toolbar_player.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("OORoOGY8D2M");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(mContext,youTubeInitializationResult+"",Toast.LENGTH_LONG).show();
            }
        };*/
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UtPlayerActivity.this, CulturalTabActivity.class);
                startActivity(intent);            }
        });


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {

        youTubePlayer.cueVideo("W_1mBf6grzk");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayer.loadVideo("W_1mBf6grzk");
            }
        });

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), youTubeInitializationResult.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(PlayerConfig.API_KEY, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
    public void onBackPressed() {
        super.onBackPressed();
    }
    /*@Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        // or call onBackPressed()
        return true;
    }*/
}
