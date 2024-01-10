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

public class MainActivityPenyakit extends AppCompatActivity {
    FloatingActionButton tambah;
    com.example.project_spktht.AdapterPenyakit adapterPenyakit;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<com.example.project_spktht.ModelPenyakit> listPenyakit;
    RecyclerView tv_tampil_penyakit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_penyakit);

        tambah = findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityPenyakit.this, TambahActivityPenyakit.class));
            }
        });
        tv_tampil_penyakit = findViewById(R.id.tv_tampil_penyakit);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        tv_tampil_penyakit.setLayoutManager(mLayout);
        tv_tampil_penyakit.setItemAnimator(new DefaultItemAnimator());

        tampilData();
    }

    private void tampilData() {
        database.child("Penyakit").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listPenyakit = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    com.example.project_spktht.ModelPenyakit penyakit = item.getValue(com.example.project_spktht.ModelPenyakit.class);
                    penyakit.setKey(item.getKey());
                    listPenyakit.add(penyakit);
                }
                adapterPenyakit =new com.example.project_spktht.AdapterPenyakit(listPenyakit, MainActivityPenyakit.this);
                tv_tampil_penyakit.setAdapter(adapterPenyakit);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}