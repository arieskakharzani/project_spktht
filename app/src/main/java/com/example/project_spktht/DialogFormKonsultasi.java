package com.example.project_spktht;

import android.app.Dialog;
import android.graphics.fonts.FontFamily;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogFormKonsultasi extends DialogFragment {
    String konsulke, tanggal, dokter, klinik, keluhan, diagnosa, key, pilih;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public DialogFormKonsultasi(String konsulke, String tanggal, String dokter, String klinik, String keluhan, String diagnosa, String key, String pilih) {
        this.konsulke = konsulke;
        this.tanggal = tanggal;
        this.dokter = dokter;
        this.klinik = klinik;
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
        this.key = key;
        this.pilih = pilih;
    }
    TextView tvKonsulKe,tvTanggal, tvDokter, tvKlinik, tvKeluhan, tvDiagnosa;
    Button btn_simpan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_tambah_konsul, container, false);
        tvKonsulKe = view.findViewById(R.id.edKonsulKe);
        tvTanggal = view.findViewById(R.id.edTanggal);
        tvDokter = view.findViewById(R.id.edDokter);
        tvKlinik = view.findViewById(R.id.edKlinik);
        tvKeluhan = view.findViewById(R.id.edKeluhan);
        tvDiagnosa = view.findViewById(R.id.edDiagnosa);
        btn_simpan = view.findViewById(R.id.btn_simpan);

        tvKonsulKe.setText(konsulke);
        tvTanggal.setText(tanggal);
        tvDokter.setText(dokter);
        tvKlinik.setText(klinik);
        tvKeluhan.setText(keluhan);
        tvDiagnosa.setText(diagnosa);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String konsulke = tvKonsulKe.getText().toString();
                String tanggal = tvTanggal.getText().toString();
                String dokter = tvDokter.getText().toString();
                String klinik = tvKlinik.getText().toString();
                String keluhan = tvKeluhan.getText().toString();
                String diagnosa = tvDiagnosa.getText().toString();

                if (pilih.equals("Ubah")){
                    database.child("Konsultasi").child(key).setValue(new ModelKonsultasi(konsulke, tanggal, dokter, klinik, keluhan, diagnosa)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "Data berhasil di Update!", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext(), "Data gagal di Update!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null){
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
