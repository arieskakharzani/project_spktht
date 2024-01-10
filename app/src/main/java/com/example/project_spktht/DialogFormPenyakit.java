package com.example.project_spktht;

import android.app.Dialog;
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

public class DialogFormPenyakit extends DialogFragment {
    String penyakit, tanggalTerjangkit, gangguanTelinga, gangguanHidung, gangguanTenggorokan, obat, key, pilih;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public DialogFormPenyakit(String penyakit, String tanggalTerjangkit, String gangguanTelinga, String gangguanHidung, String gangguanTenggorokan, String obat, String key, String pilih) {
        this.penyakit = penyakit;
        this.tanggalTerjangkit = tanggalTerjangkit;
        this.gangguanTelinga = gangguanTelinga;
        this.gangguanHidung = gangguanHidung;
        this.gangguanTenggorokan = gangguanTenggorokan;
        this.obat = obat;
        this.key = key;
        this.pilih = pilih;
    }

    TextView tvPenyakit,tvTanggalTerjangkit, tvGangguanTelinga, tvGangguanHidung, tvGangguanTenggorokan, tvObat;
    Button btn_simpan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_tambah_penyakit, container, false);
        tvPenyakit = view.findViewById(R.id.edPenyakit);
        tvTanggalTerjangkit = view.findViewById(R.id.edTanggalTerjangkit);
        tvGangguanTelinga = view.findViewById(R.id.edGangguanTelinga);
        tvGangguanHidung = view.findViewById(R.id.edGangguanHidung);
        tvGangguanTenggorokan = view.findViewById(R.id.edGangguanTenggorokan);
        tvObat = view.findViewById(R.id.edObat);
        btn_simpan = view.findViewById(R.id.btn_simpan);

        tvPenyakit.setText(penyakit);
        tvTanggalTerjangkit.setText(tanggalTerjangkit);
        tvGangguanTelinga.setText(gangguanTelinga);
        tvGangguanHidung.setText(gangguanHidung);
        tvGangguanTenggorokan.setText(gangguanTenggorokan);
        tvObat.setText(obat);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String penyakit = tvPenyakit.getText().toString();
                String tanggalTerjangkit = tvTanggalTerjangkit.getText().toString();
                String gangguanTelinga = tvGangguanTelinga.getText().toString();
                String gangguanHidung = tvGangguanHidung.getText().toString();
                String gangguanTenggorokan = tvGangguanTenggorokan.getText().toString();
                String obat = tvObat.getText().toString();

                if (pilih.equals("Ubah")){
                    database.child("Penyakit").child(key).setValue(new ModelPenyakit(penyakit, tanggalTerjangkit, gangguanTelinga, gangguanHidung, gangguanTenggorokan, obat)).addOnSuccessListener(new OnSuccessListener<Void>() {
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
