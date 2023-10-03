package com.example.puasaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.kyanogen.signatureview.SignatureView;

import Interface.ImageOnClick;

public class Mewarna extends Fragment implements AdapterMewarna.OnItemClickListener{

    RecyclerView recyclerView;
    AdapterMewarna adapterMewarna;
    SignatureView signatureView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mewarna, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recylerview_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterMewarna = new AdapterMewarna(this);
        recyclerView.setAdapter(adapterMewarna);
    }

    @Override
    public void onItemClick(int position) {
        }

}
