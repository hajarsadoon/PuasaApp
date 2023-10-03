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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyTracker extends Fragment {

    DatabaseReference dbtracker;
    FirebaseUser fbutracker;
    String uid;

    private static final String TOGGLE_STATE = "toggle_state";
    private static final String TOGGLE_STATE2 = "toggle_state_2";
    private static final String TOGGLE_STATE3 = "toggle_state_3";
    private static final String TOGGLE_STATE4 = "toggle_state_4";
    private static final String TOGGLE_STATE5= "toggle_state_5";
    private static final String TOGGLE_STATE6= "toggle_state_6";
    private static final String TOGGLE_STATE7= "toggle_state_7";
    private static final String TOGGLE_STATE8= "toggle_state_8";
    private static final String TOGGLE_STATE9= "toggle_state_9";
    private static final String TOGGLE_STATE10= "toggle_state_10";
    private static final String TOGGLE_STATE11= "toggle_state_11";
    private static final String TOGGLE_STATE12= "toggle_state_12";
    private static final String TOGGLE_STATE13= "toggle_state_13";
    private static final String TOGGLE_STATE14= "toggle_state_14";
    private static final String TOGGLE_STATE15= "toggle_state_15";
    private static final String TOGGLE_STATE16= "toggle_state_16";
    private static final String TOGGLE_STATE17= "toggle_state_17";
    private static final String TOGGLE_STATE18= "toggle_state_18";

    Button buttonNext;
    ImageView back;

    private boolean toggleChecked;
    private boolean toggleChecked2;
    private boolean toggleChecked3;
    private boolean toggleChecked4;
    private boolean toggleChecked5;
    private boolean toggleChecked6;
    private boolean toggleChecked7;
    private boolean toggleChecked8;
    private boolean toggleChecked9;
    private boolean toggleChecked10;
    private boolean toggleChecked11;
    private boolean toggleChecked12;
    private boolean toggleChecked13;
    private boolean toggleChecked14;
    private boolean toggleChecked15;
    private boolean toggleChecked16;
    private boolean toggleChecked17;
    private boolean toggleChecked18;

    private int latestCheckedTogglePosition;
    private static final String LATEST_TOGGLE_POSITION = "latest_toggle_position";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_tracker, container, false);

        ToggleButton defaultToggleButton = view.findViewById(R.id.toggle);
        defaultToggleButton.setChecked(toggleChecked);
        ToggleButton defaultToggleButton2 = view.findViewById(R.id.toggle2);
        defaultToggleButton2.setChecked(toggleChecked2);
        ToggleButton defaultToggleButton3 = view.findViewById(R.id.toggle3);
        defaultToggleButton3.setChecked(toggleChecked3);
        ToggleButton defaultToggleButton4 = view.findViewById(R.id.toggle4);
        defaultToggleButton4.setChecked(toggleChecked4);
        ToggleButton defaultToggleButton5 = view.findViewById(R.id.toggle5);
        defaultToggleButton5.setChecked(toggleChecked5);
        ToggleButton defaultToggleButton6 = view.findViewById(R.id.toggle6);
        defaultToggleButton6.setChecked(toggleChecked6);
        ToggleButton defaultToggleButton7 = view.findViewById(R.id.toggle7);
        defaultToggleButton7.setChecked(toggleChecked7);
        ToggleButton defaultToggleButton8 = view.findViewById(R.id.toggle8);
        defaultToggleButton8.setChecked(toggleChecked8);
        ToggleButton defaultToggleButton9 = view.findViewById(R.id.toggle9);
        defaultToggleButton9.setChecked(toggleChecked9);
        ToggleButton defaultToggleButton10 = view.findViewById(R.id.toggle10);
        defaultToggleButton10.setChecked(toggleChecked10);
        ToggleButton defaultToggleButton11 = view.findViewById(R.id.toggle11);
        defaultToggleButton11.setChecked(toggleChecked11);
        ToggleButton defaultToggleButton12 = view.findViewById(R.id.toggle12);
        defaultToggleButton12.setChecked(toggleChecked12);
        ToggleButton defaultToggleButton13 = view.findViewById(R.id.toggle13);
        defaultToggleButton13.setChecked(toggleChecked13);
        ToggleButton defaultToggleButton14 = view.findViewById(R.id.toggle14);
        defaultToggleButton14.setChecked(toggleChecked14);
        ToggleButton defaultToggleButton15 = view.findViewById(R.id.toggle15);
        defaultToggleButton15.setChecked(toggleChecked15);
        ToggleButton defaultToggleButton16 = view.findViewById(R.id.toggle16);
        defaultToggleButton16.setChecked(toggleChecked16);
        ToggleButton defaultToggleButton17 = view.findViewById(R.id.toggle17);
        defaultToggleButton17.setChecked(toggleChecked17);
        ToggleButton defaultToggleButton18 = view.findViewById(R.id.toggle18);
        defaultToggleButton18.setChecked(toggleChecked18);

        buttonNext = view.findViewById(R.id.button);
        back = view.findViewById(R.id.iv_back7);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), MainActivity.class);
                startActivity(i);
            }
        });

        defaultToggleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggleChecked = defaultToggleButton.isChecked();
                    latestCheckedTogglePosition = 1; // Update the latest checked toggle position
                    SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(TOGGLE_STATE, toggleChecked);
                    editor.apply();
                }
            });
        defaultToggleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked2 = defaultToggleButton2.isChecked();
                latestCheckedTogglePosition = 2; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE2, toggleChecked2);
                editor.apply();
            }
        });
        defaultToggleButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked3 = defaultToggleButton3.isChecked();
                latestCheckedTogglePosition = 3; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE3, toggleChecked3);
                editor.apply();
            }
        });
        defaultToggleButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked4 = defaultToggleButton4.isChecked();
                latestCheckedTogglePosition = 4; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE4, toggleChecked4);
                editor.apply();
            }
        });
        defaultToggleButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked5 = defaultToggleButton5.isChecked();
                latestCheckedTogglePosition = 5; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE5, toggleChecked5);
                editor.apply();
            }
        });

        defaultToggleButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked6 = defaultToggleButton6.isChecked();
                latestCheckedTogglePosition = 6; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE6, toggleChecked6);
                editor.apply();
            }
        });

        defaultToggleButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked7 = defaultToggleButton7.isChecked();
                latestCheckedTogglePosition = 7; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE7, toggleChecked7);
                editor.apply();
            }
        });
        defaultToggleButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked8 = defaultToggleButton8.isChecked();
                latestCheckedTogglePosition = 8; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE8, toggleChecked8);
                editor.apply();
            }
        });
        defaultToggleButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked9 = defaultToggleButton9.isChecked();
                latestCheckedTogglePosition = 9; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE9, toggleChecked9);
                editor.apply();
            }
        });
        defaultToggleButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked10 = defaultToggleButton10.isChecked();
                latestCheckedTogglePosition = 10; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE10, toggleChecked10);
                editor.apply();
            }
        });
        defaultToggleButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked11 = defaultToggleButton11.isChecked();
                latestCheckedTogglePosition = 11; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE11, toggleChecked11);
                editor.apply();
            }
        });
        defaultToggleButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked12 = defaultToggleButton12.isChecked();
                latestCheckedTogglePosition = 12; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE12, toggleChecked12);
                editor.apply();
            }
        });
        defaultToggleButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked13 = defaultToggleButton13.isChecked();
                latestCheckedTogglePosition = 13; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE13, toggleChecked13);
                editor.apply();
            }
        });
        defaultToggleButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked14 = defaultToggleButton14.isChecked();
                latestCheckedTogglePosition = 14; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE14, toggleChecked14);
                editor.apply();
            }
        });
        defaultToggleButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked15 = defaultToggleButton15.isChecked();
                latestCheckedTogglePosition = 15; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE15, toggleChecked15);
                editor.apply();
            }
        });
        defaultToggleButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked16 = defaultToggleButton16.isChecked();
                latestCheckedTogglePosition = 16; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE16, toggleChecked16);
                editor.apply();
            }
        });
        defaultToggleButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked17 = defaultToggleButton17.isChecked();
                latestCheckedTogglePosition = 17; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE17, toggleChecked17);
                editor.apply();
            }
        });
        defaultToggleButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleChecked18 = defaultToggleButton18.isChecked();
                latestCheckedTogglePosition = 18; // Update the latest checked toggle position
                SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(TOGGLE_STATE18, toggleChecked18);
                editor.apply();
            }
        });

        // Retrieve the toggle state from SharedPreferences
        SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
        toggleChecked = prefs.getBoolean(TOGGLE_STATE, false);
        toggleChecked2 = prefs.getBoolean(TOGGLE_STATE2, false);
        toggleChecked3 = prefs.getBoolean(TOGGLE_STATE3, false);
        toggleChecked4 = prefs.getBoolean(TOGGLE_STATE4, false);
        toggleChecked5 = prefs.getBoolean(TOGGLE_STATE5, false);
        toggleChecked6 = prefs.getBoolean(TOGGLE_STATE6, false);
        toggleChecked7 = prefs.getBoolean(TOGGLE_STATE7, false);
        toggleChecked8 = prefs.getBoolean(TOGGLE_STATE8, false);
        toggleChecked9 = prefs.getBoolean(TOGGLE_STATE9, false);
        toggleChecked10 = prefs.getBoolean(TOGGLE_STATE10, false);
        toggleChecked11 = prefs.getBoolean(TOGGLE_STATE11, false);
        toggleChecked12 = prefs.getBoolean(TOGGLE_STATE12, false);
        toggleChecked13 = prefs.getBoolean(TOGGLE_STATE13, false);
        toggleChecked14 = prefs.getBoolean(TOGGLE_STATE14, false);
        toggleChecked15 = prefs.getBoolean(TOGGLE_STATE15, false);
        toggleChecked16 = prefs.getBoolean(TOGGLE_STATE16, false);
        toggleChecked17 = prefs.getBoolean(TOGGLE_STATE17, false);
        toggleChecked18 = prefs.getBoolean(TOGGLE_STATE18, false);

        // Update the toggle buttons with the retrieved toggle states
        defaultToggleButton.setChecked(toggleChecked);
        defaultToggleButton2.setChecked(toggleChecked2);
        defaultToggleButton3.setChecked(toggleChecked3);
        defaultToggleButton4.setChecked(toggleChecked4);
        defaultToggleButton5.setChecked(toggleChecked5);
        defaultToggleButton6.setChecked(toggleChecked6);
        defaultToggleButton7.setChecked(toggleChecked7);
        defaultToggleButton8.setChecked(toggleChecked8);
        defaultToggleButton9.setChecked(toggleChecked9);
        defaultToggleButton10.setChecked(toggleChecked10);
        defaultToggleButton11.setChecked(toggleChecked11);
        defaultToggleButton12.setChecked(toggleChecked12);
        defaultToggleButton13.setChecked(toggleChecked13);
        defaultToggleButton14.setChecked(toggleChecked14);
        defaultToggleButton15.setChecked(toggleChecked15);
        defaultToggleButton16.setChecked(toggleChecked16);
        defaultToggleButton17.setChecked(toggleChecked17);
        defaultToggleButton18.setChecked(toggleChecked18);


        //utk display data current user
