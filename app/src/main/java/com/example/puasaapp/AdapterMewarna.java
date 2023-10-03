package com.example.puasaapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Interface.ImageOnClick;

public class AdapterMewarna extends RecyclerView.Adapter<ImageViewHolder> {

    private Mewarna mContext;
    private List<Integer> listImages;
    private OnItemClickListener onItemClickListener;

    public AdapterMewarna(Mewarna mContext) {
        this.mContext = mContext;
        this.listImages = getImages();
        this.onItemClickListener = onItemClickListener;
    }

    private List<Integer> getImages() {
        List<Integer> results = new ArrayList<>();

        results.add(R.drawable.kurakura);
        results.add(R.drawable.gajah);
        results.add(R.drawable.burung);
        return results;

    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_images, parent, false);
        return new ImageViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ImageViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(listImages.get(position));

        // Set click listener for the item
        holder.setImageOnClick(new ImageOnClick() {
            @Override
            public void onClick(int pos) {
                Common.PICTURE_SELECTED = listImages.get(pos);
                Intent intent = new Intent(mContext.requireContext(), testmewarna.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public int getImageResource(int position){
        return listImages.get(position);
    }
}

