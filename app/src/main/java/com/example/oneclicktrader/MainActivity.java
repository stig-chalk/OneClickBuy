package com.example.oneclicktrader;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRefer = db.getReference().child("items");

    private RecyclerView recycleV;
    private RecyclerView.Adapter adp;
    private RecyclerView.LayoutManager layoutM;
//    private ArrayList<phoneItem> phoneItems = new ArrayList<phoneItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        phoneItem item1 = new phoneItem("Iphone X", "Used", 500, 128);
//        dbRefer.child("item3").setValue(item1);

        ArrayList<cell_item_c> cell_item_cs = new ArrayList<>();
        cell_item_cs.add(new cell_item_c("OnePlus", "Oneplus 7 Pro", "Used", "Blue", 350, R.drawable.ic_android));
        cell_item_cs.add(new cell_item_c("Apple", "iPhone XS", "New", "Gold", 550, R.drawable.ic_android));
        cell_item_cs.add(new cell_item_c("Samsung", "Galaxy S10e", "Used", "Yellow", 450, R.drawable.ic_android));

        recycleV = findViewById(R.id.scrollView);
        recycleV.setHasFixedSize(true);
        layoutM = new LinearLayoutManager(this);
        adp = new mAdp(cell_item_cs);
        recycleV.setAdapter(adp);
        recycleV.setLayoutManager(layoutM);



    }


}
