package com.example.comp2000_officebookingspace;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class AvailableRoomsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_available_rooms);

        RadioGroup availableRoomsGroup =
                findViewById(R.id.availableRoomsGroup);

        EditText purposeInput =
                findViewById(R.id.purposeInput);

        Button submitBookingButton =
                findViewById(R.id.submitBookingButton);

        submitBookingButton.setOnClickListener(v -> {

            int selectedId = availableRoomsGroup.getCheckedRadioButtonId();

            String purpose = purposeInput.getText().toString().trim();

            if (selectedId == -1) {
                Toast.makeText(this,
                        "Please select a room",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (purpose.isEmpty()) {
                Toast.makeText(this,
                        "Please enter the booking purpose",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedRoom = findViewById(selectedId);

            Toast.makeText(this,
                    "Request submitted for " +
                            selectedRoom.getText().toString(),
                    Toast.LENGTH_LONG).show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}