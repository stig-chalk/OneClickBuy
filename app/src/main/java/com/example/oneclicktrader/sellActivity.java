package com.example.oneclicktrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sellActivity extends AppCompatActivity {
    private Button confbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);




        confbtn = findViewById(R.id.confirmbtn);
        confbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView txtViewBrand =(TextView)findViewById(R.id.textViewBrand);
                String brand = txtViewBrand.getText().toString();

                TextView txtViewModel =(TextView)findViewById(R.id.txtViewModel);
                String model = txtViewModel.getText().toString();
                TextView txtViewColor =(TextView)findViewById(R.id.textViewColor);
                String color = txtViewModel.getText().toString();

                TextView txtViewCondition = (TextView)findViewById(R.id.textViewCondition);
                String condition = txtViewCondition.getText().toString();

                TextView txtViewPrice = (TextView)findViewById(R.id.textViewPrice);
                double price = Double.parseDouble(txtViewPrice.getText().toString());

                TextView txtViewRam = (TextView)findViewById(R.id.textViewRAM);
                long l = Long.parseLong(txtViewRam.getText().toString());
                int ram = (int)l;

                TextView txtViewStorage = (TextView)findViewById(R.id.textViewStorage);
                long l2 = Long.parseLong(txtViewStorage.getText().toString());
                int storage = (int)l2;
                final phoneItem sell_phone = new phoneItem(brand, model, condition, color, price, ram, storage);


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference().child("items");//加入数据库
                myRef.push().setValue(sell_phone);
                finish();
            }
        });
    }
}
