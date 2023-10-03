package com.example.puasaapp;

import android.content.Intent;
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


public class Sirah extends Fragment {

    ImageView back11;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sirah, container, false);

        back11 = view.findViewById(R.id.iv_back11); // Initialize back11 with the corresponding ImageView

        ImageView play4 = view.findViewById(R.id.iv_play7); // Initialize play4 ImageView

        VideoView videoView3 = view.findViewById(R.id.vv_sirah); // Initialize videoView2


        String videoPath = "android.resource://" + getContext().getPackageName() + "/" + R.raw.sirah;
        Uri uri = Uri.parse(videoPath);
        videoView3.setVideoURI(uri);

        // Set the OnPreparedListener
        videoView3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // Hide the play ImageView
                play4.setVisibility(View.GONE);
                // Start the video playback
                videoView3.start();
            }
        });

        back11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), MainActivity.class);
                startActivity(i);
            }
        });

        // Set the OnClickListener for the play ImageView
        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the video playback controls
                videoView3.setVisibility(View.VISIBLE);
                // Hide the play ImageView
                play4.setVisibility(View.GONE);
                // Start the video playback
                videoView3.start();
            }
        });

        // Hide the VideoView initially
        videoView3.setVisibility(View.GONE);

        ((MainActivity)getActivity()).setDrawer_Locked();
        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        ((MainActivity)getActivity()).setDrawer_Unlocked();
    }

}
