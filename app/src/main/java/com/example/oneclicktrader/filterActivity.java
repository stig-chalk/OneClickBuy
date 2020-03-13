package com.example.oneclicktrader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class filterActivity extends AppCompatActivity {
    public static final String EXTRA_PHONE = "com.example.onecliktrader.EXTRA_PHONE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Button confirmbtn = (Button)findViewById(R.id.confirmbtn);
        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMain();
            }
        });
    }
    public void backToMain(){
        TextView txtViewBrand =(TextView)findViewById(R.id.txtViewBrand);
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
        int ram = Integer.parseInt(txtViewRam.getText().toString());
        TextView txtViewStorage = (TextView)findViewById(R.id.textViewStorage);
        int storage = Integer.parseInt(txtViewStorage.getText().toString());

        Intent in = new Intent(this, MainActivity.class);
        phoneItem phone_item = new phoneItem(brand, model, condition, color, price, ram, storage);
        in.putExtra(EXTRA_PHONE, (Parcelable) phone_item);//传回到main
        startActivity(in);
    }
}
