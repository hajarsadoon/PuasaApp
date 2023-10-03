package com.example.puasaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SkorKuiz extends Fragment  {

    TextView namaPemain, skorPemain;
    DatabaseReference dbsijil;
    FirebaseUser fbuskor;
    ImageView backsijil;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sijil, container, false);

        namaPemain = view.findViewById(R.id.tv_namapemain);
        skorPemain = view.findViewById(R.id.tv_markpemain);
        backsijil = view.findViewById(R.id.iv_back12);

        backsijil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), MainActivity.class);
                startActivity(i);
            }
        });

        fbuskor = FirebaseAuth.getInstance().getCurrentUser();
        String uid = fbuskor.getUid();

        dbsijil = FirebaseDatabase.getInstance().getReference("users").child("Profile");
        dbsijil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String nama = snapshot.child(uid).child("Nama").getValue(String.class);
                Long skorKuiz = snapshot.child(uid).child("SkorKuiz").getValue(Long.class);

                namaPemain.setText(nama);
                skorPemain.setText(String.valueOf(skorKuiz) + "/8");

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });

        return view;
    }

}