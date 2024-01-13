package com.example.project_spktht;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class DiagnosaGejalaActivity extends AppCompatActivity {

    Button btnDiagnosa;
    TextView tvResult;
    CheckBox chkGejala1, chkGejala2, chkGejala3, chkGejala4, chkGejala5, chkGejala6,
            chkGejala7, chkGejala8, chkGejala9, chkGejala10, chkGejala11, chkGejala12,
            chkGejala13, chkGejala14, chkGejala15, chkGejala16, chkGejala17, chkGejala18,
            chkGejala19, chkGejala20, chkGejala21, chkGejala22, chkGejala23, chkGejala24;

    AutoCompleteTextView txtNilaiGejala1, txtNilaiGejala2, txtNilaiGejala3, txtNilaiGejala4, txtNilaiGejala5, txtNilaiGejala6,
            txtNilaiGejala7, txtNilaiGejala8, txtNilaiGejala9, txtNilaiGejala10, txtNilaiGejala11, txtNilaiGejala12,
            txtNilaiGejala13, txtNilaiGejala14, txtNilaiGejala15, txtNilaiGejala16, txtNilaiGejala17, txtNilaiGejala18,
            txtNilaiGejala19, txtNilaiGejala20, txtNilaiGejala21, txtNilaiGejala22, txtNilaiGejala23, txtNilaiGejala24;

    String[] nilaiKeyakinanGejala1 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala2 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala3 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala4 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala5 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala6 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala7 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala8 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala9 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala10 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala11 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala12 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala13 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala14 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala15 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala16 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala17 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala18 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala19 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala20 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala21 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala22 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala23 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};
    String[] nilaiKeyakinanGejala24 = {"", "0 (Tidak)", "0.2 (Tidak Tahu)", "0.4 (Sedikit Yakin)", "0.6 (Cukup Yakin)", "0.8 (Yakin)", "1 (Sangat Yakin)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa_gejala);

        btnDiagnosa   = (Button)findViewById(R.id.btnDiagnosa);
        tvResult    = (TextView)findViewById(R.id.tvResult);
        tvResult.setText(""); // Kosongkan TextView saat pertama kali aplikasi dijalankan


        chkGejala1  = (CheckBox)findViewById(R.id.checkBox);
        chkGejala2  = (CheckBox)findViewById(R.id.checkBox2);
        chkGejala3  = (CheckBox)findViewById(R.id.checkBox3);
        chkGejala4  = (CheckBox)findViewById(R.id.checkBox4);
        chkGejala5  = (CheckBox)findViewById(R.id.checkBox5);
        chkGejala6  = (CheckBox)findViewById(R.id.checkBox6);
        chkGejala7 = (CheckBox)findViewById(R.id.checkBox7);
        chkGejala8 = (CheckBox)findViewById(R.id.checkBox8);
        chkGejala9 = (CheckBox)findViewById(R.id.checkBox9);
        chkGejala10 = (CheckBox)findViewById(R.id.checkBox10);
        chkGejala11 = (CheckBox)findViewById(R.id.checkBox11);
        chkGejala12 = (CheckBox)findViewById(R.id.checkBox12);
        chkGejala13 = (CheckBox)findViewById(R.id.checkBox13);
        chkGejala14 = (CheckBox)findViewById(R.id.checkBox14);
        chkGejala15 = (CheckBox)findViewById(R.id.checkBox15);
        chkGejala16 = (CheckBox)findViewById(R.id.checkBox16);
        chkGejala17 = (CheckBox)findViewById(R.id.checkBox17);
        chkGejala18 = (CheckBox)findViewById(R.id.checkBox18);
        chkGejala19 = (CheckBox)findViewById(R.id.checkBox19);
        chkGejala20 = (CheckBox)findViewById(R.id.checkBox20);
        chkGejala21 = (CheckBox)findViewById(R.id.checkBox21);
        chkGejala22 = (CheckBox)findViewById(R.id.checkBox22);
        chkGejala23 = (CheckBox)findViewById(R.id.checkBox23);
        chkGejala24 = (CheckBox)findViewById(R.id.checkBox24);


        txtNilaiGejala1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        txtNilaiGejala2 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        txtNilaiGejala3 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView3);
        txtNilaiGejala4 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView4);
        txtNilaiGejala5 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView5);
        txtNilaiGejala6 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView6);
        txtNilaiGejala7 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView7);
        txtNilaiGejala8 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView8);
        txtNilaiGejala9 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView9);
        txtNilaiGejala10 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView10);
        txtNilaiGejala11 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView11);
        txtNilaiGejala12 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView12);
        txtNilaiGejala13 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView13);
        txtNilaiGejala14 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView14);
        txtNilaiGejala15 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView15);
        txtNilaiGejala16 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView16);
        txtNilaiGejala17 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView17);
        txtNilaiGejala18 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView18);
        txtNilaiGejala19 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView19);
        txtNilaiGejala20 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView20);
        txtNilaiGejala21 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView21);
        txtNilaiGejala22 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView22);
        txtNilaiGejala23 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView23);
        txtNilaiGejala24 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView24);



        final ArrayAdapter<String> adapterGejala1 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala1);
        txtNilaiGejala1.setThreshold(1);
        txtNilaiGejala1.setAdapter(adapterGejala1);

        final ArrayAdapter<String> adapterGejala2 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala2);
        txtNilaiGejala2.setThreshold(1);
        txtNilaiGejala2.setAdapter(adapterGejala2);

        final ArrayAdapter<String> adapterGejala3 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala3);
        txtNilaiGejala3.setThreshold(1);
        txtNilaiGejala3.setAdapter(adapterGejala3);

        final ArrayAdapter<String> adapterGejala4 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala4);
        txtNilaiGejala4.setThreshold(1);
        txtNilaiGejala4.setAdapter(adapterGejala4);

        final ArrayAdapter<String> adapterGejala5 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala5);
        txtNilaiGejala5.setThreshold(1);
        txtNilaiGejala5.setAdapter(adapterGejala5);

        final ArrayAdapter<String> adapterGejala6 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, nilaiKeyakinanGejala6);
        txtNilaiGejala6.setThreshold(1);
        txtNilaiGejala6.setAdapter(adapterGejala6);

        final ArrayAdapter<String> adapterGejala7 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala7);
        txtNilaiGejala7.setThreshold(1);
        txtNilaiGejala7.setAdapter(adapterGejala7);

        final ArrayAdapter<String> adapterGejala8 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala8);
        txtNilaiGejala8.setThreshold(1);
        txtNilaiGejala8.setAdapter(adapterGejala8);

        final ArrayAdapter<String> adapterGejala9 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala9);
        txtNilaiGejala9.setThreshold(1);
        txtNilaiGejala9.setAdapter(adapterGejala9);

        final ArrayAdapter<String> adapterGejala10 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala10);
        txtNilaiGejala10.setThreshold(1);
        txtNilaiGejala10.setAdapter(adapterGejala10);

        final ArrayAdapter<String> adapterGejala11 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala11);
        txtNilaiGejala11.setThreshold(1);
        txtNilaiGejala11.setAdapter(adapterGejala11);

        final ArrayAdapter<String> adapterGejala12 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala12);
        txtNilaiGejala12.setThreshold(1);
        txtNilaiGejala12.setAdapter(adapterGejala12);

        final ArrayAdapter<String> adapterGejala13 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala13);
        txtNilaiGejala13.setThreshold(1);
        txtNilaiGejala13.setAdapter(adapterGejala13);

        final ArrayAdapter<String> adapterGejala14 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala14);
        txtNilaiGejala14.setThreshold(1);
        txtNilaiGejala14.setAdapter(adapterGejala14);

        final ArrayAdapter<String> adapterGejala15 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala15);
        txtNilaiGejala15.setThreshold(1);
        txtNilaiGejala15.setAdapter(adapterGejala15);

        final ArrayAdapter<String> adapterGejala16 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala16);
        txtNilaiGejala16.setThreshold(1);
        txtNilaiGejala16.setAdapter(adapterGejala16);

        final ArrayAdapter<String> adapterGejala17 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala17);
        txtNilaiGejala17.setThreshold(1);
        txtNilaiGejala17.setAdapter(adapterGejala17);

        final ArrayAdapter<String> adapterGejala18 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala18);
        txtNilaiGejala18.setThreshold(1);
        txtNilaiGejala18.setAdapter(adapterGejala18);

        final ArrayAdapter<String> adapterGejala19 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala19);
        txtNilaiGejala19.setThreshold(1);
        txtNilaiGejala19.setAdapter(adapterGejala19);

        final ArrayAdapter<String> adapterGejala20 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala20);
        txtNilaiGejala20.setThreshold(1);
        txtNilaiGejala20.setAdapter(adapterGejala20);

        final ArrayAdapter<String> adapterGejala21 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala21);
        txtNilaiGejala21.setThreshold(1);
        txtNilaiGejala21.setAdapter(adapterGejala21);

        final ArrayAdapter<String> adapterGejala22 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala22);
        txtNilaiGejala22.setThreshold(1);
        txtNilaiGejala22.setAdapter(adapterGejala22);

        final ArrayAdapter<String> adapterGejala23 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala23);
        txtNilaiGejala23.setThreshold(1);
        txtNilaiGejala23.setAdapter(adapterGejala23);

        final ArrayAdapter<String> adapterGejala24 = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, nilaiKeyakinanGejala24);
        txtNilaiGejala24.setThreshold(1);
        txtNilaiGejala24.setAdapter(adapterGejala24);


        txtNilaiGejala1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 1").
                        setAdapter(adapterGejala1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala1.setText(nilaiKeyakinanGejala1[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 2").
                        setAdapter(adapterGejala2, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala2.setText(nilaiKeyakinanGejala2[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 3").
                        setAdapter(adapterGejala3, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala3.setText(nilaiKeyakinanGejala3[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 4").
                        setAdapter(adapterGejala4, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala4.setText(nilaiKeyakinanGejala4[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 5").
                        setAdapter(adapterGejala5, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala5.setText(nilaiKeyakinanGejala5[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 6").
                        setAdapter(adapterGejala6, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala6.setText(nilaiKeyakinanGejala6[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 7").
                        setAdapter(adapterGejala7, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala7.setText(nilaiKeyakinanGejala7[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 8").
                        setAdapter(adapterGejala8, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala8.setText(nilaiKeyakinanGejala8[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 9").
                        setAdapter(adapterGejala9, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala9.setText(nilaiKeyakinanGejala9[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 10").
                        setAdapter(adapterGejala10, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala10.setText(nilaiKeyakinanGejala10[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 11").
                        setAdapter(adapterGejala11, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala11.setText(nilaiKeyakinanGejala11[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 12").
                        setAdapter(adapterGejala12, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala12.setText(nilaiKeyakinanGejala12[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 13").
                        setAdapter(adapterGejala13, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala13.setText(nilaiKeyakinanGejala13[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 14").
                        setAdapter(adapterGejala14, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala14.setText(nilaiKeyakinanGejala14[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 15").
                        setAdapter(adapterGejala15, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala15.setText(nilaiKeyakinanGejala15[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 16").
                        setAdapter(adapterGejala16, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala16.setText(nilaiKeyakinanGejala16[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 17").
                        setAdapter(adapterGejala17, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala17.setText(nilaiKeyakinanGejala17[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 18").
                        setAdapter(adapterGejala18, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala18.setText(nilaiKeyakinanGejala18[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 19").
                        setAdapter(adapterGejala19, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala19.setText(nilaiKeyakinanGejala19[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 20").
                        setAdapter(adapterGejala20, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala20.setText(nilaiKeyakinanGejala20[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 21").
                        setAdapter(adapterGejala21, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala21.setText(nilaiKeyakinanGejala21[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 22").
                        setAdapter(adapterGejala22, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala22.setText(nilaiKeyakinanGejala22[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 23").
                        setAdapter(adapterGejala23, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala23.setText(nilaiKeyakinanGejala23[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        txtNilaiGejala24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DiagnosaGejalaActivity.this).setTitle("Pilihlah Nilai Gejala 24").
                        setAdapter(adapterGejala24, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txtNilaiGejala24.setText(nilaiKeyakinanGejala24[which].toString());
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        });

        btnDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NamaPenyakit = "Anda Menderita Penyakit :";

                // AND && dan OR ||
                if (chkGejala1.isChecked() && chkGejala4.isChecked() && chkGejala11.isChecked()
                        && chkGejala13.isChecked() && chkGejala14.isChecked() && chkGejala16.isChecked()
                        && chkGejala20.isChecked() && chkGejala23.isChecked()){

                    //  Nilai dari PAKAR / AHLINYA
                    double nilaiGejala1 = 0.8;
                    double nilaiGejala4 = 0.8;
                    double nilaiGejala11 = 0.6;
                    double nilaiGejala13 = 1.0;
                    double nilaiGejala14 = 0.4;
                    double nilaiGejala16 = 0.8;
                    double nilaiGejala20 = 1.0;
                    double nilaiGejala23 = 0.6;

                    // Nilai Inputan dari PASIEN / USER
                    double doubleGejala1 = Double.parseDouble(txtNilaiGejala1.getText().toString());
                    double doubleGejala4 = Double.parseDouble(txtNilaiGejala4.getText().toString());
                    double doubleGejala11 = Double.parseDouble(txtNilaiGejala11.getText().toString());
                    double doubleGejala13 = Double.parseDouble(txtNilaiGejala13.getText().toString());
                    double doubleGejala14 = Double.parseDouble(txtNilaiGejala14.getText().toString());
                    double doubleGejala16 = Double.parseDouble(txtNilaiGejala16.getText().toString());
                    double doubleGejala20 = Double.parseDouble(txtNilaiGejala20.getText().toString());
                    double doubleGejala23 = Double.parseDouble(txtNilaiGejala23.getText().toString());

                    double hasilHitunganGejala1 = nilaiGejala1 * doubleGejala1;
                    double hasilHitunganGejala4 = nilaiGejala4 * doubleGejala4;
                    double hasilHitunganGejala11 = nilaiGejala11 * doubleGejala11;
                    double hasilHitunganGejala13 = nilaiGejala13 * doubleGejala13;
                    double hasilHitunganGejala14 = nilaiGejala14 * doubleGejala14;
                    double hasilHitunganGejala16 = nilaiGejala16 * doubleGejala16;
                    double hasilHitunganGejala20 = nilaiGejala20 * doubleGejala20;
                    double hasilHitunganGejala23 = nilaiGejala4 * doubleGejala4;

                    double Combine_CF1_CF4  = hasilHitunganGejala1 + hasilHitunganGejala4 * (1 - hasilHitunganGejala1);
                    double Combine_CFold_CF11  = Combine_CF1_CF4 + hasilHitunganGejala11 * (1 - Combine_CF1_CF4);
                    double Combine_CFold_CF13  = Combine_CFold_CF11 + hasilHitunganGejala13 * (1 - Combine_CFold_CF11);
                    double Combine_CFold_CF14  = Combine_CFold_CF13 + hasilHitunganGejala14 * (1 - Combine_CFold_CF13);
                    double Combine_CFold_CF16  = Combine_CFold_CF14 + hasilHitunganGejala16 * (1 - Combine_CFold_CF14);
                    double Combine_CFold_CF20  = Combine_CFold_CF16 + hasilHitunganGejala20 * (1 - Combine_CFold_CF16);
                    double Combine_CFold_CF23  = Combine_CFold_CF20 + hasilHitunganGejala23 * (1 - Combine_CFold_CF20);

                    String hasilHitungGejalaPenyakitA = String.valueOf((Combine_CFold_CF23 * 100));

                    NamaPenyakit += "\nOtitis Media Akut (OMA)"+"\n"+hasilHitungGejalaPenyakitA+" %";

                }

                if (chkGejala9.isChecked() && chkGejala11.isChecked() && chkGejala18.isChecked() && chkGejala19.isChecked()){

                    //  Nilai dari PAKAR / AHLINYA
                    double nilaiGejala9 = 0.4;
                    double nilaiGejala11 = 0.8;
                    double nilaiGejala18 = 1.0;
                    double nilaiGejala19 = 0.2;

                    // Nilai Inputan dari PASIEN / USER
                    double doubleGejala9 = Double.parseDouble(txtNilaiGejala9.getText().toString());
                    double doubleGejala11 = Double.parseDouble(txtNilaiGejala11.getText().toString());
                    double doubleGejala18 = Double.parseDouble(txtNilaiGejala18.getText().toString());
                    double doubleGejala19 = Double.parseDouble(txtNilaiGejala19.getText().toString());

                    double hasilHitunganGejala9 = nilaiGejala9 * doubleGejala9;
                    double hasilHitunganGejala11 = nilaiGejala11 * doubleGejala11;
                    double hasilHitunganGejala18 = nilaiGejala18 * doubleGejala18;
                    double hasilHitunganGejala19 = nilaiGejala19 * doubleGejala19;

                    double Combine_CF9_CF11  = hasilHitunganGejala9 + hasilHitunganGejala11 * (1 - hasilHitunganGejala9);
                    double Combine_CFold_CF18  = Combine_CF9_CF11 + hasilHitunganGejala18 * (1 - Combine_CF9_CF11);
                    double Combine_CFold_CF19  = Combine_CFold_CF18 + hasilHitunganGejala19 * (1 - Combine_CFold_CF18);


                    String hasilHitungGejalaPenyakitB = String.valueOf((Combine_CFold_CF19 * 100));

                    NamaPenyakit += "\nSerumen (Kotoran Telinga)"+"\n"+hasilHitungGejalaPenyakitB+" %";

                }

                if (chkGejala9.isChecked() && chkGejala11.isChecked() && chkGejala16.isChecked() && chkGejala18.isChecked()
                        && chkGejala19.isChecked() && chkGejala20.isChecked() && chkGejala23.isChecked()){

                    //  Nilai dari PAKAR / AHLINYA
                    double nilaiGejala9 = 0.8;
                    double nilaiGejala11 = 0.8;
                    double nilaiGejala16 = 0.4;
                    double nilaiGejala18 = 0.6;
                    double nilaiGejala19 = 0.8;
                    double nilaiGejala20 = 1.0;
                    double nilaiGejala23 = 0.6;

                    // Nilai Inputan dari PASIEN / USER
                    double doubleGejala9 = Double.parseDouble(txtNilaiGejala9.getText().toString());
                    double doubleGejala11 = Double.parseDouble(txtNilaiGejala11.getText().toString());
                    double doubleGejala16 = Double.parseDouble(txtNilaiGejala16.getText().toString());
                    double doubleGejala18 = Double.parseDouble(txtNilaiGejala18.getText().toString());
                    double doubleGejala19 = Double.parseDouble(txtNilaiGejala19.getText().toString());
                    double doubleGejala20 = Double.parseDouble(txtNilaiGejala20.getText().toString());
                    double doubleGejala23 = Double.parseDouble(txtNilaiGejala23.getText().toString());

                    double hasilHitunganGejala9 = nilaiGejala9 * doubleGejala9;
                    double hasilHitunganGejala11 = nilaiGejala11 * doubleGejala11;
                    double hasilHitunganGejala16 = nilaiGejala16 * doubleGejala16;
                    double hasilHitunganGejala18 = nilaiGejala18 * doubleGejala18;
                    double hasilHitunganGejala19 = nilaiGejala19 * doubleGejala19;
                    double hasilHitunganGejala20 = nilaiGejala20 * doubleGejala20;
                    double hasilHitunganGejala23 = nilaiGejala23 * doubleGejala23;


                    double Combine_CF9_CF11  = hasilHitunganGejala9 + hasilHitunganGejala11 * (1 - hasilHitunganGejala9);
                    double Combine_CFold_CF16  = Combine_CF9_CF11 + hasilHitunganGejala16 * (1 - Combine_CF9_CF11);
                    double Combine_CFold_CF18  = Combine_CFold_CF16 + hasilHitunganGejala18 * (1 - Combine_CFold_CF16);
                    double Combine_CFold_CF19  = Combine_CFold_CF18 + hasilHitunganGejala19 * (1 - Combine_CFold_CF18);
                    double Combine_CFold_CF20  = Combine_CFold_CF19 + hasilHitunganGejala20 * (1 - Combine_CFold_CF19);
                    double Combine_CFold_CF23  = Combine_CFold_CF20 + hasilHitunganGejala23 * (1 - Combine_CFold_CF20);


                    String hasilHitungGejalaPenyakitC = String.valueOf((Combine_CFold_CF23 * 100));

                    NamaPenyakit += "\nOtitis Eksterna (OE)"+"\n"+hasilHitungGejalaPenyakitC+" %";

                }

                if (chkGejala1.isChecked() && chkGejala3.isChecked() && chkGejala4.isChecked()
                        && chkGejala5.isChecked() && chkGejala6.isChecked() && chkGejala10.isChecked()
                        && chkGejala12.isChecked() && chkGejala14.isChecked()){

                    //  Nilai dari PAKAR / AHLINYA
                    double nilaiGejala1 = 0.4;
                    double nilaiGejala3 = 0.8;
                    double nilaiGejala4 = 0.4;
                    double nilaiGejala5 = 0.4;
                    double nilaiGejala6 = 0.6;
                    double nilaiGejala10 = 0.6;
                    double nilaiGejala12 = 0.6;
                    double nilaiGejala14 = 1.0;

                    // Nilai Inputan dari PASIEN / USER
                    double doubleGejala1 = Double.parseDouble(txtNilaiGejala1.getText().toString());
                    double doubleGejala3 = Double.parseDouble(txtNilaiGejala3.getText().toString());
                    double doubleGejala4 = Double.parseDouble(txtNilaiGejala4.getText().toString());
                    double doubleGejala5 = Double.parseDouble(txtNilaiGejala5.getText().toString());
                    double doubleGejala6 = Double.parseDouble(txtNilaiGejala6.getText().toString());
                    double doubleGejala10 = Double.parseDouble(txtNilaiGejala10.getText().toString());
                    double doubleGejala12 = Double.parseDouble(txtNilaiGejala12.getText().toString());
                    double doubleGejala14 = Double.parseDouble(txtNilaiGejala14.getText().toString());

                    double hasilHitunganGejala1 = nilaiGejala1 * doubleGejala1;
                    double hasilHitunganGejala3 = nilaiGejala3 * doubleGejala3;
                    double hasilHitunganGejala4 = nilaiGejala4 * doubleGejala4;
                    double hasilHitunganGejala5 = nilaiGejala5 * doubleGejala5;
                    double hasilHitunganGejala6 = nilaiGejala6 * doubleGejala6;
                    double hasilHitunganGejala10 = nilaiGejala10 * doubleGejala10;
                    double hasilHitunganGejala12 = nilaiGejala12 * doubleGejala12;
                    double hasilHitunganGejala14 = nilaiGejala14 * doubleGejala14;

                    double Combine_CF1_CF3  = hasilHitunganGejala1 + hasilHitunganGejala3 * (1 - hasilHitunganGejala1);
                    double Combine_CFold_CF4  = Combine_CF1_CF3 + hasilHitunganGejala4 * (1 - Combine_CF1_CF3);
                    double Combine_CFold_CF5  = Combine_CFold_CF4 + hasilHitunganGejala5 * (1 - Combine_CFold_CF4);
                    double Combine_CFold_CF6  = Combine_CFold_CF5 + hasilHitunganGejala6 * (1 - Combine_CFold_CF5);
                    double Combine_CFold_CF10  = Combine_CFold_CF6 + hasilHitunganGejala10 * (1 - Combine_CFold_CF6);
                    double Combine_CFold_CF12  = Combine_CFold_CF10 + hasilHitunganGejala12 * (1 - Combine_CFold_CF10);
                    double Combine_CFold_CF14  = Combine_CFold_CF12 + hasilHitunganGejala14 * (1 - Combine_CFold_CF12);

                    String hasilHitungGejalaPenyakitA = String.valueOf((Combine_CFold_CF14 * 100));

                    NamaPenyakit += "\nSinusitis"+"\n"+hasilHitungGejalaPenyakitA+" %";

                }

                if (chkGejala10.isChecked() && chkGejala7.isChecked() && chkGejala12.isChecked() && chkGejala13.isChecked()
                        && chkGejala5.isChecked() && chkGejala2.isChecked() && chkGejala14.isChecked()){

                    //  Nilai dari PAKAR / AHLINYA
                    double nilaiGejala10 = 0.6;
                    double nilaiGejala7 = 0.8;
                    double nilaiGejala12 = 1.0;
                    double nilaiGejala13 = 1.0;
                    double nilaiGejala5 = 0.8;
                    double nilaiGejala2 = 0.8;
                    double nilaiGejala14 = 0.4;

                    // Nilai Inputan dari PASIEN / USER
                    double doubleGejala10 = Double.parseDouble(txtNilaiGejala10.getText().toString());
                    double doubleGejala7 = Double.parseDouble(txtNilaiGejala7.getText().toString());
                    double doubleGejala12 = Double.parseDouble(txtNilaiGejala12.getText().toString());
                    double doubleGejala13 = Double.parseDouble(txtNilaiGejala13.getText().toString());
                    double doubleGejala5 = Double.parseDouble(txtNilaiGejala5.getText().toString());
                    double doubleGejala2 = Double.parseDouble(txtNilaiGejala2.getText().toString());
                    double doubleGejala14 = Double.parseDouble(txtNilaiGejala14.getText().toString());

                    double hasilHitunganGejala10 = nilaiGejala10 * doubleGejala10;
                    double hasilHitunganGejala7 = nilaiGejala7 * doubleGejala7;
                    double hasilHitunganGejala12 = nilaiGejala12 * doubleGejala12;
                    double hasilHitunganGejala13 = nilaiGejala13 * doubleGejala13;
                    double hasilHitunganGejala5 = nilaiGejala5 * doubleGejala5;
                    double hasilHitunganGejala2 = nilaiGejala2 * doubleGejala2;
                    double hasilHitunganGejala14 = nilaiGejala14 * doubleGejala14;


                    double Combine_CF10_CF7  = hasilHitunganGejala10 + hasilHitunganGejala7 * (1 - hasilHitunganGejala10);
                    double Combine_CFold_CF12  = Combine_CF10_CF7 + hasilHitunganGejala12 * (1 - Combine_CF10_CF7);
                    double Combine_CFold_CF13  = Combine_CFold_CF12 + hasilHitunganGejala13 * (1 - Combine_CFold_CF12);
                    double Combine_CFold_CF5  = Combine_CFold_CF13 + hasilHitunganGejala5 * (1 - Combine_CFold_CF13);
                    double Combine_CFold_CF2  = Combine_CFold_CF5 + hasilHitunganGejala2 * (1 - Combine_CFold_CF5);
                    double Combine_CFold_CF14  = Combine_CFold_CF2 + hasilHitunganGejala14 * (1 - Combine_CFold_CF2);


                    String hasilHitungGejalaPenyakitC = String.valueOf((Combine_CFold_CF14 * 100));

                    NamaPenyakit += "\nRhinitis Kronis"+"\n"+hasilHitungGejalaPenyakitC+" %";

                }
                // Output Semua hasil
                tvResult.setText(""+NamaPenyakit);
            }
        });



    }
}