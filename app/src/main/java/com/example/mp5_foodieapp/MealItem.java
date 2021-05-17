package com.example.mp5_foodieapp;

import androidx.appcompat.app.AppCompatActivity;

public class MealItem extends AppCompatActivity {

    private String mealTitle;
    private String mealDescription;
    private String mealIngredients;
    private String mealRecipe;
    private int mealCalories;
    private int mealImage;

    MealItem (String title, String description, String ingredients, int calories, String recipe, int image){
        mealTitle = title;
        mealDescription = description;
        mealIngredients = ingredients;
        mealCalories = calories;
        mealRecipe = recipe;
        mealImage = image;

    }

    MealItem (String title, String description, int image){
        mealTitle = title;
        mealDescription = description;
        mealImage = image;

    }

    public String getMealTitle() {
        return mealTitle;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public String getMealIngredients() {
        return mealIngredients;
    }

    public String getMealRecipe() {
        return mealRecipe;
    }

    public int getMealCalories() {
        return mealCalories;
    }

    public int getMealImage() {
        return mealImage;
    }


}
