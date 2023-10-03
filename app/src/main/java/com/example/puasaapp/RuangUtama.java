package com.example.puasaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class RuangUtama extends Fragment {

    ImageView MakSunnah, Sirah, TenPuasa, Kuiz, Mewarna, MyTracker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ruang_utama, container, false);


        MakSunnah = view.findViewById(R.id.iv_MS);
        Sirah = view.findViewById(R.id.iv_Sirah);
        TenPuasa = view.findViewById(R.id.iv_TP);
        Kuiz = view.findViewById(R.id.iv_kuiz);
        Mewarna = view.findViewById(R.id.iv_mewarna);
        MyTracker = view.findViewById(R.id.iv_MT);

        MakSunnah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentMakSunnahh = new Sunnah();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,fragmentMakSunnahh).commit();
          }
        });
        TenPuasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentMakSunnah = new TentangPuasa();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,fragmentMakSunnah).commit();
            }
        });
        Sirah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentSirah = new Sirah();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,fragmentSirah).commit();
            }
        });
        Kuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentKuiz = new Kuiz();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,fragmentKuiz).commit();
            }
        });
        Mewarna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragmentMewarna = new Mewarna();
//                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
//                fm.replace(R.id.fragment_container,fragmentMewarna).commit();

                Intent intent = new Intent(getActivity(), testmewarna.class);
                startActivity(intent);
            }
        });
        MyTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentMyTracker = new MyTracker();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,fragmentMyTracker).commit();
            }
        });

            return view;
    }
}
