package com.example.oneclicktrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sellActivity extends AppCompatActivity {
    private Button confbtn;
    public phoneItem sell_phone = new phoneItem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        confbtn = findViewById(R.id.confirmbtn);
        confbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               check_available();
           }
        });
    }

    public void check_available(){
        String msg, s, s2, s3;
        EditText editTextBrand =(EditText) findViewById(R.id.sell_brand);
        String brand = editTextBrand.getText().toString();
        if(brand.length() == 0){
            msg = "brand cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"brand empty");
            return;
        }
        else{
            sell_phone.setBrand(brand);
        }
        EditText editTextModel =(EditText) findViewById(R.id.sell_model);
        String model = editTextModel.getText().toString();
        if(model.length() == 0){
            msg = "model cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"model empty");
            return ;
        }
        else{
            sell_phone.setModel(model);
        }

        EditText editTextColor =(EditText) findViewById(R.id.sell_color);
        String color = editTextColor.getText().toString();
        if(color.length() == 0){
            msg = "color cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"color empty");
            return ;
        }
        else{
            sell_phone.setColor(color);
        }

        EditText editTextCondition = (EditText)findViewById(R.id.sell_condition);
        String condition = editTextCondition.getText().toString();
        if(condition.length() == 0){
            msg = "condition cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"condition empty");
            return ;
        }
        else{
            sell_phone.setCondition(condition);
        }


        EditText editTextRam = (EditText) findViewById(R.id.sell_ram);
        try {
            int ram = Integer.parseInt(editTextRam.getText().toString());
            sell_phone.setRAMSize(ram);
        } catch (NumberFormatException e) {
            msg = "RAM cannot be empty and must be a number.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"ram empty");
            return;
        }

        EditText editTextStorage = (EditText)findViewById(R.id.sell_storage);
        try {
            int storage = Integer.parseInt(editTextStorage.getText().toString());
            sell_phone.setStorageSize(storage);
        } catch (NumberFormatException e) {
            msg = "Storage cannot be empty and must be a number.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"storage empty");
            return;
        }

        EditText editTextPrice = (EditText)findViewById(R.id.sell_price);
        try {
            double price = Double.parseDouble(editTextPrice.getText().toString());
            sell_phone.setPrice(price);
        } catch (NumberFormatException e) {
            msg = "Price cannot be empty and must be a number.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"price empty");
            return;
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("items");
        myRef.push().setValue(sell_phone);
        finish();
    }

}