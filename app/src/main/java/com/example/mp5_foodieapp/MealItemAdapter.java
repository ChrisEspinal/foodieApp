package com.example.mp5_foodieapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.bumptech.glide.Glide;

public class MealItemAdapter extends RecyclerView.Adapter<MealItemAdapter.ViewHolder> {

    private ArrayList<MealItem> mealItems;
    private Context context;

    public MealItemAdapter(Context context, ArrayList<MealItem> mealItems){
        this.mealItems = mealItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MealItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_meal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MealItemAdapter.ViewHolder holder, final int position) {
        final MealItem onMealItem = mealItems.get(position);
        Glide.with(context).load(onMealItem.getMealImage()).into(holder.setMealImage);
        holder.onBind(onMealItem);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowItemInfo.class);
                intent.putExtra("mIndex", position);
                intent.putExtra("mTitle", onMealItem.getMealTitle());
                intent.putExtra("mDescription", onMealItem.getMealDescription());
                intent.putExtra("mIngredients", onMealItem.getMealIngredients());
                intent.putExtra("mCalories", onMealItem.getMealCalories());
                intent.putExtra("mRecipe", onMealItem.getMealRecipe());
                intent.putExtra("mImage", onMealItem.getMealImage());
                context.startActivity(intent);
            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(R.string.alertDialogTitle);
                builder.setMessage(R.string.alertDialogMessage);
                builder.setNegativeButton(R.string.alertDialogN, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton(R.string.alertDialogP, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mealItems.remove(holder.getAdapterPosition());
                        MealItemAdapter.this.notifyItemRemoved(holder.getAdapterPosition());
                    }
                });
                AlertDialog notification = builder.create();
                notification.show();
                return false;
            }
        });

    }


    @Override
    public int getItemCount() {
        return mealItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private TextView setMealTitle;
        private TextView setMealDescription;
        private ImageView setMealImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            setMealTitle = (TextView) itemView.findViewById(R.id.mealItemTitle_textView);
            setMealDescription = (TextView) itemView.findViewById(R.id.mealItemDescription_textView);
            setMealImage = (ImageView) itemView.findViewById(R.id.mealItem_imageView);
            cardView = (CardView) itemView.findViewById(R.id.mealItem_cardView);
        }

        public void onBind(MealItem onMealItem) {
            setMealTitle.setText(onMealItem.getMealTitle());
            setMealDescription.setText(onMealItem.getMealDescription());
        }
    }




}

