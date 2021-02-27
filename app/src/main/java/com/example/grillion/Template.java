package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Template extends AppCompatActivity {

    private static final String DEBUG_TAG = "Template";

//My Variables
    private ArrayList<String> mRecipes = new ArrayList<>();
    private ArrayList<String> mImageURLs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        getImages();
    }

    private void getImages(){
        Log.d(DEBUG_TAG, "initiateImageBitmaps is preparing bitmaps");

        mImageURLs.add("https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chorizo-mozarella-gnocchi-bake-cropped-9ab73a3.jpg?quality=90&resize=700%2C636");
        mRecipes.add("Tomato Sauce Gnocci");

        mImageURLs.add("https://images2.minutemediacdn.com/image/upload/c_crop,h_1126,w_2000,x_0,y_181/f_auto,q_auto,w_1100/v1554932288/shape/mentalfloss/12531-istock-637790866.jpg");
        mRecipes.add("Extreme Burger");

        mImageURLs.add("https://www.helpguide.org/wp-content/uploads/fast-foods-candy-cookies-pastries-768.jpg");
        mRecipes.add("The America");

        mImageURLs.add("https://www.wbcsd.org/var/site/storage/images/media/images/fresh_pa/80809-2-eng-GB/FRESH_PA_i1140.jpg");
        mRecipes.add("Chicken and Brussel Sprouts Salad");

        mImageURLs.add("https://media.self.com/photos/5f189b76c58e27c99fbef9e3/1:1/w_768,c_limit/blackberry-vanilla-french-toast.jpg");
        mRecipes.add("French Toast With Honey Glaze");

        initiateRecyclerView();

    }

    private void initiateRecyclerView(){
        Log.d(DEBUG_TAG, "InitiateRecyclerView initiated RecyclerView");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mRecipes, mImageURLs);
        recyclerView.setAdapter(adapter);
    }

}