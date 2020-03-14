package com.example.oneclicktrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
<<<<<<< Updated upstream

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
=======
                if(check_available()){
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference().child("items");
                    myRef.push().setValue(sell_phone);
                    finish();
                }
>>>>>>> Stashed changes
            }
        });
    }
    public boolean check_available(){
        String msg, s, s2, s3;
        EditText editTextBrand =(EditText) findViewById(R.id.editTextBrand);
        String brand = editTextBrand.getText().toString();
        if(brand.length() == 0){
            msg = "brand cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"brand empty");
            return false;
        }
        else{
            sell_phone.setBrand(brand);
        }
        EditText editTextModel =(EditText) findViewById(R.id.editTextModel);
        String model = editTextModel.getText().toString();
        if(model.length() == 0){
            msg = "model cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"model empty");
            return false;
        }
        else{
            sell_phone.setModel(model);
        }

        EditText editTextColor =(EditText) findViewById(R.id.editTextColor);
        String color = editTextColor.getText().toString();
        if(color.length() == 0){
            msg = "color cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"color empty");
            return false;
        }
        else{
            sell_phone.setColor(color);
        }

        EditText editTextCondition = (EditText)findViewById(R.id.editTextCondition);
        String condition = editTextCondition.getText().toString();
        if(condition.length() == 0){
            msg = "condition cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"condition empty");
            return false;
        }
        else{
            sell_phone.setCondition(condition);
        }

        EditText editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        double price = Double.parseDouble(editTextPrice.getText().toString());
        s = price + "";
        if(s.length() == 0){
            msg = "price cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"price empty");
            return false;
        }
        else{
            sell_phone.setPrice(price);
        }

        EditText editTextRam = (EditText) findViewById(R.id.editTextRam);
        int ram = Integer.parseInt(editTextRam.getText().toString());
        s2 = ram + "";
        if(s2.length() == 0){
            msg = "ram cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"ram empty");
            return false;
        }
        else{
            sell_phone.setRAMSize(ram);
        }

        EditText editTextStorage = (EditText)findViewById(R.id.editTextStorage);
        int storage = Integer.parseInt(editTextStorage.getText().toString());
        s3 = storage + "";
        if(s3.length() == 0){
            msg = "storage cannot be empty.\n";
            AlertTable a = new AlertTable(msg);
            a.show(getSupportFragmentManager(),"storage empty");
            return false;
        }
        else{
            sell_phone.setStorageSize(storage);
        }

        return true;
    }

}
