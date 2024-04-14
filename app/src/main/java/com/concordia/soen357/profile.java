package com.concordia.soen357;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        navView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(profile.this, home.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(profile.this, search.class));
                    return true;
                case R.id.navigation_profile:
                    return true;
                default:
                    return false;
            }
        });

        // Set the home as selected by default
        navView.setSelectedItemId(R.id.navigation_profile);

    }
}