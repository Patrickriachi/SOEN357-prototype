package com.concordia.soen357;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find the button by its ID
        Button skipButton = findViewById(R.id.skipButton);
        TextView textView = findViewById(R.id.textView4);
        TextView textView2 = findViewById(R.id.textView8);
        textView2.setText("Featured");
        textView2.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        String text = "20 Wholesome Diner Recipes";

        SpannableString spannable = new SpannableString(text);

        // Underline and color "20"
        spannable.setSpan(new UnderlineSpan(), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8976")), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Underline and color "Diner Recipes"
        int dinerStart = text.indexOf("Diner");
        int dinerEnd = text.length();
        spannable.setSpan(new UnderlineSpan(), dinerStart, dinerEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8976")), dinerStart, dinerEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannable);

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