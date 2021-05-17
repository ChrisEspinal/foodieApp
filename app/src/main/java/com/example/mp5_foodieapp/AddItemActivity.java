package com.example.mp5_foodieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class AddItemActivity extends AppCompatActivity {

    private EditText foodTitleEditText;
    private EditText foodDescriptionEditText;
    private EditText ingredientsEditText;
    private EditText caloriesEditText;
    private EditText recipeEditText;

    private String sFoodTitle;
    private String sFoodDescription;
    private String sIngredients;
    private int numCalories;
    private String sRecipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        foodTitleEditText = (EditText) findViewById(R.id.foodTitle_editText);
        foodDescriptionEditText = (EditText) findViewById(R.id.foodDescription_editText);
        ingredientsEditText = (EditText) findViewById(R.id.ingredients_editText);
        caloriesEditText = (EditText) findViewById(R.id.calories_editText);
        recipeEditText= (EditText) findViewById(R.id.recipe_editText);
    }

    public void addMeal(View view){
        sFoodTitle = foodTitleEditText.getText().toString();
        sFoodDescription = foodDescriptionEditText.getText().toString();
        sIngredients = ingredientsEditText.getText().toString();
        numCalories = Integer.parseInt(caloriesEditText.getText().toString());
        sRecipe = recipeEditText.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("title", sFoodTitle);
        intent.putExtra("description", sFoodDescription);
        intent.putExtra("ingredients", sIngredients);
        intent.putExtra("calories", numCalories);
        intent.putExtra( "recipeLink", sRecipe);
        setResult(RESULT_OK, intent);
        finish();
    }


}
