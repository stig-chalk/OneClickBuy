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

    }
}
