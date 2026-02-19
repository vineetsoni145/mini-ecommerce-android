package com.example.miniecommerce;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private CheckBox cbMobilePhone;
    private CheckBox cbHeadphones;
    private CheckBox cbSmartWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        cbMobilePhone = findViewById(R.id.cbMobilePhone);
        cbHeadphones = findViewById(R.id.cbHeadphones);
        cbSmartWatch = findViewById(R.id.cbSmartWatch);
        Button btnViewBill = findViewById(R.id.btnViewBill);

        btnViewBill.setOnClickListener(v -> openBillScreen());
    }

    private void openBillScreen() {
        ArrayList<String> selectedProducts = new ArrayList<>();
        int totalAmount = 0;

        // Add selected product names and update total amount.
        if (cbMobilePhone.isChecked()) {
            selectedProducts.add(getString(R.string.product_mobile));
            totalAmount += 15000;
        }

        if (cbHeadphones.isChecked()) {
            selectedProducts.add(getString(R.string.product_headphones));
            totalAmount += 2000;
        }

        if (cbSmartWatch.isChecked()) {
            selectedProducts.add(getString(R.string.product_smart_watch));
            totalAmount += 3000;
        }

        // Prevent moving forward when no products are selected.
        if (selectedProducts.isEmpty()) {
            Toast.makeText(this, R.string.toast_select_product, Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(ProductActivity.this, BillActivity.class);
        intent.putStringArrayListExtra("selected_products", selectedProducts);
        intent.putExtra("total_amount", totalAmount);
        startActivity(intent);
    }
}
