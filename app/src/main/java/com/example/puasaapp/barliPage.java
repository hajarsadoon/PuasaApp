package com.example.puasaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class barliPage extends Fragment {

    ImageView back3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_barli_page, container, false);

        back3 = view.findViewById(R.id.iv_back4);

        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment sunnah= new Sunnah();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,sunnah).commit();
            }
        });

        return view;
    }
}