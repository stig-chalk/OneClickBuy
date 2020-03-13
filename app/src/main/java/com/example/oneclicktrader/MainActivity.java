package com.example.oneclicktrader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRefer = db.getReference().child("items");

<<<<<<< Updated upstream
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<phoneItem> phoneItems = new ArrayList<phoneItem>();
=======
    private RecyclerView recycleV;
    private RecyclerView.Adapter adp;
    private RecyclerView.LayoutManager layoutM;
    private Button sellbtn, filterbtn;
//    private ArrayList<phoneItem> phoneItems = new ArrayList<phoneItem>();
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        phoneItem item1 = new phoneItem("Iphone X", "Used", 500, 128);
        dbRefer.child("item1").setValue(item1);

<<<<<<< Updated upstream
        recyclerView = (RecyclerView)findViewById(R.id.scrollView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());

=======
        sellbtn = (Button) findViewById(R.id.sellbtn);
        filterbtn = (Button)findViewById(R.id.filterbtn);
        sellbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSell();
            }
        });
        filterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilter();
            }
        });
>>>>>>> Stashed changes

    }
    public void openSell(){
        Intent in = new Intent(this, sellActivity.class);
        startActivity(in);
    }
    public void openFilter(){
        Intent in = new Intent(this, filterActivity.class);
        startActivity(in);
    }

}
