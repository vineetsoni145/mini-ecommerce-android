package com.example.miniecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        TextView tvSelectedProducts = findViewById(R.id.tvSelectedProductsValue);
        TextView tvTotalAmount = findViewById(R.id.tvTotalAmountValue);
        Button btnConfirmOrder = findViewById(R.id.btnConfirmOrder);
        Button btnBackToProducts = findViewById(R.id.btnBackToProducts);

        ArrayList<String> selectedProducts = getIntent().getStringArrayListExtra("selected_products");
        int totalAmount = getIntent().getIntExtra("total_amount", 0);

        // Display received order details from ProductActivity.
        if (selectedProducts != null && !selectedProducts.isEmpty()) {
            String productsText = android.text.TextUtils.join("\n", selectedProducts);
            tvSelectedProducts.setText(productsText);
        } else {
            tvSelectedProducts.setText(R.string.no_products);
        }

        tvTotalAmount.setText(getString(R.string.total_format, totalAmount));

        // Navigate to confirmation screen using explicit intent.
        btnConfirmOrder.setOnClickListener(v -> {
            Intent intent = new Intent(BillActivity.this, ConfirmationActivity.class);
            startActivity(intent);
        });

        // Close this screen and go back to product list.
        btnBackToProducts.setOnClickListener(v -> finish());
    }
}
