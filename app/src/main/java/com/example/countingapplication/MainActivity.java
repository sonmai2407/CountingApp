package com.example.countingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView countTextView;
    private Button blackButton, redButton, blueButton, greenButton, countButton, resetButton;
    private int count;
    private String selectedColor;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView = findViewById(R.id.countTextView);
        blackButton = findViewById(R.id.blackButton);
        redButton = findViewById(R.id.redButton);
        blueButton = findViewById(R.id.blueButton);
        greenButton = findViewById(R.id.greenButton);
        countButton = findViewById(R.id.countButton);
        resetButton = findViewById(R.id.resetButton);

        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        count = preferences.getInt("count", 0);
        selectedColor = preferences.getString("color", "grey");

        countTextView.setText(String.valueOf(count));
        countTextView.setBackgroundColor(Color.parseColor(selectedColor));

        blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = "black";
                countTextView.setBackgroundColor(Color.parseColor(selectedColor));
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = "red";
                countTextView.setBackgroundColor(Color.parseColor(selectedColor));
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = "blue";
                countTextView.setBackgroundColor(Color.parseColor(selectedColor));
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = "green";
                countTextView.setBackgroundColor(Color.parseColor(selectedColor));
            }
        });

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                countTextView.setText(String.valueOf(count));
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                selectedColor = "grey";
                countTextView.setText(String.valueOf(count));
                countTextView.setBackgroundColor(Color.parseColor(selectedColor));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("count", count);
        editor.putString("color", selectedColor);
        editor.apply();
    }
}
