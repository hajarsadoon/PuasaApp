package com.example.puasaapp;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import Interface.ImageOnClick;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public void setImageOnClick(ImageOnClick imageOnClick) {
        this.imageOnClick = imageOnClick;
    }

    private ImageOnClick imageOnClick;

    public ImageViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image_outline);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageOnClick.onClick(getAdapterPosition());
            }
        });
    }

}
