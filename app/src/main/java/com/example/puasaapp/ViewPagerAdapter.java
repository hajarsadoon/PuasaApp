package com.example.puasaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.manager.Lifecycle;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {

    Sunnah context;
    ArrayList<Integer> images;
    OnItemClickListener itemClickListener; // Declare the listener

    public ViewPagerAdapter(Sunnah context, ArrayList<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(context.getContext()).inflate(R.layout.adapter_viewpager, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);

        Glide.with(context).asBitmap().load(images.get(position)).into(imageView);

        // Set OnClickListener on the view
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(position); // Notify the listener about the click event
                }
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    // Setter method to set the item click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}


