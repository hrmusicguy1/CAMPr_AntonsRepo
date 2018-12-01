package com.example.a1.campr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    public static ThirdBase myData = new ThirdBase();
    public static int currentUser;

    //private Button mLogin;
    //private TextView mToregister;
    //private TextView mreset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button mLogin = (Button) findViewById(R.id.login);
        TextView mreset = (TextView) findViewById(R.id.reset);
        TextView mToregister = (TextView) findViewById(R.id.torigister);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, workmodeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, resetActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mToregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //test1 - log you in as a lister with 7 animals listed
        Button test1 = findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearTest();
                runTest();
                currentUser = 0;


                //log in as lister with 7 animals and load lister data from database to local variables
                PetsFragment.input = myData.dataUsers.get(0).listedPets;
                for (Pets pet : myData.dataUsers.get(0).listedPets) {
                    PetsFragment.myPets.put(pet.getPetId(), pet);
                }

            }
        });

        //test2 - logs you in as an adopter
        Button test2 = findViewById(R.id.test2);
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearTest();
                runTest();
                currentUser = 3;
            }
        });

        //test3 - logs you in as a lister with 1 animal listed
        Button test3 = findViewById(R.id.test3);
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearTest();
                runTest();
                currentUser = 2;

                PetsFragment.input = myData.dataUsers.get(1).listedPets;
                for (Pets pet : myData.dataUsers.get(1).listedPets) {
                    PetsFragment.myPets.put(pet.getPetId(), pet);
                }
            }
        });

    }
    public void runTest() {
        //create database with 5 users
        for (int i = 0; i<5; i++) {
            myData.dataUsers.add(new User(Integer.toString(i)));
        }

        //create a lister with 7 animals listed
        User user1 = myData.dataUsers.get(0);
        Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet1);
        user1.listedPets.add(new Pets("Kitty", "Female", "Just a cat", "p1", "0", pic));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet2);
        user1.listedPets.add(new Pets("Fugly", "Female", "Ugliest dog alive", "p2", "0", pic));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet3);
        user1.listedPets.add(new Pets("Mr. Coon", "Male", "Sixth college student", "p3", "0", pic));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet4);
        user1.listedPets.add(new Pets("Snaky", "Unknown", "Bites to death", "p4", "0", pic));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet5);
        user1.listedPets.add(new Pets("Eagle", "Male", "City bum", "p5", "0", pic));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet6);
        user1.listedPets.add(new Pets("Alarm clock", "Male", "Cocky bastard", "p6", "0", pic));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet7);
        user1.listedPets.add(new Pets("Lizzy", "Female", "Eats bugs and sells car insurance", "p7", "0", pic));

        user1.listedPets.get(0).applicantId.put("2", "hello");
        LoginActivity.myData.dataUsers.get(1).userName = "Test 2";
        LoginActivity.myData.dataUsers.get(2).userName = "Anton";
        LoginActivity.myData.dataUsers.get(3).userName = "Test 4";
        LoginActivity.myData.dataUsers.get(4).userName = "Test 5";


        //create lister with 2 animals listed
        User user2 = myData.dataUsers.get(1);
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet8);
        user2.listedPets.add(new Pets("McFly", "Male", "Attracted to shit", "p8", "1", pic));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet9);
        user2.listedPets.add(new Pets("Grizzly", "Male", "Just a panda", "p9", "1", pic));

        //create lister with 1 animal listed
        User user3 = myData.dataUsers.get(2);
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet10);
        user3.listedPets.add(new Pets("Ratatouille", "Male", "Chef", "p10", "2", pic));


        //load all listed animals from all existing listers to local variable; skip the ones that were previously swiped
        for(User u : myData.dataUsers) {
            if (u.listedPets.size() > 0) {
                for (Pets p : u.listedPets) {
                    if (LoginActivity.myData.dataUsers.get(LoginActivity.currentUser).swipedPets.contains(p.getPetId())) {
                        continue;
                    }
                    AdopterActivity.adoptionPets.add(p);
                }
            }
        }
    }

    public void clearTest() {
        myData.dataUsers.clear();
        PetsFragment.input.clear();
        AdopterActivity.adoptionPets.clear();
        PetsFragment.myPets.clear();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
