package com.example.project_spktht;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahActivityAlergi extends AppCompatActivity {
    EditText edAlergi, edTanggalTerjangkit, edBahanAlergen, edJenisAlergi, edGejalaAlergi, edReaksiAlergi;
    Button btn_simpan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_alergi);

        edAlergi = findViewById(R.id.edAlergi);
        edTanggalTerjangkit = findViewById(R.id.edTanggalTerjangkit);
        edBahanAlergen = findViewById(R.id.edBahanAlergen);
        edJenisAlergi = findViewById(R.id.edJenisAlergi);
        edGejalaAlergi = findViewById(R.id.edGejalaAlergi);
        edReaksiAlergi = findViewById(R.id.edReaksiAlergi);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getAlergi = edAlergi.getText().toString();
                String getTanggalTerjangkit = edTanggalTerjangkit.getText().toString();
                String getBahanAlergen = edBahanAlergen.getText().toString();
                String getJenisAlergi = edJenisAlergi.getText().toString();
                String getGejalaAlergi = edGejalaAlergi.getText().toString();
                String getReaksiAlergi = edReaksiAlergi.getText().toString();

                if (getAlergi.isEmpty()){
                    edAlergi.setError("Inputkan Data Alergi!");
                } else if (getTanggalTerjangkit.isEmpty()) {
                    edTanggalTerjangkit.setError("Inputkan Tanggal Terjangkit!");
                } else if (getBahanAlergen.isEmpty()) {
                    edBahanAlergen.setError("Inputkan Bahan Alergen!");
                } else if (getJenisAlergi.isEmpty()) {
                    edJenisAlergi.setError("Inputkan Jenis Alergi");
                } else if (getGejalaAlergi.isEmpty()) {
                    edGejalaAlergi.setError("Inputkan Gejala Alergi!");
                } else if (getReaksiAlergi.isEmpty()) {
                    edReaksiAlergi.setError("Inputkan Reaksi dari Alergi!");
                } else {
                    database.child("Alergi").push().setValue(new com.example.project_spktht.ModelAlergi(getAlergi, getTanggalTerjangkit, getBahanAlergen, getJenisAlergi, getGejalaAlergi, getReaksiAlergi)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(TambahActivityAlergi.this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(TambahActivityAlergi.this, MainActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TambahActivityAlergi.this, "Gagal Menyimpan Data!", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}
