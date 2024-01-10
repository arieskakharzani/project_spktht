package com.example.project_spktht;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class DiagnosaGejalaActivity extends AppCompatActivity {

    CheckBox cekGangguanBerbicara, cekHidungTersumbat,
            cekBatukParah, cekSakitTenggorokan,
            cekNyeriTenggorokan, cekSakitTelinga,
            cekMulutBau, cekLemas, cekNyeriUluHati,
            cekBenjolanLeher, cekKehilanganSelera,
            cekSulitBernafas, cekMulutPahit,
            cekDemamBatuk, cekMelamun,
            cekSulitMengikutiArahan, cekSulitMendengar,
            cekPilek, cekDahak, cekSuhuBadan;

    Button btnDiagnosa;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa_gejala);

        cekGangguanBerbicara = findViewById(R.id.cx_gangguanSaatBerbicara);
        cekHidungTersumbat = findViewById(R.id.cx_hidungTersumbat);
        cekBatukParah = findViewById(R.id.cx_batukParah);
        cekSakitTenggorokan = findViewById(R.id.cx_sakitTenggorokan);
        cekNyeriTenggorokan = findViewById(R.id.cx_nyeriTenggorokan);
        cekSakitTelinga = findViewById(R.id.cx_sakitTelinga);
        cekNyeriUluHati = findViewById(R.id.cx_nyeriUluHati);
        cekMulutBau = findViewById(R.id.cx_mulutBau);
        cekLemas = findViewById(R.id.cx_lemas);
        cekBenjolanLeher = findViewById(R.id.cx_benjolan);
        cekKehilanganSelera = findViewById(R.id.cx_kehilanganSeleraMakan);
        cekSulitBernafas = findViewById(R.id.cx_kesulitanBernafas);
        cekMulutPahit = findViewById(R.id.cx_mulutPahit);
        cekDemamBatuk = findViewById(R.id.cx_demamBatuk);
        cekMelamun = findViewById(R.id.cx_seringMelamun);
        cekSulitMengikutiArahan = findViewById(R.id.cx_sulitMengikutiArahan);
        cekSulitMendengar = findViewById(R.id.cx_sulitMendengar);
        cekPilek = findViewById(R.id.cx_pilek);
        cekDahak = findViewById(R.id.cx_dahak);
        cekSuhuBadan = findViewById(R.id.cx_suhuBadanPanasDingin);

        btnDiagnosa = findViewById(R.id.btn_diagnosa);
        tvResult = findViewById(R.id.tv_result);

        tvResult.setText(""); // Kosongkan TextView saat pertama kali aplikasi dijalankan

        btnDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NamaPenyakit = "Anda Menderita Penyakit\n";

                // Untuk Penyakit Gangguan Pendengaran
                if (cekGangguanBerbicara.isChecked() && cekSakitTelinga.isChecked()
                        && cekMelamun.isChecked() && cekSulitMengikutiArahan.isChecked() &&
                        cekSulitMendengar.isChecked()) {
                    NamaPenyakit += "Gangguan Pendengaran";
                }
                if (cekGangguanBerbicara.isChecked() && cekHidungTersumbat.isChecked()
                        && cekBatukParah.isChecked() && cekNyeriTenggorokan.isChecked() &&
                        cekMulutBau.isChecked() && cekLemas.isChecked() &&
                        cekDemamBatuk.isChecked() && cekPilek.isChecked()) {
                    NamaPenyakit += "Sinusitis";
                }
                if (cekHidungTersumbat.isChecked() && cekBatukParah.isChecked()
                        && cekSakitTelinga.isChecked() && cekKehilanganSelera.isChecked() &&
                        cekSulitBernafas.isChecked() && cekDemamBatuk.isChecked() &&
                        cekPilek.isChecked() && cekSuhuBadan.isChecked()) {
                    NamaPenyakit += "Hidung Tersumbat";
                }
                if (cekHidungTersumbat.isChecked() && cekSakitTenggorokan.isChecked()
                        && cekNyeriTenggorokan.isChecked() && cekNyeriUluHati.isChecked() &&
                        cekKehilanganSelera.isChecked() && cekMulutPahit.isChecked()
                        && cekDemamBatuk.isChecked() && cekDahak.isChecked()) {
                    NamaPenyakit += "Batuk Kronis";
                }
                if (cekSakitTenggorokan.isChecked() && cekNyeriTenggorokan.isChecked()
                        && cekMulutBau.isChecked() && cekBenjolanLeher.isChecked() &&
                        cekKehilanganSelera.isChecked() && cekSulitBernafas.isChecked()
                        && cekMulutPahit.isChecked() && cekDahak.isChecked()
                        && cekSuhuBadan.isChecked()) {
                    NamaPenyakit += "Sakit pada Tenggorokan";
                }

                // tampilkan penyakit
                tvResult.setText("" +NamaPenyakit);
            }
        });
    }

