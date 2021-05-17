package com.example.mp5_foodieapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class ShowItemInfo extends AppCompatActivity {

    private int mIndex;
    private TextView mTitle;
    private TextView mDescription;
    private TextView mIngredients;
    private TextView mRecipe;
    private TextView mCalories;
    private ImageView mImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item_info);

        mTitle = (TextView)findViewById(R.id.showMealTitle_textView);
        mDescription = (TextView)findViewById(R.id.showMealDescription_textView);
        mIngredients = (TextView)findViewById(R.id.showMealIngredients_textView);
        mCalories = (TextView)findViewById(R.id.showMealCalories_TextView);
        mRecipe = (TextView)findViewById(R.id.showMealRecipe_textView);
        mImage = (ImageView)findViewById(R.id.showMealImage_imageView);


        Intent intent = getIntent();
        mIndex = intent.getExtras().getInt("mIndex");
        String sMealTitle = intent.getExtras().getString("mTitle");
        int intMealImage = intent.getExtras().getInt("mImage");
        String sMealDescription = intent.getExtras().getString("mDescription");
        String sMealIngredients = intent.getExtras().getString("mIngredients");
        String sMealCalories = String.valueOf(intent.getExtras().getInt("mCalories")) + " cal.";
        String sMealRecipe = intent.getExtras().getString("mRecipe");

        if(sMealIngredients == null) {
            fillInfo(mIndex);
        }
        else{
            mIngredients.setText(sMealIngredients);
            mCalories.setText(sMealCalories);
            mRecipe.setText(sMealRecipe);
        }

        mTitle.setText(sMealTitle);
        Glide.with(this).load(intMealImage).into(mImage);
        mDescription.setText(sMealDescription);

    }

    public void fillInfo(int index){
        String[] arrayIngredients = getResources().getStringArray(R.array.mealIngredients);
        String[] arrayCalories = getResources().getStringArray(R.array.mealCalories);
        String[] arrayRecipes = getResources().getStringArray(R.array.mealRecipes);

        mIngredients.setText(arrayIngredients[index]);
        mCalories.setText(arrayCalories[index]);
        mRecipe.setText(arrayRecipes[index]);
    }

    public void onlineRecipe(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(mRecipe.getText().toString()));
        startActivity(intent);

    }
}