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

public class Fadhilatpuasa extends Fragment {

    ImageView back7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fadhilatpuasa, container, false);

        back7 = view.findViewById(R.id.back10); // Initialize back7 with the corresponding ImageView

        ImageView play4 = view.findViewById(R.id.iv_play6); // Initialize play4 ImageView

        VideoView videoView2 = view.findViewById(R.id.video_view2); // Initialize videoView2
        

        String videoPath = "android.resource://" + getContext().getPackageName() + "/" + R.raw.fadhilatpuasa;
        Uri uri = Uri.parse(videoPath);
        videoView2.setVideoURI(uri);

        // Set the OnPreparedListener
        videoView2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // Hide the play ImageView
                play4.setVisibility(View.GONE);
                // Start the video playback
                videoView2.start();
            }
        });

        back7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment tentangpuasa = new TentangPuasa();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container, tentangpuasa).commit();
            }
        });

        // Set the OnClickListener for the play ImageView
        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the video playback controls
                videoView2.setVisibility(View.VISIBLE);
                // Hide the play ImageView
                play4.setVisibility(View.GONE);
                // Start the video playback
                videoView2.start();
            }
        });

        // Hide the VideoView initially
        videoView2.setVisibility(View.GONE);
        return view;
    }
}
