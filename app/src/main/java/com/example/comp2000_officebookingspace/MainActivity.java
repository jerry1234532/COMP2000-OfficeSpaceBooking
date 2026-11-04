package com.example.comp2000_officebookingspace;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usernameInput = findViewById(R.id.usernameInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {

            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {

                Toast.makeText(this,
                        "Please enter your email and password",
                        Toast.LENGTH_SHORT).show();

            } else {

                Intent intent = new Intent(MainActivity.this,
                        EmployeeHomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
