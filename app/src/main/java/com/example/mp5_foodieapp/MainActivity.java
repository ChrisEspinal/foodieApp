package com.example.mp5_foodieapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<MealItem> arrayMealItems = new ArrayList<>();
    private MealItemAdapter mealItemAdapter = new MealItemAdapter(this, arrayMealItems);
    private TypedArray mealImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, gridColumnCount));
        mealItemAdapter = new MealItemAdapter(this, arrayMealItems);
        recyclerView.setAdapter(mealItemAdapter);
        createList();
    }

    private void createList(){
        String[] mList = getResources().getStringArray(R.array.mealTitles);
        String[] mDescription = getResources().getStringArray(R.array.mealDescriptions);

        mealImages = getResources().obtainTypedArray(R.array.mealImages);
        arrayMealItems.clear();

        for(int i = 0; i < mList.length; i++){
            arrayMealItems.add(new MealItem(mList[i], mDescription[i], mealImages.getResourceId(i, 0)));
        }
        mealItemAdapter.notifyDataSetChanged();
    }

    public void addItem(View view){
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivityForResult(intent, 99);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == 99){
            String title = data.getExtras().getString("title");
            String description = data.getExtras().getString("description");
            String ingredients = data.getExtras().getString("ingredients");
            String recipe = data.getExtras().getString("recipeLink");
            int calories = data.getExtras().getInt("calories");
            int index = 6;

            int resourceId = mealImages.getResourceId(index, 0);
            MealItem newMealItem = new MealItem(title, description, ingredients, calories, recipe, resourceId);

            arrayMealItems.add(newMealItem);

            mealItemAdapter.notifyDataSetChanged();
        }
    }



}
