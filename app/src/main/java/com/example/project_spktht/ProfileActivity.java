package com.example.project_spktht;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.UUID;

public class ProfileActivity extends AppCompatActivity {
    TextView profileName, profileEmail, profilePhone;
    Button editProfile, resetPassword, backToHome, logoutButton, changeProfile;
    ImageView profileImg;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fireStore;
    String userId;
    FirebaseUser user;
    FirebaseStorage storage;
    Uri imageUri;
    private String profileImageURL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImg = findViewById(R.id.profileImg);
        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profilePhone = findViewById(R.id.profilePhone);
        resetPassword = findViewById(R.id.changePassword);
        backToHome = findViewById(R.id.backToHomeBtn);
        logoutButton = findViewById(R.id.logoutButton);
        changeProfile = findViewById(R.id.changeProfile);

        firebaseAuth = FirebaseAuth.getInstance();
        fireStore = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

        userId = firebaseAuth.getCurrentUser().getUid();
        user = firebaseAuth.getCurrentUser();

        retrieveAndDisplayImage();

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });

        DocumentReference documentReference = fireStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot.exists()) {
                    profileName.setText(documentSnapshot.getString("name"));
                    profileEmail.setText(documentSnapshot.getString("email"));
                    profilePhone.setText(documentSnapshot.getString("phone"));
                } else {
                    Log.d("tag", "onEvent: Document do not exists");
                }
            }
        });

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText resetPassword = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password?");
                passwordResetDialog.setMessage("Masukkan Password yang Baru ( => 6 karakter)");
                passwordResetDialog.setView(resetPassword);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the email and send reset link
                        String newPassword = resetPassword.getText().toString();
                        user.updatePassword(newPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(ProfileActivity.this, "Password berhasil diubah !", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ProfileActivity.this, "Reset Password Failed !", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close
                    }
                });

                passwordResetDialog.create().show();
            }
        });

        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //run the below method on changeProfile click
        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startForResult.launch(openGalleryIntent);
                //the image is selected succesfully from the gallery and next to upload it to teh firebase storage
            }
        });

    }

    // Store the profile image URL in Firestore
    private void storeImageURL(String imageURL) {
        DocumentReference documentReference = fireStore.collection("users").document(userId);
        documentReference.update("profileImageURL", imageURL)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    private String profileImageURL;

                    @Override
                    public void onSuccess(Void unused) {
                        Log.d("TAG", "Profile image URL stored successfully");
                        this.profileImageURL = imageURL; // Update the local variable
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("TAG", "Error storing profile image URL", e);
                    }
                });
    }

    // Retrieve the profile image URL from Firestore and display it
    private void retrieveAndDisplayImage() {
        DocumentReference documentReference = fireStore.collection("users").document(userId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            private String profileImageURL;

            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String imageURL = documentSnapshot.getString("profileImageURL");
                    if (imageURL != null) {
                        Picasso.get().load(imageURL).into(profileImg);
                        this.profileImageURL = imageURL; // Update the local variable
                    }
                }
            }
        });
    }

    //store profile image to firebase
    private void uploadImage() {
        if(imageUri != null){
            StorageReference reference = storage.getReference().child("image/"+ UUID.randomUUID().toString());
            //creating a reference to store the image in firebase storage
            reference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if(task.isSuccessful()){
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String imageURL = uri.toString();
                                storeImageURL(imageURL); // Store the URL in Firestore
                            }
                        });
                    } else {
                        Toast.makeText(ProfileActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            //this is the result for uri
            if (result != null && result.getResultCode() == RESULT_OK){
                Intent data = result.getData();
                if(data != null && data.getData() != null ){
                    imageUri = data.getData();
                    Picasso.get().load(imageUri).into(profileImg);

                }
            }
        }
    });

    public void logout (View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

}