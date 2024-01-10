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

public class MainActivityKonsul extends AppCompatActivity {
    FloatingActionButton tambah;
    com.example.project_spktht.AdapterKonsultasi adapterKonsultasi;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<com.example.project_spktht.ModelKonsultasi> listKonsultasi;
    RecyclerView tv_tampil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_konsul);

        tambah = findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityKonsul.this, TambahActivityKonsul.class));
            }
        });
        tv_tampil = findViewById(R.id.tv_tampil);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        tv_tampil.setLayoutManager(mLayout);
        tv_tampil.setItemAnimator(new DefaultItemAnimator());

        tampilData();
    }

    private void tampilData() {
        database.child("Konsultasi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listKonsultasi = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    com.example.project_spktht.ModelKonsultasi konsul = item.getValue(com.example.project_spktht.ModelKonsultasi.class);
                    konsul.setKey(item.getKey());
                    listKonsultasi.add(konsul);
                }
                adapterKonsultasi =new com.example.project_spktht.AdapterKonsultasi(listKonsultasi, MainActivityKonsul.this);
                tv_tampil.setAdapter(adapterKonsultasi);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}