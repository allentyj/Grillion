package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Favorites extends AppCompatActivity {
    //Intent flags to prevent re-creating instances of running activity
    private int mStep;
    private static final String KEY_STEP = "step";
    private static final boolean USE_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

    //Debug tag for the try/catch
    private static final String DEBUG_TAG = "Favorites";

    //My Variables for the recipe handler
    private ArrayList<String> mRecipes = new ArrayList<>();
    private ArrayList<String> mImageURLs = new ArrayList<>();
    private ArrayList<String> mVideoCode = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        getImages();
    }

    //Gives the RecyclerView the images, videos, and recipe titles to pass to the RecipeLanding Activity
    private void getImages() {
        Log.d(DEBUG_TAG, "initiateImageBitmaps is preparing bitmaps");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1612970452582-O2HBCJQ8TVSAY5EOTO0R/ke17ZwdGBToddI8pDm48kBCaMk_a5jnPkzckNsOsCmN7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0vc___Vi-l6i_tO81lSXAWFK-5YqTXot-_p5YIxO6Alsb_bOgbgE6mRwf-vgKTQPMg/Screen+Shot+2021-02-10+at+9.19.38+AM.png?format=1000w");
        mRecipes.add("Pizza in a Cup");
        mVideoCode.add("8a7L0bFuE3o");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1592926924606-VIGSZE8TQR9XO8U1VE9C/ke17ZwdGBToddI8pDm48kBOthgiqgVBR-96Q3yEVzSt7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0l6CcKX1G46X6yZteoeCRn_QheoGmMTFzEN8raAzG4fC-eBs4904tS0p89qslH4Obg/Screen+Shot+2020-06-23+at+11.41.26+AM.png?format=1000w");
        mRecipes.add("Sweet Rolls");
        mVideoCode.add("98R3fgPKmYs");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1610470499351-CHX023N1JWY12YVIWV4W/ke17ZwdGBToddI8pDm48kGh9ZJ2O0qy0uKSL-_2aFaR7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0tVKkOu97tLoEUCMOIXiAV46WLB4Mpo4oPXEhDdhWMhycxyyYCssjrvYNcG08yYyYQ/Screen+Shot+2021-01-12+at+10.53.36+AM.png?format=1000w");
        mRecipes.add("Risotto Tricolore");
        mVideoCode.add("D8SgdOGIEyU");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1609798571438-LRIS2O6DVLKX2KTEAIIE/ke17ZwdGBToddI8pDm48kOoVbW_hYFgN8dC9Hoa6IcAUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dp5_RnQ3Jt1SmKAL6mKyZJ9K8E-jGEhLMOmY_jQWLgsSCjLISwBs8eEdxAxTptZAUg/Screen+Shot+2021-01-04+at+4.15.49+PM.png?format=1000w");
        mRecipes.add("Sourdough Broccoli Pizza");
        mVideoCode.add("8ti1quN-jKs");


        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1582671231444-8NQXF0P77BDFINRDL4ZZ/ke17ZwdGBToddI8pDm48kGh9ZJ2O0qy0uKSL-_2aFaR7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0tVKkOu97tLoEUCMOIXiAV46WLB4Mpo4oPXEhDdhWMhycxyyYCssjrvYNcG08yYyYQ/image+%286%29.png?format=1000w");
        mRecipes.add("Egg Sandwich");
        mVideoCode.add("6JFVKnrE_d8");

        initiateRecyclerView();
        initiateRecyclerView2();
        initiateRecyclerView3();
    }


    //All three commands for initiating the RecyclerViews with the given images.
    private void initiateRecyclerView(){
        Log.d(DEBUG_TAG, "InitiateRecyclerView initiated RecyclerView");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recentlyAddedRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mRecipes, mImageURLs, mVideoCode);
        recyclerView.setAdapter(adapter);
    }
    private void initiateRecyclerView2(){
        Log.d(DEBUG_TAG, "InitiateRecyclerView initiated RecyclerView2");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.addYourThoughtsRecylerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mRecipes, mImageURLs, mVideoCode);
        recyclerView.setAdapter(adapter);
    }
    private void initiateRecyclerView3(){
        Log.d(DEBUG_TAG, "InitiateRecyclerView initiated RecyclerView3");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.unratedRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mRecipes, mImageURLs, mVideoCode);
        recyclerView.setAdapter(adapter);
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

//Connected to the Arrow in the top left corner of the screen. Returns the user to the Main Activity (home page).
    public void onFavoritesToHomeClick(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }
}