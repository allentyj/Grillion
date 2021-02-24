package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuickRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_recipe);
    }

    //Connected to the Arrow in the top left corner of the screen. Returns the user to the Main Activity (home page).
    public void onQuickRecipeToHomeClick(View v){
        startActivity(new Intent(QuickRecipe.this, MainActivity.class));
    }


}