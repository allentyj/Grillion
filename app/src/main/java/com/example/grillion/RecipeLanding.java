package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RecipeLanding extends AppCompatActivity {
    //Intent flags to prevent re-creating instances of running activity
    private int mStep;
    private static final String KEY_STEP = "step";
    private static final boolean USE_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

    private TextView mIDTextView;
    private EditText mNoteEditText;
    private TextView mNoteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_landing);

        mIDTextView = (TextView)findViewById(R.id.recipeIDTextView);
        mNoteEditText = (EditText)findViewById(R.id.recipeLandingEditText);
        mNoteTextView = (TextView)findViewById(R.id.recipeLandingNotes);
    }

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

    //Adds notes to recipe page
    public void addButtonClick(View view){
        String note = mNoteEditText.getText().toString();
        RecipeData recipeData = new RecipeData(note);

        RecipeDatabaseHandler handler = new RecipeDatabaseHandler(this);
        handler.addRecipeNotes(recipeData);

        mNoteEditText.setText("");
        Toast.makeText(this, "Notes added to database.", Toast.LENGTH_SHORT).show();
    }
}