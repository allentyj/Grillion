package com.example.grillion;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String DEBUG_TAG = "RecycleViewAdapter";

    //My Variables
    private Context mContext;
    private ArrayList<String> mRecipes = new ArrayList<>();
    private ArrayList<String> mImageURLs = new ArrayList<>();

    public RecyclerViewAdapter(Context context, ArrayList<String> recipes, ArrayList<String> imageURLs){
        mContext = context;
        mRecipes = recipes;
        mImageURLs = imageURLs;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(DEBUG_TAG, "onCreateViewHolder was called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipeitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(DEBUG_TAG, "onBindViewHolder was called.");


        Glide.with(mContext)
                .asBitmap()
                .load(mImageURLs.get(position))
                .into(holder.picture);

        holder.recipe.setText(mRecipes.get(position));

        holder.picture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d(DEBUG_TAG, "onClick was clicked." + mRecipes.get(position));
                Toast.makeText(mContext, mRecipes.get(position), Toast.LENGTH_SHORT).show();
                //Put in here what recipe you are going to.
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageURLs.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView picture;
        TextView recipe;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.picture);
            recipe = itemView.findViewById(R.id.recipe);

        }
    }
}