//        fbutracker = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = fbutracker.getUid();
//
//        dbtracker = FirebaseDatabase.getInstance().getReference("users").child("Profile");
//        dbtracker.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
//            public void onDataChange(DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    toggleChecked = getBooleanValue(snapshot, TOGGLE_STATE);
//                    toggleChecked2 = getBooleanValue(snapshot, TOGGLE_STATE2);
//                    toggleChecked3 = getBooleanValue(snapshot, TOGGLE_STATE3);
//                    toggleChecked4 = getBooleanValue(snapshot, TOGGLE_STATE4);
//                    toggleChecked5 = getBooleanValue(snapshot, TOGGLE_STATE5);
//                    toggleChecked6 = getBooleanValue(snapshot, TOGGLE_STATE6);
//                    toggleChecked7 = getBooleanValue(snapshot, TOGGLE_STATE7);
//                    toggleChecked8 = getBooleanValue(snapshot, TOGGLE_STATE8);
//                    toggleChecked9 = getBooleanValue(snapshot, TOGGLE_STATE9);
//                    toggleChecked10 = getBooleanValue(snapshot, TOGGLE_STATE10);
//                    toggleChecked11 = getBooleanValue(snapshot, TOGGLE_STATE11);
//                    toggleChecked12 = getBooleanValue(snapshot, TOGGLE_STATE12);
//                    toggleChecked13 = getBooleanValue(snapshot, TOGGLE_STATE13);
//                    toggleChecked14 = getBooleanValue(snapshot, TOGGLE_STATE14);
//                    toggleChecked15 = getBooleanValue(snapshot, TOGGLE_STATE15);
//                    toggleChecked16 = getBooleanValue(snapshot, TOGGLE_STATE16);
//                    toggleChecked17 = getBooleanValue(snapshot, TOGGLE_STATE17);
//                    toggleChecked18 = getBooleanValue(snapshot, TOGGLE_STATE18);
//                    // Retrieve other toggle state values in a similar manner
//
//                    // Update the toggle buttons with the retrieved toggle states
//                    defaultToggleButton.setChecked(toggleChecked);
//                    defaultToggleButton2.setChecked(toggleChecked2);
//                    defaultToggleButton3.setChecked(toggleChecked3);
//                    defaultToggleButton4.setChecked(toggleChecked4);
//                    defaultToggleButton5.setChecked(toggleChecked5);
//                    defaultToggleButton6.setChecked(toggleChecked6);
//                    defaultToggleButton7.setChecked(toggleChecked7);
//                    defaultToggleButton8.setChecked(toggleChecked8);
//                    defaultToggleButton9.setChecked(toggleChecked9);
//                    defaultToggleButton10.setChecked(toggleChecked10);
//                    defaultToggleButton11.setChecked(toggleChecked11);
//                    defaultToggleButton12.setChecked(toggleChecked12);
//                    defaultToggleButton13.setChecked(toggleChecked13);
//                    defaultToggleButton14.setChecked(toggleChecked14);
//                    defaultToggleButton15.setChecked(toggleChecked15);
//                    defaultToggleButton16.setChecked(toggleChecked16);
//                    defaultToggleButton17.setChecked(toggleChecked17);
//                    defaultToggleButton18.setChecked(toggleChecked18);
//                    // Update other toggle buttons in a similar manner
//                }
//            }
//            private boolean getBooleanValue(DataSnapshot snapshot, String childKey) {
//                DataSnapshot childSnapshot = snapshot.child(childKey);
//                if (childSnapshot.exists() && childSnapshot.getValue() != null) {
//                    return childSnapshot.getValue(Boolean.class);
//                } else {
//                    // Handle the case when the child value is null or doesn't exist
//                    // Return a default value or handle it accordingly
//                    return false; // For example, returning false as the default value
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Handle the error if needed
//            }
//        });

        //save button to store last checked toggle
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragmenttracker = new mytracker2();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_container,fragmenttracker).commit();

