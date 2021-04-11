package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.System.load;

public class RecipeLanding extends YouTubeBaseActivity {

    //Intent flags to prevent re-creating instances of running activity
    private int mStep;
    private static final String KEY_STEP = "step";
    private static final boolean USE_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
    private static final String TAG = "RecipeLanding";

    private TextView mIDTextView;
    private EditText mNoteEditText;
    private TextView mNoteTextView;
    private TextView mRecipeName;

    //The IDs required for the YouTube player and debug log
    private YouTubePlayerView mYouTubePlayer;
    private Button mPlayButton;
    private YouTubePlayer.OnInitializedListener mOnInitializedListener;
    private static final String YT_TAG = "RecipeLanding";
    private String videoEmbed = "8a7L0bFuE3o";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_landing);

        //Fields to populate with new text or fetch text from
        mIDTextView = (TextView)findViewById(R.id.recipeIDTextView);
        mNoteEditText = (EditText)findViewById(R.id.recipeLandingEditText);
        mNoteTextView = (TextView)findViewById(R.id.recipeLandingNotes);
        mRecipeName = (TextView)findViewById(R.id.recipeLandingRecipeName);

        //IDs for the YouTube player and the corresponding button
        mYouTubePlayer = (YouTubePlayerView)findViewById(R.id.youTubePlayer);
        mPlayButton = (Button)findViewById(R.id.playButtonView);

        //Gets intents from RecyclerViewAdapter
        getIncomingIntent();

        Log.d(YT_TAG, "onCreate: Starting");

        //The YouTube Initialization listener with success and fail logs
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(YT_TAG, "Initialized YT Player");

                youTubePlayer.loadVideo(videoEmbed);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(YT_TAG, "Failed to Initialize YT Player");

            }
        };

        //Plays the queued video tutorial
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYouTubePlayer.initialize(YouTubeKey.getApiKey(), mOnInitializedListener);
                Log.d(YT_TAG, "onClick Initialized");

            }
        });

    }



    //Getters and setters for the information from the RecyclerViewAdapter
    private void getIncomingIntent(){
        Log.d(TAG, "Getting incoming intent : checking for incoming intent");
        if(getIntent().hasExtra("recipe_name")){
            Log.d(TAG, "Found intent extras");

            String recipeName = getIntent().getStringExtra("recipe_name");

            setRecipe(recipeName);
        }
    }

    //Changes recipe name
    private void setRecipe(String recipeName){
        Log.d(TAG, "setting recipe name");
        mRecipeName.setText(recipeName);
    };




    //Returns user to home page
    public void onRecipeLandingToHomeClick(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }

    //Overrides for the intents and checking if an activity is already open
    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        setIntent(intent);
    }
    @Override
    protected void onResume(){
        super.onResume();
        Bundle myData = getIntent().getExtras();
        if(myData == null)
            mStep = 0;
        else
            mStep = myData.getInt(KEY_STEP);
    }


    public TextView getmNoteTextView() {
        return mNoteTextView;
    }

    public void setmNoteTextView(TextView mNoteTextView) {
        this.mNoteTextView = mNoteTextView;
    }


}