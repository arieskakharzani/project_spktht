package com.example.project_spktht;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    CardView mcGejala, mcDiagnosa, mcTentang, mcKonsul, mcPenyakit, mcAlergi, mcPengingat, mcProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();
                        System.out.println("TOKEN "+ token);
                    }
                });

        mcGejala = findViewById(R.id.mcGejala);
        mcDiagnosa = findViewById(R.id.mcDiagnosa);
        mcTentang = findViewById(R.id.mcTentang);
        mcKonsul = findViewById(R.id.mcKonsul);
        mcPenyakit = findViewById(R.id.mcPenyakit);
        mcAlergi = findViewById(R.id.mcAlergi);
        mcPengingat = findViewById(R.id.mcPengingat);
        mcProfile = findViewById(R.id.mcProfile);

        mcGejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DaftarPenyakitActivity.class);
                startActivity(intent);
            }
        });

        mcDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DiagnosaGejalaActivity.class);
                startActivity(intent);
            }
        });

        mcTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TentangAplikasiActivity.class);
                startActivity(intent);
            }
        });

        mcKonsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityKonsul.class);
                startActivity(intent);
            }
        });

        mcPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityPenyakit.class);
                startActivity(intent);
            }
        });

        mcAlergi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityAlergi.class);
                startActivity(intent);
            }
        });

        mcPengingat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PengingatActivity.class);
                startActivity(intent);
            }
        });

        mcProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}