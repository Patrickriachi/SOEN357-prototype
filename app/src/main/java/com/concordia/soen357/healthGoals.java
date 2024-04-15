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

public class healthGoals extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    EditText searchGoal;
    Button resetButton;
    ArrayList<TextView> goalTextViews;
    ArrayList<String> selectedGoals;  // List to track selected goals

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_goals);

        listView = findViewById(R.id.listView);
        searchGoal = findViewById(R.id.editTextTextPersonName7);
        resetButton = findViewById(R.id.button3);
        Button skipButton = findViewById(R.id.skipButton);

        // Initialize TextViews for selected goals
        goalTextViews = new ArrayList<>();
        goalTextViews.add((TextView) findViewById(R.id.textView26));
        goalTextViews.add((TextView) findViewById(R.id.textView27));
        goalTextViews.add((TextView) findViewById(R.id.textView28));
        goalTextViews.add((TextView) findViewById(R.id.textView29));
        goalTextViews.add((TextView) findViewById(R.id.textView30));

        // Initialize the list to track selected goals
        selectedGoals = new ArrayList<>();

        // Expanded list of health goals
        String[] goals = new String[]{"Lose Fat", "Low Carbs", "High Protein", "High Fiber",
                "Build Muscle", "Improve Flexibility", "Enhance Endurance",
                "Boost Immunity", "Reduce Stress", "Improve Sleep",
                "Better Hydration", "Increase Energy", "Balance Nutrition",
                "Heart Health", "Post-Injury Recovery", "Mental Wellness"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(goals)));
        listView.setAdapter(adapter);

        // Search functionality
        searchGoal.addTextChangedListener(new TextWatcher() {
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
            String selectedGoal = adapter.getItem(position);
            if (!selectedGoals.contains(selectedGoal)) {  // Check if goal is already selected
                for (TextView textView : goalTextViews) {
                    if (textView.getText().toString().isEmpty()) {
                        textView.setText(selectedGoal);
                        selectedGoals.add(selectedGoal);  // Add to selected goals list
                        break;
                    }
                }
            }
        });

        // Reset functionality
        resetButton.setOnClickListener(v -> {
            searchGoal.setText("");
            for (TextView textView : goalTextViews) {
                textView.setText("");
            }
            selectedGoals.clear();  // Clear the list of selected goals
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(goals)));
            listView.setAdapter(adapter);
        });

        // Skip button functionality
        skipButton.setOnClickListener(v -> {
            Intent intent = new Intent(healthGoals.this, home.class);
            startActivity(intent);
        });
    }
}
