package com.example.miniecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button startShoppingButton = findViewById(R.id.btnStartShopping);

        // Navigate to product screen using explicit intent.
        startShoppingButton.setOnClickListener(v -> {
            Intent intent = new Intent(SplashActivity.this, ProductActivity.class);
            startActivity(intent);
        });
    }
}
