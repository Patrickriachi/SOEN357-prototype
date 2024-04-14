package com.concordia.soen357;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private List<Recipe> recipeList;

    public RecipeAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.textRecipeTitle.setText(recipe.getTitle());
        holder.textRecipeDescription.setText(recipe.getDescription());
        // Set image if you have one, using Glide or similar library
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageRecipe;
        TextView textRecipeTitle;
        TextView textRecipeDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            textRecipeTitle = itemView.findViewById(R.id.text_recipe_title);
            textRecipeDescription = itemView.findViewById(R.id.text_recipe_description);
        }
    }
}
