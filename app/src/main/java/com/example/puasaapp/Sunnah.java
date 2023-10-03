package com.example.puasaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.manager.Lifecycle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.rd.PageIndicatorView;

import java.util.ArrayList;

public class Sunnah extends Fragment {

    ViewPager viewPager;
    PageIndicatorView pageIndicatorView;
    ArrayList<Integer> images = new ArrayList<>();
    ViewPagerAdapter adapter;
    Integer cont;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sunnah, container, false);

        viewPager = view.findViewById(R.id.viewpager);
        pageIndicatorView = view.findViewById(R.id.pageIndicator);

        images.add(R.drawable.dates);
        images.add(R.drawable.honey);
        images.add(R.drawable.milk);
        images.add(R.drawable.barley);

        adapter = new ViewPagerAdapter(this, images);
        viewPager.setPadding(100, 0,100,0);

        viewPager.setAdapter(adapter);
        pageIndicatorView.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Handle page scrolled event
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        cont = 1;
                        break;
                    case 1:
                        cont = 2;
                        break;
                    case 2:
                        cont = 3;
                        break;
                    case 3:
                        cont = 4;
                        break;
                    default:
                        cont = 0;
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Handle page scroll state changed event
            }
        });

        adapter.setOnItemClickListener(new ViewPagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        toasted("Kurma");
                        Fragment Kurma = new kurmaPage();
                        FragmentTransaction fk = getActivity().getSupportFragmentManager().beginTransaction();
                        fk.replace(R.id.fragment_container, Kurma).commit();
                        break;
                    case 1:
                        toasted("Madu");
                        Fragment Madu = new maduPage();
                        FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                        fm.replace(R.id.fragment_container, Madu).commit();
                        break;
                    case 2:
                        toasted("Susu");
                        Fragment Susu = new susuPage();
                        FragmentTransaction fs = getActivity().getSupportFragmentManager().beginTransaction();
                        fs.replace(R.id.fragment_container, Susu).commit();
                        break;
                    case 3:
                        toasted("Barli");
                        Fragment Barli = new barliPage();
                        FragmentTransaction fb = getActivity().getSupportFragmentManager().beginTransaction();
                        fb.replace(R.id.fragment_container, Barli).commit();
                        break;
                }
            }
        });

        return view;
    }

    public void toasted(String s) {
        Toast.makeText(requireContext(), s, Toast.LENGTH_SHORT).show();
    }
}
