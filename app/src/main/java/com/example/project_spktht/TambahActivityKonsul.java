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

public class TambahActivityKonsul extends AppCompatActivity {
    EditText edKonsulKe, edTanggal, edDokter, edKlinik, edKeluhan, edDiagnosa;
    Button btn_simpan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_konsul);

        edKonsulKe = findViewById(R.id.edKonsulKe);
        edTanggal = findViewById(R.id.edTanggal);
        edDokter = findViewById(R.id.edDokter);
        edKlinik = findViewById(R.id.edKlinik);
        edKeluhan = findViewById(R.id.edKeluhan);
        edDiagnosa = findViewById(R.id.edDiagnosa);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getKonsulKe = edKonsulKe.getText().toString();
                String getTanggal = edTanggal.getText().toString();
                String getDokter = edDokter.getText().toString();
                String getKlinik = edKlinik.getText().toString();
                String getKeluhan = edKeluhan.getText().toString();
                String getDiagnosa = edDiagnosa.getText().toString();

                if (getKonsulKe.isEmpty()){
                    edKonsulKe.setError("Inputkan Data Konsultasi!");
                } else if (getTanggal.isEmpty()) {
                    edTanggal.setError("Inputkan Tanggal Konsultasi!");
                } else if (getDokter.isEmpty()) {
                    edDokter.setError("Inputkan Nama Dokter!");
                } else if (getKlinik.isEmpty()) {
                    edKlinik.setError("Inpitkan Nama Klinik/Rumah Sakit");
                } else if (getKeluhan.isEmpty()) {
                    edKeluhan.setError("Inputkan Keluhan!");
                } else if (getDiagnosa.isEmpty()) {
                    edDiagnosa.setError("Inputkan Diagnosa!");
                } else {
                    database.child("Konsultasi").push().setValue(new com.example.project_spktht.ModelKonsultasi(getKonsulKe, getTanggal,getDokter, getKlinik, getKeluhan, getDiagnosa)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(TambahActivityKonsul.this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(TambahActivityKonsul.this, MainActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TambahActivityKonsul.this, "Gagal Menyimpan Data!", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}
