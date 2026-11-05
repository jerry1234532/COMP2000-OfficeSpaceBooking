package com.example.comp2000_officebookingspace;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BookingConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        Button viewBookingsButton =
                findViewById(R.id.viewMyBookingsButton);

        Button backHomeButton =
                findViewById(R.id.backHomeButton);

        viewBookingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    BookingConfirmationActivity.this,
                    MyBookingsActivity.class
            );
            startActivity(intent);
        });

        backHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    BookingConfirmationActivity.this,
                    EmployeeHomeActivity.class
            );
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}