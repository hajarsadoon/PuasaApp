package com.example.puasaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MyDrawerController {

    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private modelProfil selectedUser; // Replace MainActivity with modelProfil
    TextView nameUser;
    ImageView picUser;
    DatabaseReference databaseReferenceProfile;
    FirebaseUser firebaseUserProfile;
    FirebaseAuth mAuth;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment initialFragment = new RuangUtama();

        // Use a FragmentTransaction to replace the container layout with the fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, initialFragment);
        fragmentTransaction.commit();

        mAuth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        View headerView = navigationView.getHeaderView(0);
        picUser = headerView.findViewById(R.id.nav_header_pic);
        nameUser = headerView.findViewById(R.id.nav_header_name);


        firebaseUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUserProfile != null) {

            String uid = firebaseUserProfile.getUid();

            databaseReferenceProfile = FirebaseDatabase.getInstance().getReference("users").child("Profile");
            databaseReferenceProfile.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    nameUser.setText(snapshot.child(uid).child("Nama").getValue(String.class));

                }

                @Override
                public void onCancelled(DatabaseError error) {

                }
            });

            DatabaseReference getImage = databaseReferenceProfile.child(uid).child("Avatar");

            getImage.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    String imageUri = snapshot.getValue(String.class);
                    Picasso.get().load(imageUri).into(picUser);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Toast.makeText(MainActivity.this, "Error Loading Image", Toast.LENGTH_SHORT).show();

                }
            });
        }
        drawerToggle =
                new ActionBarDrawerToggle(
                        this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.RuangUtama:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RuangUtama()).commit();
                Toast.makeText(MainActivity.this, "Ruang Utama", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Profil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Profil()).commit();
                Toast.makeText(MainActivity.this, "Profil", Toast.LENGTH_SHORT).show();

                break;


            case R.id.TentangPuasa:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TentangPuasa()).commit();
                Toast.makeText(MainActivity.this, "Tentang Puasa", Toast.LENGTH_SHORT).show();

                break;

            case R.id.Sirah:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Sirah()).commit();
                Toast.makeText(MainActivity.this, "Sirah", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Sunnah:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Sunnah()).commit();
                Toast.makeText(MainActivity.this, "Makanan Sunnah", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Kuiz:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Kuiz()).commit();
                Toast.makeText(MainActivity.this, "Kuiz", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Melukis:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new testmewarna()).commit();
//                Toast.makeText(MainActivity.this, "Mewarna", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, testmewarna.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Melukis", Toast.LENGTH_SHORT).show();
                break;


            case R.id.MyTracker:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyTracker()).commit();
                Toast.makeText(MainActivity.this, "Tracker", Toast.LENGTH_SHORT).show();
                break;

            case R.id.PapanMarkah:;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PapanMarkah()).commit();
                Toast.makeText(MainActivity.this, "Papan Markah", Toast.LENGTH_SHORT).show();
                break;

            case R.id.LogKeluar:
                signOutUser();
                Toast.makeText(MainActivity.this, "Log Keluar", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void signOutUser() {
        mAuth.signOut();

        FirebaseUser firebaseUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUserProfile != null) {
            startActivity(new Intent(MainActivity.this, Splashscreen.class));
            preferences.clearData(this);

        } else {
            // Handle the case when the user is not logged in or firebaseUserProfile is null
            // For example, display a toast message or redirect the user to the login screen
            Login loginFragment = new Login();
            Intent t = new Intent(MainActivity.this, Splashscreen.class);
            preferences.clearData(this);
            startActivity(t);

        }
    }

    @Override
    public void setDrawer_Locked() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        toolbar.setNavigationIcon(null);
    }

    @Override
    public void setDrawer_Unlocked() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

}
