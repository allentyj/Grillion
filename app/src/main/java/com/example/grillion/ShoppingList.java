package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShoppingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
    }

    //Connected to the Arrow in the top left corner of the screen. Returns the user to the Main Activity (home page).
    public void onShoppingListToHome(View v){
        startActivity(new Intent(ShoppingList.this, MainActivity.class));
    }
}