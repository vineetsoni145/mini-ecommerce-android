package com.example.miniecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        Button btnGoHome = findViewById(R.id.btnGoHome);

        // Navigate back to ProductActivity and clear upper screens.
        btnGoHome.setOnClickListener(v -> {
            Intent intent = new Intent(ConfirmationActivity.this, ProductActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}
