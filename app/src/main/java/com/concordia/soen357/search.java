package com.concordia.soen357;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class search extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recipeList = new ArrayList<>();
        // Add some sample data
        recipeList.add(new Recipe("Grilled Cheese Sandwich", "A deliciously grilled cheese sandwich perfect for a quick meal."));
        recipeList.add(new Recipe("Chicken Stir Fry", "A healthy mix of chicken and vegetables, stir-fried with Asian flavors."));
        recipeList.add(new Recipe("Waffles", "Crispy golden waffles with a soft and fluffy inside, serve with syrup or fruit."));
        recipeList.add(new Recipe("Classic Pancakes", "Light and fluffy pancakes for a classic breakfast treat."));
        recipeList.add(new Recipe("Spaghetti Bolognese", "Rich meat sauce served over a bed of al dente spaghetti."));
        recipeList.add(new Recipe("Caesar Salad", "Crisp romaine lettuce dressed with parmesan, croutons, and Caesar dressing."));
        recipeList.add(new Recipe("Beef Tacos", "Spicy ground beef with fresh salsa and cheese in a crunchy taco shell."));
        recipeList.add(new Recipe("Vegetable Curry", "A medley of seasonal vegetables in a fragrant curry sauce."));
        recipeList.add(new Recipe("Mushroom Risotto", "Creamy risotto with sautéed mushrooms and a hint of garlic."));
        recipeList.add(new Recipe("Baked Salmon", "Salmon fillets seasoned and baked to perfection."));
        recipeList.add(new Recipe("Quiche Lorraine", "A savory pie filled with bacon, cheese, and eggs, baked until golden."));
        recipeList.add(new Recipe("Lentil Soup", "Hearty lentil soup with vegetables, perfect for a cold day."));
        recipeList.add(new Recipe("BBQ Chicken Pizza", "A delicious pizza with barbecue sauce, chicken, onions, and cheese."));
        recipeList.add(new Recipe("Chocolate Brownies", "Rich and chewy brownies with chunks of melted chocolate."));


        // Setup RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecipeAdapter(recipeList);
        recyclerView.setAdapter(adapter);


        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        navView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(search.this, home.class));
                    return true;
                case R.id.navigation_search:
                    return true;
                case R.id.navigation_profile:
                    startActivity(new Intent(search.this, profile.class));
                    return true;
                default:
                    return false;
            }
        });

        // Set the home as selected by default
        navView.setSelectedItemId(R.id.navigation_search);

    }
}