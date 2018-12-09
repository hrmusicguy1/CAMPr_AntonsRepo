package com.example.a1.campr;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.a1.campr.fragments.AddNewFragment;
import com.example.a1.campr.fragments.ApplicationFragment;
import com.example.a1.campr.fragments.EditAdopterProfileFragment;
import com.example.a1.campr.fragments.EditListerProfileFragment;
import com.example.a1.campr.fragments.PetsFragment;
import com.example.a1.campr.fragments.SwipeCardsFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class ListerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseRef = mDatabase.getReference();

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            mDatabaseRef.child("listers/" + mFirebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() == null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EditListerProfileFragment()).commit();
                        navigationView.setCheckedItem(R.id.nav_profile);
                    } else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new PetsFragment()).commit();
                        navigationView.setCheckedItem(R.id.nav_pets);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // do nothing
                }
            });
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDatabaseRef.child("listers/" + mFirebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null) {
                    Toast.makeText(ListerActivity.this, "Please complete your profile first", Toast.LENGTH_LONG).show();
                } else {
                    NavigationView navigationView = findViewById(R.id.nav_view);
                    switch (item.getItemId()) {
                        case R.id.nav_profile:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new EditListerProfileFragment()).commit();
                            navigationView.setCheckedItem(R.id.nav_profile);
                            break;
                        case R.id.nav_pets:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new PetsFragment()).commit();
                            navigationView.setCheckedItem(R.id.nav_pets);
                            break;
                        case R.id.nav_addnew:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new AddNewFragment()).commit();
                            navigationView.setCheckedItem(R.id.nav_addnew);
                            break;
                        case R.id.nav_switch:
                            Intent intent = new Intent(ListerActivity.this, WorkModeActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_signout:
                            mFirebaseAuth.signOut();
                            intent = new Intent(ListerActivity.this, LoginActivity.class);
                            startActivity(intent);
                            break;
                    }
                    drawer.closeDrawer(GravityCompat.START);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // do nothing
            }
        });

        return true;
    }

    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
