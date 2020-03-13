package com.example.oneclicktrader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements mAdp.CellOnClick{

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRefer = db.getReference().child("items");

//<<<<<<< HEAD
//<<<<<<< Updated upstream
//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter adapter;
//    private RecyclerView.LayoutManager layoutManager;
//    private ArrayList<phoneItem> phoneItems = new ArrayList<phoneItem>();

    private RecyclerView recycleV;
    private RecyclerView.Adapter adp;
    private RecyclerView.LayoutManager layoutM;
    private Button sellbtn, filterbtn;
    private ArrayList<phoneItem> phoneItems = new ArrayList<phoneItem>();

//    private RecyclerView recycleV;
//    private RecyclerView.Adapter adp;
//    private RecyclerView.LayoutManager layoutM;
//    private ArrayList<phoneItem> phoneItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        phoneItem item1 = new phoneItem("Apple", "IPhone XS", "New", "Black", 550, 8, 128);
//        phoneItem item2 = new phoneItem("Samsung", "Samsung S10", "Used", "Flamingo Pink", 450, 16, 256);
//        phoneItem item3 = new phoneItem("OnePlus", "OnePlus 7T", "New", "Blue", 450, 8, 128);
//        dbRefer.push().setValue(item1);
//        dbRefer.push().setValue(item2);
//        dbRefer.push().setValue(item3);
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
        recycleV = findViewById(R.id.scrollView);
        recycleV.setHasFixedSize(true);
        layoutM = new LinearLayoutManager(this);
        adp = new mAdp(phoneItems, this);
        recycleV.setAdapter(adp);
        recycleV.setLayoutManager(layoutM);
        updateData();
    }

    private void updateData() {
        final MainActivity t = this;
        dbRefer.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    phoneItem value = ds.getValue(phoneItem.class);
                    phoneItems.add(value);

                }
                adp = new mAdp(phoneItems, t);
                recycleV.setAdapter(adp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void cellOnClick(int position) {
//       System.out.println("Onclick" + position);
        Intent intent = new Intent(this, ContentViewActivity.class);
        startActivity(intent);
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

