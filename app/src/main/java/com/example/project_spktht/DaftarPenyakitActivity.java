package com.example.project_spktht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DaftarPenyakitActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<ModelDaftarPenyakit> daftarPenyakitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_penyakit);

        recyclerView = findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        AdapterDaftarPenyakit daftarPenyakitAdapter = new AdapterDaftarPenyakit(daftarPenyakitList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(daftarPenyakitAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initData() {
        daftarPenyakitList = new ArrayList<>();
        daftarPenyakitList.add(new ModelDaftarPenyakit("Gangguan Pendengaran", "Gangguan pendengaran adalah kondisi di mana seseorang mengalami kesulitan mendengar atau tidak dapat mendengar sama sekali. Gangguan pendengaran dapat terjadi pada satu atau kedua telinga.\n" +
                "\n" +
                "Penyebab gangguan pendengaran beragam, mulai dari infeksi virus atau bakteri, penumpukan lendir, atau kerusakan pada telinga bagian dalam. Infeksi telinga tengah adalah penyebab gangguan pendengaran yang paling umum pada anak-anak. Infeksi ini dapat disebabkan oleh virus atau bakteri.\n" +
                "\n" +
                "Gejala gangguan pendengaran meliputi:\n" +
                "\n" +
                "- Sulit mendengar\n" +
                "- Tidak dapat mendengar suara yang lembut\n" +
                "- Merasa seperti ada suara berdengung di telinga\n" +
                "- Kesulitan mengikuti percakapan\n" +
                "Penanganan gangguan pendengaran tergantung pada penyebab dan tingkat keparahannya. Jika gangguan pendengaran disebabkan oleh infeksi, maka pengobatan dengan antibiotik atau obat antivirus dapat membantu. Namun, jika gangguan pendengaran disebabkan oleh kerusakan pada telinga bagian dalam, maka mungkin diperlukan operasi atau alat bantu dengar."));
        daftarPenyakitList.add(new ModelDaftarPenyakit("Sinusitis", "Sinusitis adalah peradangan pada sinus, rongga yang terletak di sekitar hidung. Sinus berfungsi untuk menghangatkan dan melembapkan udara yang dihirup.\n" +
                "\n" +
                "Penyebab sinusitis beragam, mulai dari infeksi, alergi, hingga kondisi medis tertentu. Infeksi sinus adalah penyebab sinusitis yang paling umum.\n" +
                "\n" +
                "Gejala sinusitis meliputi:\n" +
                "\n" +
                "- Hidung tersumbat\n" +
                "- Hidung berair atau meler\n" +
                "- Sakit kepala\n" +
                "- Demam\n" +
                "- Rasa sakit di pipi, dahi, atau dahi\n" +
                "Penanganan sinusitis tergantung pada penyebabnya. Jika sinusitis disebabkan oleh infeksi, maka pengobatan dengan antibiotik atau obat antivirus dapat membantu. Namun, jika sinusitis disebabkan oleh alergi, maka pengobatan dengan antihistamin atau kortikosteroid dapat membantu. Dalam kasus yang parah, operasi mungkin diperlukan untuk membersihkan sinus. "));
        daftarPenyakitList.add(new ModelDaftarPenyakit("Hidung Tersumbat", "Hidung tersumbat adalah kondisi di mana rongga hidung tersumbat oleh lendir, cairan, atau jaringan. Hidung tersumbat dapat menyebabkan kesulitan bernapas, kesulitan mencium aroma, dan sakit kepala.\n" +
                "\n" +
                "Penyebab hidung tersumbat beragam, mulai dari infeksi, alergi, hingga kondisi medis tertentu. Infeksi sinus, pilek, dan alergi adalah penyebab hidung tersumbat yang paling umum.\n" +
                "\n" +
                "Gejala hidung tersumbat meliputi:\n" +
                "\n" +
                "- Kesulitan bernapas melalui hidung\n" +
                "- Hidung berair atau meler\n" +
                "- Sakit kepala\n" +
                "- Rasa penuh di hidung\n" +
                "Penanganan hidung tersumbat tergantung pada penyebabnya. Jika hidung tersumbat disebabkan oleh infeksi, maka pengobatan dengan antibiotik atau obat antivirus dapat membantu. Namun, jika hidung tersumbat disebabkan oleh alergi, maka pengobatan dengan antihistamin atau kortikosteroid dapat membantu. "));
        daftarPenyakitList.add(new ModelDaftarPenyakit("Batuk Kronis", "Batuk kronis adalah batuk yang berlangsung lebih dari delapan minggu. Batuk kronis dapat disebabkan oleh berbagai kondisi, termasuk infeksi, alergi, refluks asam, atau kondisi medis tertentu.\n" +
                "\n" +
                "Gejala batuk kronis meliputi:\n" +
                "\n" +
                "- Batuk yang tidak berhenti\n" +
                "- Batuk yang mengganggu tidur\n" +
                "- Batuk yang disertai dengan lendir, darah, atau dahak\n" +
                "Penanganan batuk kronis tergantung pada penyebabnya. Jika batuk kronis disebabkan oleh infeksi, maka pengobatan dengan antibiotik atau obat antivirus dapat membantu. Namun, jika batuk kronis disebabkan oleh alergi, maka pengobatan dengan antihistamin atau kortikosteroid dapat membantu. Dalam kasus yang parah, operasi mungkin diperlukan untuk mengobati kondisi medis tertentu yang mendasarinya. "));
        daftarPenyakitList.add(new ModelDaftarPenyakit("Sakit pada Tenggorokan", "Sakit tenggorokan adalah kondisi di mana tenggorokan terasa sakit, gatal, atau terbakar. Sakit tenggorokan dapat disebabkan oleh infeksi virus atau bakteri.\n" +
                "\n" +
                "Gejala sakit tenggorokan meliputi:\n" +
                "\n" +
                "- Sakit tenggorokan\n" +
                "- Gatal tenggorokan\n" +
                "- Rasa terbakar di tenggorokan\n" +
                "- Kesulitan menelan\n" +
                "Penanganan sakit tenggorokan tergantung pada penyebabnya. Jika sakit tenggorokan disebabkan oleh infeksi virus, maka pengobatan tidak diperlukan. Namun, jika sakit tenggorokan disebabkan oleh infeksi bakteri, maka pengobatan dengan antibiotik dapat membantu. "));
    }
}
