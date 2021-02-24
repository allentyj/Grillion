package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    //Connected to the Arrow in the top left corner of the screen. Returns the user to the Main Activity (home page).
    public void onHistoryToHomeClick(View v){
        startActivity(new Intent(History.this, MainActivity.class));
    }
}