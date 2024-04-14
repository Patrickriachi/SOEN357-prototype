package com.concordia.soen357;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Find the button by its ID
        Button skipButton = findViewById(R.id.skipButton);

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

        // Set a click listener on that Button
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the favCuisine activity
                Intent intent = new Intent(search.this, profile.class);
                startActivity(intent);
            }
        });
    }
}