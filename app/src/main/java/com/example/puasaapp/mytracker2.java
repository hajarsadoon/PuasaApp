package com.example.puasaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ToggleButton;


public class mytracker2 extends Fragment {

    private static final String TOGGLE_STATE19 = "toggle_state_19";
    private static final String TOGGLE_STATE20 = "toggle_state_20";
    private static final String TOGGLE_STATE21 = "toggle_state_21";
    private static final String TOGGLE_STATE22 = "toggle_state_22";
    private static final String TOGGLE_STATE23 = "toggle_state_23";
    private static final String TOGGLE_STATE24 = "toggle_state_24";
    private static final String TOGGLE_STATE25 = "toggle_state_25";
    private static final String TOGGLE_STATE26 = "toggle_state_26";
    private static final String TOGGLE_STATE27 = "toggle_state_27";
    private static final String TOGGLE_STATE28 = "toggle_state_28";
    private static final String TOGGLE_STATE29 = "toggle_state_29";
    private static final String TOGGLE_STATE30 = "toggle_state_30";

    ImageView back2;

    private boolean toggleChecked19;
    private boolean toggleChecked20;
    private boolean toggleChecked21;
    private boolean toggleChecked22;
    private boolean toggleChecked23;
    private boolean toggleChecked24;
    private boolean toggleChecked25;
    private boolean toggleChecked26;
    private boolean toggleChecked27;
    private boolean toggleChecked28;
    private boolean toggleChecked29;
    private boolean toggleChecked30;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mytracker2, container, false);

        ToggleButton defaultToggleButton19 = view.findViewById(R.id.toggle19);
        defaultToggleButton19.setChecked(toggleChecked19);
        ToggleButton defaultToggleButton20 = view.findViewById(R.id.toggle20);
        defaultToggleButton20.setChecked(toggleChecked20);
        ToggleButton defaultToggleButton21 = view.findViewById(R.id.toggle21);
        defaultToggleButton21.setChecked(toggleChecked21);
        ToggleButton defaultToggleButton22 = view.findViewById(R.id.toggle22);
        defaultToggleButton22.setChecked(toggleChecked22);
        ToggleButton defaultToggleButton23 = view.findViewById(R.id.toggle23);
        defaultToggleButton23.setChecked(toggleChecked23);
        ToggleButton defaultToggleButton24 = view.findViewById(R.id.toggle24);
        defaultToggleButton24.setChecked(toggleChecked24);
        ToggleButton defaultToggleButton25 = view.findViewById(R.id.toggle25);
        defaultToggleButton25.setChecked(toggleChecked25);
        ToggleButton defaultToggleButton26 = view.findViewById(R.id.toggle26);
        defaultToggleButton26.setChecked(toggleChecked26);
        ToggleButton defaultToggleButton27 = view.findViewById(R.id.toggle27);
        defaultToggleButton27.setChecked(toggleChecked27);
        ToggleButton defaultToggleButton28 = view.findViewById(R.id.toggle28);
        defaultToggleButton28.setChecked(toggleChecked28);
        ToggleButton defaultToggleButton29 = view.findViewById(R.id.toggle29);
        defaultToggleButton29.setChecked(toggleChecked29);
        ToggleButton defaultToggleButton30 = view.findViewById(R.id.toggle30);
        defaultToggleButton30.setChecked(toggleChecked30);

        back2 = view.findViewById(R.id.iv_back8);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), MainActivity.class);
                startActivity(i);
            }
        });

        defaultToggleButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked19 = defaultToggleButton19.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE19, toggleChecked19);
                editor.apply();
            }
        });
        defaultToggleButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked20 = defaultToggleButton20.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE20, toggleChecked20);
                editor.apply();
            }
        });
        defaultToggleButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked21 = defaultToggleButton21.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE21, toggleChecked19);
                editor.apply();
            }
        });
        defaultToggleButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked22 = defaultToggleButton22.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE22, toggleChecked22);
                editor.apply();
            }
        });
        defaultToggleButton23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked23 = defaultToggleButton23.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE23, toggleChecked23);
                editor.apply();
            }
        });
        defaultToggleButton24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked24 = defaultToggleButton24.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE24, toggleChecked24);
                editor.apply();
            }
        });
        defaultToggleButton25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked25 = defaultToggleButton25.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE25, toggleChecked25);
                editor.apply();
            }
        });
        defaultToggleButton26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked26 = defaultToggleButton26.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE26, toggleChecked26);
                editor.apply();
            }
        });
        defaultToggleButton27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked27 = defaultToggleButton27.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE27, toggleChecked27);
                editor.apply();
            }
        });
        defaultToggleButton28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked28= defaultToggleButton28.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE28, toggleChecked28);
                editor.apply();
            }
        });
        defaultToggleButton29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked29 = defaultToggleButton29.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE29, toggleChecked29);
                editor.apply();
            }
        });
        defaultToggleButton30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked30 = defaultToggleButton30.isChecked();
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE30, toggleChecked30);
                editor.apply();
            }
        });


        SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
        toggleChecked19 = prefs.getBoolean(TOGGLE_STATE19, false);
        toggleChecked20 = prefs.getBoolean(TOGGLE_STATE20, false);
        toggleChecked21 = prefs.getBoolean(TOGGLE_STATE21, false);
        toggleChecked22 = prefs.getBoolean(TOGGLE_STATE22, false);
        toggleChecked23 = prefs.getBoolean(TOGGLE_STATE23, false);
        toggleChecked24 = prefs.getBoolean(TOGGLE_STATE24, false);
        toggleChecked25 = prefs.getBoolean(TOGGLE_STATE25, false);
        toggleChecked26 = prefs.getBoolean(TOGGLE_STATE26, false);
        toggleChecked27 = prefs.getBoolean(TOGGLE_STATE27, false);
        toggleChecked28 = prefs.getBoolean(TOGGLE_STATE28, false);
        toggleChecked29 = prefs.getBoolean(TOGGLE_STATE29, false);
        toggleChecked30 = prefs.getBoolean(TOGGLE_STATE30, false);

        defaultToggleButton19.setChecked(toggleChecked19);
        defaultToggleButton20.setChecked(toggleChecked20);
        defaultToggleButton21.setChecked(toggleChecked21);
        defaultToggleButton22.setChecked(toggleChecked22);
        defaultToggleButton23.setChecked(toggleChecked23);
        defaultToggleButton24.setChecked(toggleChecked24);
        defaultToggleButton25.setChecked(toggleChecked25);
        defaultToggleButton26.setChecked(toggleChecked26);
        defaultToggleButton27.setChecked(toggleChecked27);
        defaultToggleButton28.setChecked(toggleChecked28);
        defaultToggleButton29.setChecked(toggleChecked29);
        defaultToggleButton30.setChecked(toggleChecked30);

        ((MainActivity)getActivity()).setDrawer_Locked();
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((MainActivity) getActivity()).setDrawer_Unlocked();
    }
}