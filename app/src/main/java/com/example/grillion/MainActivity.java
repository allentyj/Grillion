package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //Intent flags to prevent re-creating instances of running activity
    private int mStep;
    private static final String KEY_STEP = "step";
    private static final boolean USE_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    //Linked to the Fork and Knife picture on the main page, takes the user to the Quick Recipe activity on click.
    public void onQuickRecipeClick(View v){
        Intent myIntent = new Intent(this, QuickRecipe.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }
    
    //Linked to the Journal picture on the main page, takes the user to the History activity on click.
    public void onHistoryClick(View v){
        Intent myIntent = new Intent(this, History.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }

    //Linked to the Clipboard picture on the main page, takes the user to the Shopping List activity on click.
    public void onShoppingListClick(View v){
        Intent myIntent = new Intent(this, ShoppingList.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }

    //Linked to the Star picture on the main page, takes the user to the Favorites activity on click.
    public void onFavoritesClick(View v){
        Intent myIntent = new Intent(this, Favorites.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }

    //Linked to the Magnifying Glass picture on the main page, takes the user to the Search (recipe search) activity on click.
    public void onSearchClick(View v){
        Intent myIntent = new Intent(this, Search.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }

    //Linked to the Question Mark picture on the main page, takes the user to the Help activity on click.
    public void onHelpClick(View v){
        Intent myIntent = new Intent(this, Help.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }

}