package com.example.comp2000_officebookingspace;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.content.Intent;

public class MyBookingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_my_bookings);

        LinearLayout pendingCard = findViewById(R.id.pendingBookingCard);
        LinearLayout confirmedCard = findViewById(R.id.confirmedBookingCard);

        Button withdrawButton = findViewById(R.id.withdrawRequestButton);
        Button cancelButton = findViewById(R.id.cancelBookingButton);
        Button homeNavButton = findViewById(R.id.homeNavButton);
        Button searchNavButton = findViewById(R.id.searchNavButton);
        Button bookingsNavButton = findViewById(R.id.bookingsNavButton);

        homeNavButton.setOnClickListener(v -> {
            startActivity(new Intent(this, EmployeeHomeActivity.class));
        });

        searchNavButton.setOnClickListener(v -> {
            startActivity(new Intent(this, SearchAvailabilityActivity.class));
        });

        bookingsNavButton.setOnClickListener(v -> {
            // Already on My Bookings
        });

        withdrawButton.setOnClickListener(v -> {
            pendingCard.setVisibility(View.GONE);

            Toast.makeText(this,
                    "Booking request withdrawn",
                    Toast.LENGTH_SHORT).show();
        });

        cancelButton.setOnClickListener(v -> {
            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("Cancel booking?")
                    .setMessage("Are you sure you want to cancel this booking?")
                    .setNegativeButton("Keep booking", (dialog, which) -> dialog.dismiss())
                    .setPositiveButton("Cancel booking", (dialog, which) -> {
                        confirmedCard.setVisibility(View.GONE);

                        Toast.makeText(this,
                                "Booking cancelled",
                                Toast.LENGTH_SHORT).show();
                    })
                    .show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}