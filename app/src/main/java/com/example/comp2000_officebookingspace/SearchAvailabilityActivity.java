package com.example.comp2000_officebookingspace;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.Toast;

public class SearchAvailabilityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_search_availability);
        EditText dateInput = findViewById(R.id.dateInput);
        EditText startTimeInput = findViewById(R.id.startTimeInput);
        EditText endTimeInput = findViewById(R.id.endTimeInput);
        RadioGroup roomTypeGroup = findViewById(R.id.roomTypeGroup);
        Button searchRoomsButton = findViewById(R.id.searchRoomsButton);

        searchRoomsButton.setOnClickListener(v -> {

            String date = dateInput.getText().toString().trim();
            String startTime = startTimeInput.getText().toString().trim();
            String endTime = endTimeInput.getText().toString().trim();

            if (date.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
                Toast.makeText(this,
                        "Please complete all search fields",
                        Toast.LENGTH_SHORT).show();
            } else if (roomTypeGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this,
                        "Please select a room type",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "Search details entered successfully!",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }