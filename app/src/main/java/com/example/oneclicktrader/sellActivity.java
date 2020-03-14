package com.example.oneclicktrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
<<<<<<< Updated upstream
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
}
