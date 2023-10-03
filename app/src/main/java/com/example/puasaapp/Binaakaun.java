package com.example.puasaapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class Binaakaun extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://puasaapp-default-rtdb.asia-southeast1.firebasedatabase.app");
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();
    FirebaseAuth fAuth;
    Drawable avatarDrawable; // Declare a variable to store the selected avatar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bina_profil);

        final Button btnCreate = findViewById(R.id.btn_create);
        final EditText profileName = findViewById(R.id.et_name);
        final EditText email = findViewById(R.id.et_email);
        final EditText password = findViewById(R.id.et_password);
        final ImageButton avatarBoy = findViewById(R.id.btn_boy);
        final ImageButton avatarGirl = findViewById(R.id.btn_girl);
        final TextView logMasuk = findViewById(R.id.tv_logmasuk);

        // add OnClickListener to toggle boy avatar selection
        avatarBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!avatarBoy.isSelected()) {
                    avatarBoy.setSelected(true);
                    avatarBoy.setBackground(ContextCompat.getDrawable(Binaakaun.this, R.drawable.avatarboyselect));
                    if (avatarGirl.isSelected()) {
                        avatarGirl.setSelected(false);
                        avatarGirl.setBackground(ContextCompat.getDrawable(Binaakaun.this, R.drawable.avatargirl));
                    }
                    avatarDrawable = getResources().getDrawable(R.drawable.avatarboyselect);
                }
            }
        });

        avatarGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!avatarGirl.isSelected()) {
                    avatarGirl.setSelected(true);
                    avatarGirl.setBackground(ContextCompat.getDrawable(Binaakaun.this, R.drawable.avatargirlselect));
                    if (avatarBoy.isSelected()) {
                        avatarBoy.setSelected(false);
                        avatarBoy.setBackground(ContextCompat.getDrawable(Binaakaun.this, R.drawable.avatarboy));
                    }
                    avatarDrawable = getResources().getDrawable(R.drawable.avatargirlselect);
                }
            }
        });

        fAuth = FirebaseAuth.getInstance();

        btnCreate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                final String username = profileName.getText().toString();
                final String profileEmail = email.getText().toString();
                final String profilePassword = password.getText().toString();

                if (profileEmail.isEmpty() || profilePassword.isEmpty() || username.isEmpty()) {
                    Toast.makeText(Binaakaun.this, "Sila isi tempat kosong", Toast.LENGTH_SHORT).show();
                } else {

                    fAuth.createUserWithEmailAndPassword(profileEmail, profilePassword).addOnCompleteListener((Activity) Binaakaun.this,
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        String uid = task.getResult().getUser().getUid();

                                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot snapshot) {
                                                if (snapshot.hasChild(uid)) {
                                                    Toast.makeText(Binaakaun.this, "Nama ini telah digunakan ", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    // Create a Storage reference with filename
                                                    StorageReference imageRef = storageRef.child("avatars/" + username + ".png");

                                                    if (avatarDrawable != null) {
                                                        // Convert drawable image to Bitmap
                                                        Bitmap bitmap = ((BitmapDrawable) avatarDrawable).getBitmap();

                                                        // Compress the Bitmap image and upload it to Firebase Storage
                                                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                                                        byte[] data = baos.toByteArray();

                                                        UploadTask uploadTask = imageRef.putBytes(data);
                                                        uploadTask.addOnFailureListener(new OnFailureListener() {
                                                            @Override
                                                            public void onFailure(Exception e) {
                                                                Toast.makeText(Binaakaun.this, "Upload avatar failed", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                            @Override
                                                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                                // Get download URL and save it to Firebase Realtime Database
                                                                imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                                    @Override
                                                                    public void onSuccess(Uri uri) {
                                                                        String avatarURL = uri.toString();
                                                                        // Save the user's profile and avatar to the database
                                                                        databaseReference.child("users").child("Profile").child(uid).child("Nama").setValue(username);
                                                                        databaseReference.child("users").child("Profile").child(uid).child("Email").setValue(profileEmail);
                                                                        databaseReference.child("users").child("Profile").child(uid).child("Kata laluan").setValue(profilePassword);
                                                                        databaseReference.child("users").child("Profile").child(uid).child("Avatar").setValue(avatarURL);

                                                                        //databaseReference.child("users").child("Profile").child(uid).child("Name: " + username).child("Avatar").setValue(avatarURL);

//                                                                        Intent i = new Intent(Binaakaun.this, MainActivity.class);
//                                                                        startActivity(i);

//                                                                        Fragment fragmentRU = new RuangUtama();
//                                                                        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
//                                                                        fm.replace(R.id.fragment_container, fragmentRU).commit();

                                                                        //preferences.setDataLogin(Binaakaun.this, true);
                                                                        startActivity(new Intent(Binaakaun.this, MainActivity.class));
                                                                        Toast.makeText(Binaakaun.this, "Berjaya di daftar", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                });

                                                            }

                                                            ;

                                                        });
                                                    }
                                                }
                                                ;

                                            }

                                            @Override
                                            public void onCancelled(DatabaseError error) {

                                            }
                                        });
                                    }
                                    ;
                                }
                            });
                }
            }
        });

        logMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(Binaakaun.this, Login.class);
                startActivity(t);
            }
        });
    }
//    @Override
//    protected void onStart(){
//        super.onStart();
//        preferences.getDataLogin(this);
//        startActivity(new Intent(Binaakaun.this, MainActivity.class));
//        finish();
//    }
}