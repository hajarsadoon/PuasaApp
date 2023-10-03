package com.example.puasaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        TextView dftrmsuk = findViewById(R.id.tv_dftrmsuk);
        EditText email = findViewById(R.id.et_emaillogmasuk);
        EditText password = findViewById(R.id.et_passwordlogmasuk);
        Button btnlogin = findViewById(R.id.btn_logmasuk);
        Intent intent;

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(Login.this, "Masukkan email dan kata laluan", Toast.LENGTH_SHORT).show();
                } else {
                    final FirebaseAuth mFirebaseAuth;
                    mFirebaseAuth = FirebaseAuth.getInstance();

                    mFirebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(Login.this,
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete( Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        String uid = task.getResult().getUser().getUid();

                                        //preferences.setDataLogin(Login.this, true);
                                        //startActivity(new Intent(Login.this, MainActivity.class));
                                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                        firebaseDatabase.getReference().child("users").child("Profile").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange( DataSnapshot snapshot) {
                                                startActivity(new Intent(Login.this, MainActivity.class));
                                                Toast.makeText(Login.this, "Log Masuk berjaya", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void onCancelled(DatabaseError error) {
                                                // Handle the database error
                                            }
                                        });
                                    } else {
                                        Toast.makeText(Login.this, "Maklumat yang dimasukkan salah", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        dftrmsuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Binaakaun.class);
                startActivity(i);
                Toast.makeText(Login.this, "Bina Profil", Toast.LENGTH_SHORT).show();
            }
        });
    }
//    @Override
//    protected void onStart(){
//        super.onStart();
//        preferences.getDataLogin(this);
//        startActivity(new Intent(Login.this, MainActivity.class));
//        finish();
//    }
}