//    public void onClickChecked(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//        String str = "";
//
//        switch (view.getId()) {
//            case R.id.cx_gangguanSaatBerbicara:
//                str = checked ? "Gejala Gangguan saat Berbicara Diseleksi" :
//                        "Gejala Gangguan saat Berbicara Tidak Diseleksi";
//                break;
//            case R.id.cx_hidungTersumbat:
//                str = checked ? "Gejala Hidung Tersumbat Diseleksi" :
//                        "Gejala Hidung Tersumbat Tidak Diseleksi";
//                break;
//            case R.id.cx_batukParah:
//                str = checked ? "Gejala Batuk Parah Diseleksi" :
//                        "Gejala Batuk Parah Tidak Diseleksi";
//                break;
//            case R.id.cx_sakitTenggorokan:
//                str = checked ? "Gejala Sakit Tenggorokan Diseleksi" :
//                        "Gejala Sakit Tenggorokan Tidak Diseleksi";
//                break;
//            case R.id.cx_nyeriTenggorokan:
//                str = checked ? "Gejala Nyeri Tenggorokan Diseleksi" :
//                        "Gejala Nyeri Tenggorokan Tidak Diseleksi";
//                break;
//            case R.id.cx_sakitTelinga:
//                str = checked ? "Gejala Sakit Telinga Diseleksi" :
//                        "Gejala Diare Sakit Telinga Diseleksi";
//                break;
//            case R.id.cx_mulutBau:
//                str = checked ? "Gejala Bau Mulut Diseleksi" :
//                        "Gejala Bau Mulut Tidak Diseleksi";
//                break;
//            case R.id.cx_lemas:
//                str = checked ? "Gejala Lemas Tidak Bertenaga Diseleksi" :
//                        "Gejala Lemas Tidak Bertenaga Tidak Diseleksi";
//                break;
//            case R.id.cx_nyeriUluHati:
//                str = checked ? "Gejala Nyeri Ulu Hati Diseleksi" :
//                        "Gejala Nyeri Ulu Hati Tidak Diseleksi";
//                break;
//            case R.id.cx_benjolan:
//                str = checked ? "Gejala Benjolan di Leher Diseleksi" :
//                        "Gejala Benjolan di Leher Tidak Diseleksi";
//                break;
//            case R.id.cx_kehilanganSeleraMakan:
//                str = checked ? "Gejala Kehilangan Selera Makan Diseleksi" :
//                        "Gejala Kehilangan Selera Makan Tidak Diseleksi";
//                break;
//            case R.id.cx_kesulitanBernafas:
//                str = checked ? "Gejala Kesulitan Bernafas Diseleksi" :
//                        "Gejala Kesulitan Bernafas Tidak Diseleksi";
//                break;
//            case R.id.cx_mulutPahit:
//                str = checked ? "Gejala Mulut Terasa Pahit Diseleksi" :
//                        "Gejala Mulut Terasa Pahit Tidak Diseleksi";
//                break;
//            case R.id.cx_demamBatuk:
//                str = checked ? "Gejala Demam Disertai Batuk Diseleksi" :
//                        "Gejala Demam Disertai Batuk Tidak Diseleksi";
//                break;
//            case R.id.cx_seringMelamun:
//                str = checked ? "Gejala Sering Melamun Diseleksi" :
//                        "Gejala Sering Melamun Tidak Diseleksi";
//                break;
//            case R.id.cx_sulitMengikutiArahan:
//                str = checked ? "Gejala Sulit Mengikuti Arahan Diseleksi" :
//                        "Gejala Sulit Mengikuti Arahan Tidak Diseleksi";
//                break;
//            case R.id.cx_sulitMendengar:
//                str = checked ? "Gejala Sulit Mendengar Diseleksi" :
//                        "Gejala Sulit Mendengar Tidak Diseleksi";
//                break;
//            case R.id.cx_pilek:
//                str = checked ? "Gejala Pilek Diseleksi" :
//                        "Gejala Pilek Tidak Diseleksi";
//                break;
//            case R.id.cx_dahak:
//                str = checked ? "Gejala Dahak di Tenggorokan Diseleksi" :
//                        "Gejala Dahak di Tenggorokan Tidak Diseleksi";
//                break;
//            case R.id.cx_suhuBadanPanasDingin:
//                str = checked ? "Gejala Suhu Badan Panas Dingin Diseleksi" :
//                        "Gejala Suhu Badan Panas Dingin Tidak Diseleksi";
//                break;
//
//
//        }
//        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
//    }

}