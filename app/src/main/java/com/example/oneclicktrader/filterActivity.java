package com.example.oneclicktrader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class filterActivity extends AppCompatActivity {
    public phoneItem phone_item;
    private TextView brand, model, condition, price, ram, storage, color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        phone_item = new phoneItem("nan", "nan", "nan", "nan", Double.POSITIVE_INFINITY, 0, 0);

        brand = findViewById(R.id.filter_brand);
        model = findViewById(R.id.filter_model);
        condition = findViewById(R.id.filter_condition);
        price = findViewById(R.id.filter_price);
        ram = findViewById(R.id.filter_ram);
        storage = findViewById(R.id.filter_storage);
        color = findViewById(R.id.filter_color);


        Button confirmbtn = findViewById(R.id.confirmbtn);
        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });
    }
    public void backToMain(){
        String brandi = brand.getText().toString();
        if (!brandi.isEmpty())
            phone_item.setBrand(brandi);

        String modeli = model.getText().toString();
        if (!modeli.isEmpty())
            phone_item.setModel(modeli);

        String conditioni = condition.getText().toString();
        if (!conditioni.isEmpty())
            phone_item.setCondition(conditioni);

        String colori = color.getText().toString();
        if (!colori.isEmpty())
            phone_item.setColor(colori);

        String pricei = price.getText().toString();
        if (!pricei.isEmpty()) {
            try {
                Double num = Double.parseDouble(pricei);
                phone_item.setPrice(num);
            } catch (NumberFormatException e) {}
        }

        String rami = ram.getText().toString();
        if (!rami.isEmpty()) {
            try {
                int ramNum = Integer.parseInt(rami);
                phone_item.setRAMSize(ramNum);
            } catch (NumberFormatException e) {}
        }

        String storagei = storage.getText().toString();
        if (!storagei.isEmpty()) {
            try {
                int storageNum = Integer.parseInt(storagei);
                phone_item.setStorageSize(storageNum);
            } catch (NumberFormatException e) {}
        }

        Intent returnIntent = new Intent();
        returnIntent.putExtra("filteredPhone", phone_item);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}
