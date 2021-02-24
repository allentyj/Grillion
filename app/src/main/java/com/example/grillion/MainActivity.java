package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Linked to the Fork and Knife picture on the main page, takes the user to the Quick Recipe activity on click.
    public void onQuickRecipeClick(View v){
        startActivity(new Intent(MainActivity.this, QuickRecipe.class));
    }
    
    //Linked to the Journal picture on the main page, takes the user to the History activity on click.
    public void onHistoryClick(View v){
        startActivity(new Intent(MainActivity.this, History.class));
    }

    //Linked to the Clipboard picture on the main page, takes the user to the Shopping List activity on click.
    public void onShoppingListClick(View v){
        startActivity(new Intent(MainActivity.this, ShoppingList.class));
    }

    //Linked to the Star picture on the main page, takes the user to the Favorites activity on click.
    public void onFavoritesClick(View v){
        startActivity(new Intent(MainActivity.this, Favorites.class));
    }

    //Linked to the Magnifying Glass picture on the main page, takes the user to the Search (recipe search) activity on click.
    public void onSearchClick(View v){
        startActivity(new Intent(MainActivity.this, Search.class));
    }

    //Linked to the Question Mark picture on the main page, takes the user to the Help activity on click.
    public void onHelpClick(View v){
        startActivity(new Intent(MainActivity.this, Help.class));
    }

}