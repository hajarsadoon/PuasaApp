package com.example.puasaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TentangPuasa extends Fragment {

    Button btnNiat, btnWajib, btnFadhilat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tentang_puasa, container, false);

        btnNiat = view.findViewById(R.id.btn_niat);
        btnWajib = view.findViewById(R.id.btn_orgwajib);
        btnFadhilat = view.findViewById(R.id.btn_fadhilat);

        btnNiat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment niat = new NiatList();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,niat).commit();
            }
        });

        btnWajib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment wajib = new WajibpuasaPage();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,wajib).commit();
            }
        });

        btnFadhilat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fadhilat = new Fadhilatpuasa();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,fadhilat).commit();
            }
        });


        return view;
    }
}