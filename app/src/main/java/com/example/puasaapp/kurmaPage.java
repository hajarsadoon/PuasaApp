package com.example.puasaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class kurmaPage extends Fragment {

    ImageView back4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kurma_page, container, false);

        back4 = view.findViewById(R.id.iv_back4);

        back4.setOnClickListener(new View.OnClickListener() {
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