package com.example.puasaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    Context context;

    int Private_mode = 0;
    private static final String PREF_NAME = "AndroidLivePref";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";


    public SessionManager (Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Private_mode);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String email, String password){
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PASSWORD,password);
        editor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }


    public HashMap<String, String> getUserDetails(){
        HashMap<String , String > user = new HashMap<String, String >();
        user.put(KEY_EMAIL, sharedPreferences.getString(KEY_EMAIL, null));
        user.put(KEY_PASSWORD, sharedPreferences.getString(KEY_PASSWORD, null));

        return user;
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(context, MainActivity.class); // Change BinaProfil.class to MainActivity.class
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(i);
    }



}