//                latestCheckedTogglePosition = prefs.getInt(LATEST_TOGGLE_POSITION, 0); // Retrieve the latest checked toggle position
//
//                SharedPreferences prefs2 = getActivity().getPreferences(Context.MODE_PRIVATE);
//                toggleChecked = prefs2.getBoolean(String.valueOf(latestCheckedTogglePosition), false);
//
//                fbutracker = FirebaseAuth.getInstance().getCurrentUser();
//                String uid2 = fbutracker.getUid(); // Assign the UID
//
//                dbtracker = FirebaseDatabase.getInstance().getReference("users").child("Profile");
//                dbtracker.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot snapshot) {
//
//                        //String lastCheckedToggle = latestCheckedTogglePosition; // Replace with the actual value of the last checked toggle
//
//                        // Store the last checked toggle value in the database
//                        dbtracker.child(uid2).child("Kiraan puasa").setValue(latestCheckedTogglePosition);

                    }

//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Handle onCancelled event
//                    }
//                });
//            }
       });

        ((MainActivity)getActivity()).setDrawer_Locked();
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((MainActivity) getActivity()).setDrawer_Unlocked();
    }

//    private void retrieveHariPuasa() {
//        // Retrieve the toggle state from SharedPreferences based on the latest toggle position
//        SharedPreferences prefs = getActivity().getPreferences(Context.MODE_PRIVATE);
//        toggleChecked = prefs.getBoolean(String.valueOf(latestCheckedTogglePosition), false);
//
//    }

}