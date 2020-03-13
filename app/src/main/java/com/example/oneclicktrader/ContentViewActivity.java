package com.example.oneclicktrader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ContentViewActivity extends AppCompatActivity implements PriceInputTable.PriceListener {
    public TextView model, brand, condition, color, ram, storage, price;
    private phoneItem phoneItem;
    private Button buy_btn, offer_btn;
    private DatabaseReference dbRefer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);
        phoneItem = (phoneItem) getIntent().getSerializableExtra("selectedPhone");
        connectViewElements();
        setTexts();
    }

    private void connectViewElements() {
        model = findViewById(R.id.model);
        brand = findViewById(R.id.brand);
        condition = findViewById(R.id.condition);
        color = findViewById(R.id.color);
        ram = findViewById(R.id.ramSize);
        storage = findViewById(R.id.storage);
        price = findViewById(R.id.price);
        buy_btn = findViewById(R.id.buy);
        offer_btn = findViewById(R.id.offer);

        dbRefer = FirebaseDatabase.getInstance().getReference().child("items").child(phoneItem.getKey());

        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseItem();
            }
        });

        offer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offerPrice();
            }
        });
    }

    private void setTexts() {
        model.setText(phoneItem.getModel());
        brand.setText("Brand: " + phoneItem.getBrand());
        condition.setText("Condition: " + phoneItem.getCondition());
        color.setText("Color: " + phoneItem.getColor());
        ram.setText("RAM: " + phoneItem.getRAMSize());
        storage.setText("Storage: " + phoneItem.getStorageSize());
        price.setText("$" + phoneItem.getPrice());
    }

    private void purchaseItem() {
        dbRefer.removeValue();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void offerPrice() {
        PriceInputTable p = new PriceInputTable();
        p.show(getSupportFragmentManager(), "Offer Price");
    }

    @Override
    public void setOfferedPrice(double priceOffered) {
        if (priceOffered >= phoneItem.getPrice()*0.8) {
            phoneItem.setPrice(priceOffered);
            dbRefer.setValue(phoneItem);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else
            trigerAlert();
    }

    public void trigerAlert() {
        AlertTable a = new AlertTable(phoneItem.getPrice());
        a.show(getSupportFragmentManager(), "Offer Price");
    }
}
