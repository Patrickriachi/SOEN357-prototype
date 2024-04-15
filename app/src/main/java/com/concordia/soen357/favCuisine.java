package com.concordia.soen357;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class favCuisine extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    EditText searchCuisine;
    Button resetButton;
    ArrayList<TextView> cuisineTextViews;
    ArrayList<String> selectedCuisines;  // List to track selected cuisines

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_cuisine);

        listView = findViewById(R.id.listView);
        searchCuisine = findViewById(R.id.editTextTextPersonName7);
        resetButton = findViewById(R.id.button3);
        Button skipButton = findViewById(R.id.skipButton);

        // Initialize TextViews for selected cuisines
        cuisineTextViews = new ArrayList<>();
        cuisineTextViews.add((TextView) findViewById(R.id.textView26));
        cuisineTextViews.add((TextView) findViewById(R.id.textView27));
        cuisineTextViews.add((TextView) findViewById(R.id.textView28));
        cuisineTextViews.add((TextView) findViewById(R.id.textView29));
        cuisineTextViews.add((TextView) findViewById(R.id.textView30));

        // Initialize the list to track selected cuisines
        selectedCuisines = new ArrayList<>();

        // Expanded list of cuisines
        String[] cuisines = new String[]{"Mexican", "Chinese", "Vegan", "Jamaican", "Gluten Free",
                "Italian", "Thai", "French", "Indian", "Japanese",
                "Mediterranean", "Lebanese", "Brazilian", "Ethiopian", "Korean",
                "Turkish", "Greek", "Spanish", "Moroccan", "Russian"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(cuisines)));
        listView.setAdapter(adapter);

        // Search functionality
        searchCuisine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // ListView item click listener
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCuisine = adapter.getItem(position);
            if (!selectedCuisines.contains(selectedCuisine)) {  // Check if cuisine is already selected
                for (TextView textView : cuisineTextViews) {
                    if (textView.getText().toString().isEmpty()) {
                        textView.setText(selectedCuisine);
                        selectedCuisines.add(selectedCuisine);  // Add to selected cuisines list
                        break;
                    }
                }
            }
        });

        // Reset functionality
        resetButton.setOnClickListener(v -> {
            searchCuisine.setText("");
            for (TextView textView : cuisineTextViews) {
                textView.setText("");
            }
            selectedCuisines.clear();  // Clear the list of selected cuisines
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(cuisines)));
            listView.setAdapter(adapter);
        });

        // Skip button functionality
        skipButton.setOnClickListener(v -> {
            Intent intent = new Intent(favCuisine.this, healthGoals.class);
            startActivity(intent);
        });
    }
}
