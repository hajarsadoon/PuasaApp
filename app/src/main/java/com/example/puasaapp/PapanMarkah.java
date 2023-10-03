package com.example.puasaapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PapanMarkah extends Fragment {

    MyAdapter myAdapter;
    ArrayList<modelProfil> myItemsList = new ArrayList<modelProfil>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        // Get recyclerview from xml
        RecyclerView recyclerView = view.findViewById(R.id.listprofil);
        // Setting recycleview size fixed
        recyclerView.setHasFixedSize(true);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users").child("Profile");

        // Setting layout
        Context context = requireContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        myItemsList = new ArrayList<modelProfil>();
        myAdapter = new MyAdapter(this, myItemsList);

        recyclerView.setAdapter(myAdapter);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                myItemsList.clear();
                for (DataSnapshot users : snapshot.getChildren()) {
                    String profileKey = users.getKey(); // Get the profile key from the snapshot
                    modelProfil profil = users.getValue(modelProfil.class);
                    profil.setKey(profileKey); // Set the key in the model object
                    myItemsList.add(profil);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle onCancelled event if needed
            }
        });

        return view;
    }
}
