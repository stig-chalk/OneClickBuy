package com.example.oneclicktrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class ContentViewActivity extends AppCompatActivity {
    public TextView model, brand, condition, color, ram, storage, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view);
//        model = (TextView) findViewById(R.id.cell_image);

<<<<<<< Updated upstream
=======
    public void trigerAlert() {
        String msg = "May only offer price no lower than $" + phoneItem.getPrice()*0.8 + " (80% of original price), and no higher than original price.\n";
        AlertTable a = new AlertTable(msg);
        a.show(getSupportFragmentManager(), "Offer Price");
>>>>>>> Stashed changes
    }
}
