package com.example.puasaapp;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class NiatList extends Fragment {


    ImageView Play, Play2, Back5;
    MediaPlayer niatpuasa, niatbuka;
    boolean isPlaying = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_niat_list, container, false);

        Play = view.findViewById(R.id.iv_play);
        niatpuasa = MediaPlayer.create(getContext(), R.raw.audio_niatpuasa);
        Play2 = view.findViewById(R.id.iv_play2);
        niatbuka = MediaPlayer.create(getContext(), R.raw.audio_bukapuasa);
        Back5 = view.findViewById(R.id.iv_back5);

    // Set click listener for the ImageView
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    pauseAudio();
                } else {
                    playAudio();
                }
            }
        });

        Play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    pauseAudio2();
                } else {
                    playAudio2();
                }
            }
        });

        Back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment tentangpuasa= new TentangPuasa();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,tentangpuasa).commit();
            }
        });

        return view;
    }

    private void playAudio() {
        // Play the audio
        niatpuasa.start();
        isPlaying = true;
        Play.setImageResource(R.drawable.ic_baseline_pause_24);
    }

    private void playAudio2() {
        // Play the audio
        niatbuka.start();
        isPlaying = true;
        Play2.setImageResource(R.drawable.ic_baseline_pause_24);
    }

    private void pauseAudio() {
        // Pause the audio
        niatpuasa.pause();
        isPlaying = false;
        Play.setImageResource(R.drawable.ic_baseline_play_arrow_24);
    }

    private void pauseAudio2() {
        // Pause the audio
        niatbuka.pause();
        isPlaying = false;
        Play2.setImageResource(R.drawable.ic_baseline_play_arrow_24);
    }

    // Release the MediaPlayer instance when the Fragment is destroyed
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (niatpuasa  != null) {
            niatpuasa.release();
            niatpuasa = null;
        }
        if (niatbuka != null) {
            niatbuka.release();
            niatbuka = null;
        }
    }
}