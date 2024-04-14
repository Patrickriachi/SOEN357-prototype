package com.concordia.soen357;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Find the button by its ID
        Button skipButton = findViewById(R.id.backButton);

        // Set a click listener on that Button
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the favCuisine activity
                Intent intent = new Intent(home.this, search.class);
                startActivity(intent);
            }
        });
    }
}