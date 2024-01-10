package com.example.project_spktht;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivityAlergi extends AppCompatActivity {
    FloatingActionButton tambah;
    com.example.project_spktht.AdapterAlergi adapterAlergi;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<com.example.project_spktht.ModelAlergi> listAlergi;
    RecyclerView tv_tampil_alergi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alergi);

        tambah = findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityAlergi.this, TambahActivityAlergi.class));
            }
        });
        tv_tampil_alergi = findViewById(R.id.tv_tampil_alergi);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        tv_tampil_alergi.setLayoutManager(mLayout);
        tv_tampil_alergi.setItemAnimator(new DefaultItemAnimator());

        tampilData();
    }

    private void tampilData() {
        database.child("Alergi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listAlergi = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    com.example.project_spktht.ModelAlergi alergi = item.getValue(com.example.project_spktht.ModelAlergi.class);
                    alergi.setKey(item.getKey());
                    listAlergi.add(alergi);
                }
                adapterAlergi =new com.example.project_spktht.AdapterAlergi(listAlergi, MainActivityAlergi.this);
                tv_tampil_alergi.setAdapter(adapterAlergi);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}