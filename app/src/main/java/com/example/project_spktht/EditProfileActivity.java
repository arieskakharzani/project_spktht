package com.example.project_spktht;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditProfileActivity extends AppCompatActivity {

    EditText profileName, profileEmail, profilePhone;
    ImageView ProfileImg;
    Button saveButton;
    DatabaseReference reference;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fireStore;
    FirebaseUser user;
    ActivityResultLauncher<Intent> galleryLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ProfileImg = findViewById(R.id.editProfileImg);
        profileName = findViewById(R.id.editName);
        profileEmail = findViewById(R.id.editEmail);
        profilePhone = findViewById(R.id.editPhone);
        saveButton = findViewById(R.id.saveButton);
    }



}