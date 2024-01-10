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

public class DialogFormAlergi extends DialogFragment {
    String alergi, tanggalTerjangkit, bahanAlergen, jenisAlergi, gejalaAlergi, reaksiAlergi, key, pilih;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public DialogFormAlergi(String alergi, String tanggalTerjangkit, String bahanAlergen, String jenisAlergi, String gejalaAlergi, String reaksiAlergi, String key, String pilih) {
        this.alergi = alergi;
        this.tanggalTerjangkit = tanggalTerjangkit;
        this.bahanAlergen = bahanAlergen;
        this.jenisAlergi = jenisAlergi;
        this.gejalaAlergi = gejalaAlergi;
        this.reaksiAlergi = reaksiAlergi;
        this.key = key;
        this.pilih = pilih;
    }

    TextView tvAlergi,tvTanggalTerjangkit, tvBahanAlergen, tvJenisAlergi, tvGejalaAlergi, tvReaksiAlergi;
    Button btn_simpan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_tambah_alergi, container, false);
        tvAlergi = view.findViewById(R.id.edAlergi);
        tvTanggalTerjangkit = view.findViewById(R.id.edTanggalTerjangkit);
        tvBahanAlergen = view.findViewById(R.id.edBahanAlergen);
        tvJenisAlergi = view.findViewById(R.id.edJenisAlergi);
        tvGejalaAlergi = view.findViewById(R.id.edGejalaAlergi);
        tvReaksiAlergi = view.findViewById(R.id.edReaksiAlergi);
        btn_simpan = view.findViewById(R.id.btn_simpan);

        tvAlergi.setText(alergi);
        tvTanggalTerjangkit.setText(tanggalTerjangkit);
        tvBahanAlergen.setText(bahanAlergen);
        tvJenisAlergi.setText(jenisAlergi);
        tvGejalaAlergi.setText(gejalaAlergi);
        tvReaksiAlergi.setText(reaksiAlergi);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alergi = tvAlergi.getText().toString();
                String tanggalTerjangkit = tvTanggalTerjangkit.getText().toString();
                String bahanAlergen = tvBahanAlergen.getText().toString();
                String jenisAlergi = tvJenisAlergi.getText().toString();
                String gejalaAlergi = tvGejalaAlergi.getText().toString();
                String reaksiAlergi = tvReaksiAlergi.getText().toString();

                if (pilih.equals("Ubah")){
                    database.child("Alergi").child(key).setValue(new ModelAlergi(alergi, tanggalTerjangkit, bahanAlergen, jenisAlergi, gejalaAlergi, reaksiAlergi)).addOnSuccessListener(new OnSuccessListener<Void>() {
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
