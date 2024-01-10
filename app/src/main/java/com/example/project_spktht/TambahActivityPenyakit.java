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

public class TambahActivityPenyakit extends AppCompatActivity {
    EditText edPenyakit, edTanggalTerjangkit, edGangguanTelinga, edGangguanHidung, edGangguanTenggorokan, edObat;
    Button btn_simpan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_penyakit);

        edPenyakit = findViewById(R.id.edPenyakit);
        edTanggalTerjangkit = findViewById(R.id.edTanggalTerjangkit);
        edGangguanTelinga = findViewById(R.id.edGangguanTelinga);
        edGangguanHidung = findViewById(R.id.edGangguanHidung);
        edGangguanTenggorokan = findViewById(R.id.edGangguanTenggorokan);
        edObat = findViewById(R.id.edObat);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getPenyakit = edPenyakit.getText().toString();
                String getTanggalTerjangkit = edTanggalTerjangkit.getText().toString();
                String getGangguanTelinga = edGangguanTelinga.getText().toString();
                String getGangguanHidung = edGangguanHidung.getText().toString();
                String getGangguanTenggorokan = edGangguanTenggorokan.getText().toString();
                String getObat = edObat.getText().toString();

                if (getPenyakit.isEmpty()){
                    edPenyakit.setError("Inputkan Nama Penyakit!");
                } else if (getTanggalTerjangkit.isEmpty()) {
                    edTanggalTerjangkit.setError("Inputkan Tanggal Terjangkit!");
                } else if (getGangguanTelinga.isEmpty()) {
                    edGangguanTelinga.setError("Inputkan Riwayat Gangguan Telinga!");
                } else if (getGangguanHidung.isEmpty()) {
                    edGangguanHidung.setError("Inputkan Riwayat Gangguan Hidung");
                } else if (getGangguanTenggorokan.isEmpty()) {
                    edGangguanTenggorokan.setError("Inputkan Riwayat Gangguan Tenggorokan!");
                } else if (getObat.isEmpty()) {
                    edObat.setError("Inputkan Obat-obatan yang dikonsumsi!");
                } else {
                    database.child("Penyakit").push().setValue(new com.example.project_spktht.ModelPenyakit(getPenyakit, getTanggalTerjangkit, getGangguanTelinga, getGangguanHidung, getGangguanTenggorokan, getObat)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(TambahActivityPenyakit.this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(TambahActivityPenyakit.this, MainActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TambahActivityPenyakit.this, "Gagal Menyimpan Data!", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}
