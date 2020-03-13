package com.example.oneclicktrader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.LogPrinter;
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


    private RecyclerView recycleV;
    private RecyclerView.Adapter adp;
    private RecyclerView.LayoutManager layoutM;
    private Button sellbtn, filterbtn;
    private ArrayList<phoneItem> phoneItems, originalItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phoneItems = new ArrayList<>();
        originalItems = new ArrayList<>();


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
            phoneItems.clear();
            originalItems.clear();
            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    phoneItem value = ds.getValue(phoneItem.class);
                    value.setKey(ds.getKey());
                    value.setImageSource();
                    phoneItems.add(value);
                    originalItems.add(value);
                }
                adp.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void cellOnClick(int position) {
        Intent intent = new Intent(this, ContentViewActivity.class);
        intent.putExtra("selectedPhone", phoneItems.get(position));
        startActivity(intent);
    }

    public void openSell(){
        Intent in = new Intent(this, sellActivity.class);
        startActivity(in);
    }

    public void openFilter(){
        Intent in = new Intent(this, filterActivity.class);
        startActivityForResult(in, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                phoneItem filters = (phoneItem) data.getSerializableExtra("filteredPhone");
                filterPhones(filters);
            }
        }
    }

    private void filterPhones(phoneItem filters) {
        phoneItems.clear();

        String[] attrs = new String[4];
        attrs[0] = filters.getBrand().toLowerCase();
        attrs[1] = filters.getModel().toLowerCase();
        attrs[2] = filters.getColor().toLowerCase();
        attrs[3] = filters.getCondition().toLowerCase();
        int minRam = filters.getRAMSize();
        int minStor = filters.getStorageSize();
        double maxPrice = filters.getPrice();

        for (phoneItem p : originalItems) {
            if ((attrs[0].equals("nan") || (attrs[0].equals(p.getBrand().toLowerCase())))
             && (attrs[1].equals("nan") || (attrs[1].equals(p.getModel().toLowerCase())))
             && (attrs[2].equals("nan") || (attrs[2].equals(p.getColor().toLowerCase())))
             && (attrs[3].equals("nan") || (attrs[3].equals(p.getCondition().toLowerCase())))
             && (p.getRAMSize() >= minRam) && (p.getStorageSize() >= minStor)
             && (p.getPrice() <= maxPrice))
                phoneItems.add(p);
        }

        adp.notifyDataSetChanged();
    }
}

