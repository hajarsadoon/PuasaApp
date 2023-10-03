package com.example.puasaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class susuPage extends Fragment {

    ImageView back2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_susu_page, container, false);


        back2 = view.findViewById(R.id.iv_back4);

        back2.setOnClickListener(new View.OnClickListener() {
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