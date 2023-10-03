package com.example.puasaapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;


public class WajibpuasaPage extends Fragment {

    ImageView back6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_wajibpuasa_page, container, false);

       ImageView play3;
       play3 = view.findViewById(R.id.iv_play5);
       VideoView videoview;

        videoview = view.findViewById(R.id.video_view);
        String videoPath = "android.resource://"+ getContext().getPackageName()+ "/"+R.raw.orangwajibpuas;
        Uri uri = Uri.parse(videoPath);
        videoview.setVideoURI(uri);

        // Set the OnPreparedListener
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // Hide the play ImageView
                play3.setVisibility(View.GONE);
                // Start the video playback
                videoview.start();
            }
        });


       back6 = view.findViewById(R.id.iv_back6);

       back6.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Fragment tentangpuasa= new TentangPuasa();
               FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
               fm.replace(R.id.fragment_container,tentangpuasa).commit();
           }
       });

        // Set the OnClickListener for the play ImageView
        play3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Show the video playback controls
                videoview.setVisibility(View.VISIBLE);
                // Hide the play ImageView
                play3.setVisibility(View.GONE);
                // Start the video playback
                videoview.start();
            }
        });

        // Hide the VideoView initially
        videoview.setVisibility(View.GONE);

       return view;
    }
}