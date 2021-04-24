package com.example.grillion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;


public class Search extends AppCompatActivity {
    //Intent flags to prevent re-creating instances of running activity
    private int mStep;
    private static final String KEY_STEP = "step";
    private static final boolean USE_FLAG = true;
    private static final int mFlag = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

    private String URL="https://api.spoonacular.com/recipes/findByIngredients";

    private static final String DEBUG_TAG = "Search";

    private ArrayList<String> mRecipes = new ArrayList<>();
    private ArrayList<String> mImageURLs = new ArrayList<>();
    private ArrayList<String> mVideoCode = new ArrayList<>();
    private ArrayList<String> mText = new ArrayList<>();
    private ArrayList<String> mIngredients = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        /* RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                });

        requestQueue.add(objectRequest);

 */

        getImages();

    }

    private void getImages() {
        Log.d(DEBUG_TAG, "initiateImageBitmaps is preparing bitmaps");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1612970452582-O2HBCJQ8TVSAY5EOTO0R/ke17ZwdGBToddI8pDm48kBCaMk_a5jnPkzckNsOsCmN7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0vc___Vi-l6i_tO81lSXAWFK-5YqTXot-_p5YIxO6Alsb_bOgbgE6mRwf-vgKTQPMg/Screen+Shot+2021-02-10+at+9.19.38+AM.png?format=1000w");
        mRecipes.add("Pizza in a Cup");
        mVideoCode.add("8a7L0bFuE3o");
        mText.add("pizzacup.txt");
        mIngredients.add("flour, baking powder, baking soda, milk, olive oil, pizza sauce, mozzarella, pepperoni");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1592926924606-VIGSZE8TQR9XO8U1VE9C/ke17ZwdGBToddI8pDm48kBOthgiqgVBR-96Q3yEVzSt7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0l6CcKX1G46X6yZteoeCRn_QheoGmMTFzEN8raAzG4fC-eBs4904tS0p89qslH4Obg/Screen+Shot+2020-06-23+at+11.41.26+AM.png?format=1000w");
        mRecipes.add("Sweet Rolls");
        mVideoCode.add("98R3fgPKmYs");
        mText.add("sweetrolls.txt");
        mIngredients.add("flour, baking powder, baking soda, milk, sugar, egg, butter");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1610470499351-CHX023N1JWY12YVIWV4W/ke17ZwdGBToddI8pDm48kGh9ZJ2O0qy0uKSL-_2aFaR7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0tVKkOu97tLoEUCMOIXiAV46WLB4Mpo4oPXEhDdhWMhycxyyYCssjrvYNcG08yYyYQ/Screen+Shot+2021-01-12+at+10.53.36+AM.png?format=1000w");
        mRecipes.add("Risotto Tricolore");
        mVideoCode.add("D8SgdOGIEyU");
        mText.add("risotto.txt");
        mIngredients.add("cheese, rice, onion, chicken, garlic");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1609798571438-LRIS2O6DVLKX2KTEAIIE/ke17ZwdGBToddI8pDm48kOoVbW_hYFgN8dC9Hoa6IcAUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYy7Mythp_T-mtop-vrsUOmeInPi9iDjx9w8K4ZfjXt2dp5_RnQ3Jt1SmKAL6mKyZJ9K8E-jGEhLMOmY_jQWLgsSCjLISwBs8eEdxAxTptZAUg/Screen+Shot+2021-01-04+at+4.15.49+PM.png?format=1000w");
        mRecipes.add("Sourdough Broccoli Pizza");
        mVideoCode.add("8ti1quN-jKs");
        mText.add("brocpizza.txt");
        mIngredients.add("flour, baking powder, baking soda, milk, olive oil, pizza sauce, mozzarella, broccoli");


        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1582671231444-8NQXF0P77BDFINRDL4ZZ/ke17ZwdGBToddI8pDm48kGh9ZJ2O0qy0uKSL-_2aFaR7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0tVKkOu97tLoEUCMOIXiAV46WLB4Mpo4oPXEhDdhWMhycxyyYCssjrvYNcG08yYyYQ/image+%286%29.png?format=1000w");
        mRecipes.add("Egg Sandwich");
        mVideoCode.add("6JFVKnrE_d8");
        mText.add("eggsandwich.txt");
        mIngredients.add("egg, bread, hot sauce, bacon");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1617805811645-5X7ONA1Q494C6A0E9IP9/ke17ZwdGBToddI8pDm48kOxLRGAfd8DHyn-VO-OS79h7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0usXCOu1ni7cqT7DpdWG1QXsxC4JUKCTfgXShWWMRL-jMKpWpWZXzvRmlf_9uuK6qg/Screen+Shot+2021-04-06+at+9.49.19+AM.png?format=1000w");
        mRecipes.add("Chicken Fingers");
        mVideoCode.add("MJoSs4BGaHI");
        mText.add("chickenfingers.txt");
        mIngredients.add("egg, chicken");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1614698155759-L2OMM58Z0ML94PRSBWCZ/ke17ZwdGBToddI8pDm48kELMIT6P-mXOKLp1AsW0HQB7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0swtrMQrSykJ5045sc_U3bB2t9idZTyZfkWem5om76OgN0a1rqfTvLEpNmOmHby1BA/Screen+Shot+2021-03-02+at+9.15.28+AM.png?format=1000w");
        mRecipes.add("Chicken Kiev");
        mVideoCode.add("kf8XzD-xVGc");
        mText.add("chickenkiev.txt");
        mIngredients.add("chicken, butter, garlic, herbs");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1615311123218-SQMKDERC3939K4751DRI/ke17ZwdGBToddI8pDm48kB22_VvoyFCRbPbLc__z6BN7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0mCjggly5cZuu_YqpnrzBi6yTqBkwjrVCaBTX1Yp4Xgg6k6KMOdln3GErxXMetT4lA/Screen+Shot+2021-03-09+at+11.31.09+AM.png?format=1000w");
        mRecipes.add("WandaVision Dinner");
        mVideoCode.add("4e7iksx-Zig");
        mText.add("wandavision.txt");
        mIngredients.add("chicken, steak, butter, lobster, puff pastry, potato, onion, mint");

        mImageURLs.add("https://static1.squarespace.com/static/590be7fd15d5dbc6bf3e22d0/590bef6f46c3c4d418c28dac/5c632028fa0d6056201e03a3/?format=500w");
        mRecipes.add("Steak au Poivre");
        mVideoCode.add("tCJ_VV0FEZM");
        mText.add("steakaupoivre.txt");
        mIngredients.add("steak, pepper, onion, carrot, peas");

        mImageURLs.add("https://static1.squarespace.com/static/590be7fd15d5dbc6bf3e22d0/590bef6f46c3c4d418c28dac/5fcfe5716dbb620f3b5423ea/?format=500w");
        mRecipes.add("Steak, Eggs and Gravy");
        mVideoCode.add("ztl0gGVFoK0");
        mText.add("steakeggsgravy.txt");
        mIngredients.add("steak, egg, potato, gravy");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1597767956014-0KT28TS9BTJ8CVFPT7YG/ke17ZwdGBToddI8pDm48kBOthgiqgVBR-96Q3yEVzSt7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0l6CcKX1G46X6yZteoeCRn_QheoGmMTFzEN8raAzG4fC-eBs4904tS0p89qslH4Obg/Screen+Shot+2020-08-18+at+11.17.50+AM.png?format=1000w");
        mRecipes.add("The Four Horsemeats of the Eggpocalypse");
        mVideoCode.add("NWGVFi-213w");
        mText.add("fourhorsemeats.txt");
        mIngredients.add("egg, steak, pork, bacon, butter, sausage, ham");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1598374885944-0VR6VUBNW1FCZ7FLVPHU/ke17ZwdGBToddI8pDm48kDRfib_UXLRMif_QrQmyGXp7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0mjuKkDq72eEezzWZ5vHIHk0_9jUd5t9vU5pmLnFPdwPYl6rNaFySPLy0mCMabKgLg/Screen+Shot+2020-08-25+at+12.00.56+PM.png?format=1000w");
        mRecipes.add("Meat Tornado");
        mVideoCode.add("LsNg-KrFxCA");
        mText.add("meattornado.txt");
        mIngredients.add("steak, chicken, bacon, pork, pepper, garlic, tortilla");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1583949810911-HFY07P66CIW00B6LVCQ0/ke17ZwdGBToddI8pDm48kBOthgiqgVBR-96Q3yEVzSt7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0l6CcKX1G46X6yZteoeCRn_QheoGmMTFzEN8raAzG4fC-eBs4904tS0p89qslH4Obg/Screen+Shot+2020-03-11+at+1.02.45+PM.png?format=1000w");
        mRecipes.add("Turf 'n' Turf");
        mVideoCode.add("peLPVIGFaz0");
        mText.add("turfturf.txt");
        mIngredients.add("steak, butter, potato");

        mImageURLs.add("https://static1.squarespace.com/static/590be7fd15d5dbc6bf3e22d0/590bef6f46c3c4d418c28dac/5911a8d2893fc011d4ed2f1a/?format=500w");
        mRecipes.add("Wild Mushroom Soup");
        mVideoCode.add("pw2A03Z91FI");
        mText.add("mushroomsoup.txt");
        mIngredients.add("milk, mushroom, onion");

        mImageURLs.add("https://static1.squarespace.com/static/590be7fd15d5dbc6bf3e22d0/590bef6f46c3c4d418c28dac/5a0cc625ec212d58cf048322/?format=500w");
        mRecipes.add("Beef Wellington");
        mVideoCode.add("BagY2Mnz-TU");
        mText.add("beefwellington.txt");
        mIngredients.add("beef, steak, mushroom, puff pastry");

        mImageURLs.add("https://images.squarespace-cdn.com/content/v1/590be7fd15d5dbc6bf3e22d0/1618253821941-OE8PP131NIFDNI0MOFBO/ke17ZwdGBToddI8pDm48kCyxOUK1lO3MEXr46yUhTqt7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0g5J5A6_qG1rkJEx0PDqwBsaEOlDsayOMDD0J8Qn0fisY7T_vSeJBu_dKctKyGmDGQ/Screen+Shot+2021-04-12+at+1.55.40+PM.png?format=1000w");
        mRecipes.add("Gotcha Pork Roast");
        mVideoCode.add("NfrLH0T0rdU");
        mText.add("gotchapork.txt");
        mIngredients.add("bacon, butter, potato");

        mImageURLs.add("https://static1.squarespace.com/static/590be7fd15d5dbc6bf3e22d0/590bef6f46c3c4d418c28dac/5cf69b9e244df70001cf6f9e/?format=500w");
        mRecipes.add("Bacon and Eggs Breakfast");
        mVideoCode.add("UPccIAVvQA4");
        mText.add("baconeggs");
        mIngredients.add("bacon, egg");

        mImageURLs.add("https://static1.squarespace.com/static/590be7fd15d5dbc6bf3e22d0/590bef6f46c3c4d418c28dac/5aa8354971c10b9167223d2a/?format=500w");
        mRecipes.add("Pineapple Fried Rice");
        mVideoCode.add("WRA3a7c4Qt4");
        mText.add("pineapplerice.txt");
        mIngredients.add("pineapple, rice, egg, onion");

        mImageURLs.add("https://static1.squarespace.com/static/590be7fd15d5dbc6bf3e22d0/590bef6f46c3c4d418c28dac/5ca3d65015fcc0656af4f7ed/?format=500w");
        mRecipes.add("Onigiri");
        mVideoCode.add("gW4PCfLzTYA");
        mText.add("onigiri.txt");
        mIngredients.add("rice, kelp, seaweed, plum");

        mImageURLs.add("https://static1.squarespace.com/static/590be7fd15d5dbc6bf3e22d0/590bef6f46c3c4d418c28dac/5b3267ea8a922dce0ab10b52/?format=500w");
        mRecipes.add("Congee");
        mVideoCode.add("VGsIsfIyz4E");
        mText.add("congee.txt");
        mIngredients.add("bacon, rice, egg");

        initiateRecyclerView();
    }

    private void initiateRecyclerView(){
        Log.d(DEBUG_TAG, "InitiateRecyclerView initiated RecyclerView");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.searchRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mRecipes, mImageURLs, mVideoCode, mText, mIngredients);
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
    public void onSearchToHomeClick(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        if(USE_FLAG)
            myIntent.addFlags(mFlag);
        myIntent.putExtra(KEY_STEP, mStep + 1);
        startActivity(myIntent);
    }
}