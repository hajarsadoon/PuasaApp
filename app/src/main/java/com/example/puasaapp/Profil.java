package com.example.puasaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Profil extends Fragment {

    TextView Name;
    ImageView AvatarPic;
    Button Skor, AddProfil;
    DatabaseReference databaseReferenceProfile;
    FirebaseAuth mAuth;
    FirebaseUser firebaseUserProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_profil, container, false);

        //SessionManager sessionManager;
        // mAuth = FirebaseAuth.getInstance();
        Name = view.findViewById(R.id.tv_displayname);
        AvatarPic = view.findViewById(R.id.iv_displayavatar);
        Skor = view.findViewById(R.id.btn_sijil);

        firebaseUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        String uid = firebaseUserProfile.getUid();

        databaseReferenceProfile = FirebaseDatabase.getInstance().getReference("users").child("Profile");
        databaseReferenceProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Name.setText(snapshot.child(uid).child("Nama").getValue(String.class));

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        DatabaseReference getImage = databaseReferenceProfile.child(uid).child("Avatar");

        getImage.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String imageUri = snapshot.getValue(String.class);
                Picasso.get().load(imageUri).into(AvatarPic);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(requireContext(), "Error Loading Image", Toast.LENGTH_SHORT).show();

            }
        });

        Skor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentSijil = new SkorKuiz();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container, fragmentSijil).commit();
            }
        });


        return view;
    }
}
