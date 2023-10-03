package com.example.puasaapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    PapanMarkah context;
    ArrayList<modelProfil> items;

    public MyAdapter(PapanMarkah context, ArrayList<modelProfil> items) {
        this.context = context;
        this.items = items;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create and return a new instance of MyViewHolder
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_papan_markah, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        modelProfil myItems = items.get(position);
        holder.Nama.setText(myItems.getNama());

        String imageUri = myItems.getAvatar();
        Picasso.get().load(String.valueOf(imageUri)).into(holder.Avatar);

        Integer skorKuiz = myItems.getSkorKuiz();
        if (skorKuiz != null) {
            holder.SkorKuiz.setText(skorKuiz + "/8");
        } else {
            holder.SkorKuiz.setText("N/A");
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView SkorKuiz ;
        private final TextView Nama;
        private final ImageView Avatar;


        public MyViewHolder(View itemView) {
            super(itemView);
            Nama = itemView.findViewById(R.id.namaSkor);
            Avatar = itemView.findViewById(R.id.iv_skorPic);
            SkorKuiz = itemView.findViewById(R.id.skorSkor);


        }
    }

}
