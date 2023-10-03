package com.example.puasaapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Kuiz extends Fragment implements View.OnClickListener {
    TextView totalQuestionstv, question;
    ImageView back9;
    Button ans1, ans2, nextQ;
    int score = 0, currentQuestionIndex = 1;
    int totalQuestions = QuestionAnswer.question.length;
    String selectedAnswer = "";
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kuiz, container, false);
        totalQuestionstv = view.findViewById(R.id.txt_numberQues);
        question = view.findViewById(R.id.tv_soalan);
        ans1 = view.findViewById(R.id.btn_ans1);
        ans2 = view.findViewById(R.id.btn_ans2);
        nextQ = view.findViewById(R.id.btn_nextQues);

        back9 = view.findViewById(R.id.iv_back9);

        back9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(requireContext(), MainActivity.class);
                startActivity(i);
            }
        });

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        nextQ.setOnClickListener(this);

        ((MainActivity)getActivity()).setDrawer_Locked();
        loadNewQuestion();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((MainActivity) getActivity()).setDrawer_Unlocked();
    }

    @Override
    public void onClick(View view) {

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.btn_nextQues) {
            if (currentQuestionIndex <= totalQuestions) {
                if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex - 1])) {
                    score++;
                }
                currentQuestionIndex++;
            }
            loadNewQuestion();
            buttonColor();
        } else {
            // Choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.GREEN);
        }
    }

    private void buttonColor(){

        ans1.setBackgroundColor(Color.WHITE);
        ans2.setBackgroundColor(Color.WHITE);
    }
    private void loadNewQuestion() {
        if (currentQuestionIndex > totalQuestions) {
            finishQuiz();
            return;
        }

        totalQuestionstv.setText(currentQuestionIndex + "/" + totalQuestions);

        // Adjust the index by subtracting 1
        question.setText(QuestionAnswer.question[currentQuestionIndex - 1]);
        ans1.setText(QuestionAnswer.choices[currentQuestionIndex - 1][0]);
        ans2.setText(QuestionAnswer.choices[currentQuestionIndex - 1][1]);
    }

    public void onScoreReceived(int score, int totalQuestions) {
        // Handle the received score here
        // Pass it to the SkorKuiz fragment or perform any other operation
        Fragment Sijil = new SkorKuiz();
        Bundle bundle = new Bundle();
        bundle.putInt("score", score);
        bundle.putInt("totalQuestions", totalQuestions);
        Sijil.setArguments(bundle);

        FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, Sijil).commit();
    }


    public interface DataListener {
        void onScoreReceived(int score, int totalQuestions);

        void onScoreReceived(int totalQuestions);
    }


    private void finishQuiz() {
        new AlertDialog.Builder(requireActivity())
                .setTitle("Kuiz tamat")
                .setMessage("Lihat markah kuiz")
                .setPositiveButton("Skor Kuiz", (dialogInterface, i) -> sijilPage())
                .setNegativeButton("Ulang Kuiz", ((dialogInterface, i) -> restartQuiz()))
                .show();

        // Save score to database
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = firebaseUser.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
                public void onDataChange(DataSnapshot snapshot) {

                databaseReference.child("Profile").child(uid).child("SkorKuiz").setValue(score);
                    }

                        @Override
                            public void onCancelled(DatabaseError error) {

                                 }

                             });

        // Pass the score to the hosting activity through the interface
        if (getActivity() instanceof DataListener) {
            DataListener dataListener = (DataListener) getActivity();
            dataListener.onScoreReceived(score);
            dataListener.onScoreReceived(totalQuestions);
        }
    }

        private void restartQuiz() {
        Fragment kuiz = new Kuiz();
        FragmentTransaction fk = getActivity().getSupportFragmentManager().beginTransaction();
            fk.replace(R.id.fragment_container,kuiz).commit();
        }
        private void sijilPage () {
            Fragment sijil = new SkorKuiz();
            FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.fragment_container,sijil).commit();
        }
    }

