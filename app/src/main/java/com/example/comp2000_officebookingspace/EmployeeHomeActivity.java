package com.example.comp2000_officebookingspace;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
public class EmployeeHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_employee_home);
        Button searchButton = findViewById(R.id.searchAvailabilityButton);
        Button searchNavButton = findViewById(R.id.searchNavButton);
        Button viewBookingsButton = findViewById(R.id.viewBookingsButton);
        Button bookingsNavButton = findViewById(R.id.bookingsNavButton);

        View.OnClickListener openBookings = v -> {
            Intent intent = new Intent(
                    EmployeeHomeActivity.this,
                    MyBookingsActivity.class
            );
            startActivity(intent);
        };

        viewBookingsButton.setOnClickListener(openBookings);
        bookingsNavButton.setOnClickListener(openBookings);

        View.OnClickListener openSearch = v -> {
            Intent intent = new Intent(EmployeeHomeActivity.this,
                    SearchAvailabilityActivity.class);
            startActivity(intent);
        };

        searchButton.setOnClickListener(openSearch);
        searchNavButton.setOnClickListener(openSearch);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}