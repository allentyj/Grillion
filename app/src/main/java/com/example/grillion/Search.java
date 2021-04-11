package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URL;


public class Search extends AppCompatActivity {
    //Intent flags to prevent re-creating instances of running activity
    private int mStep;
    private static final String KEY_STEP = "step";
    private static final boolean USE_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

    private String URL="https://api.spoonacular.com/recipes/findByIngredients";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("Rest Response",response.toString());
            }
        },
             new Response.ErrorListener(){
            @Override
                    public void onErrorResponse(VolleyError error){
                Log.e("Rest Response", error.toString());
            }});

        requestQueue.add(objectRequest);

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
    public void onSearchToHomeClick(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }
}