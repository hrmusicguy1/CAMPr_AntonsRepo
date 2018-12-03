package com.example.a1.campr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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
                TextView email_account = findViewById(R.id.emial);
                String email = email_account.getText().toString();
                if(email.equals("hsociety@gmail.com")) {
                    test1();
                    Intent intent = new Intent(LoginActivity.this, workmodeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(email.equals("klalova@ucsd.edu")) {
                    test2();
                    Intent intent = new Intent(LoginActivity.this, workmodeActivity.class);
                    startActivity(intent);
                    finish();
                }
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
        test1.setVisibility(View.GONE);
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
        test2.setVisibility(View.GONE);
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
        test3.setVisibility(View.GONE);
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearTest();
                runTest();
                currentUser = 2;

                PetsFragment.input = myData.dataUsers.get(2).listedPets;
                for (Pets pet : myData.dataUsers.get(2).listedPets) {
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
        user1.userName = "Humane Society";
        user1.userCity = "San Diego";
        user1.userEmail = "DEMO_1@email.com";
        user1.userContact = "Humane Society\nhsociety@gmail.com\n555-228-4545\nCall between 8am - 4pm";


        Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet1);
        user1.listedPets.add(new Pets("Kitty", "Female", "Just a cat", "p1", "0", pic, "Cats", 0, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet2);
        user1.listedPets.add(new Pets("Fugly", "Female", "Ugliest dog alive", "p2", "0", pic,"Dogs", 2, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet3);
        user1.listedPets.add(new Pets("Mr. Coon", "Male", "Sixth college student", "p3", "0", pic, "Other", 5, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet4);
        user1.listedPets.add(new Pets("Snaky", "Male", "Bites to death", "p4", "0", pic, "Reptiles", 11, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet5);
        user1.listedPets.add(new Pets("Eagle", "Male", "City bum", "p5", "0", pic, "Other", 4, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet6);
        user1.listedPets.add(new Pets("Alarm clock", "Male", "Cocky bastard", "p6", "0", pic, "Other", 9, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet7);
        user1.listedPets.add(new Pets("Lizzy", "Female", "Eats bugs and sells car insurance", "p7", "0", pic, "Reptiles", 1, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.rep1);
        user1.listedPets.add(new Pets("Venom", "Female", "Definitely not venomous!", "p8", "0", pic, "Reptiles", 0, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.rep2);
        user1.listedPets.add(new Pets("Verde", "Male", "Friendly little green guy (not weed!)", "p9", "0", pic, "Reptiles", 0, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.rep3);
        user1.listedPets.add(new Pets("Camile", "Female", "Once you adopt me you'll never see me again", "p10", "0", pic, "Reptiles", 3, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.rep4);
        user1.listedPets.add(new Pets("Rob", "Male", "I <3 Camile", "p11", "0", pic, "Reptiles", 2, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.rep5);
        user1.listedPets.add(new Pets("Iggy", "Female", "Iggy Azalea's cousin", "p12", "0", pic, "Reptiles", 7, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.other1);
        user1.listedPets.add(new Pets("Squee", "Female", "Big nut fan", "p13", "0", pic, "Other", 2, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.other2);
        user1.listedPets.add(new Pets("Miriam", "Female", "Tests cigarettes", "p14", "0", pic, "Other", 12, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.other3);
        user1.listedPets.add(new Pets("Stripie", "Male", "Requires a large yard", "p15", "0", pic, "Other", 8, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.other4);
        user1.listedPets.add(new Pets("Berry the bear", "Male", "Loves to play with butterflies", "p16", "0", pic, "Other", 6, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.other5);
        user1.listedPets.add(new Pets("Gavin", "Male", "Poor balance but friendly", "p17", "0", pic, "Other", 4, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.other6);
        user1.listedPets.add(new Pets("Charlotte", "Female", "Makes breakfast", "p18", "0", pic, "Other", 1, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.dog1);
        user1.listedPets.add(new Pets("Penny", "Female", "Show dog", "p19", "0", pic, "Dogs", 3, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.dog2);
        user1.listedPets.add(new Pets("Joseph", "Male", "Holds great conversations", "p20", "0", pic, "Dogs", 7, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.dog3);
        user1.listedPets.add(new Pets("Thunder", "Female", "Loud and annoying", "p21", "0", pic, "Dogs", 3, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.dog4);
        user1.listedPets.add(new Pets("Kim Corgdashian", "Female", "Show dog", "p22", "0", pic, "Dogs", 6, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.dog5);
        user1.listedPets.add(new Pets("Bubbles", "Male", "Loves baths", "p23", "0", pic, "Dogs", 4, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.cat1);
        user1.listedPets.add(new Pets("Rusty", "Male", "Lazy, fat and judgemental", "p24", "0", pic, "Cats", 5, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.cat2);
        user1.listedPets.add(new Pets("Toothless", "Female", "Part-time dragon", "p25", "0", pic, "Cats", 4, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.cat3);
        user1.listedPets.add(new Pets("Reggie", "Male", "Eats dog food", "p26", "0", pic, "Cats", 3, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.cat5);
        user1.listedPets.add(new Pets("Levi", "Male", "Levitates towards food", "p27", "0", pic, "Cats", 8, "Free", user1.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.cat6);
        user1.listedPets.add(new Pets("Blinky", "Male", "Does not blink", "p28", "0", pic, "Cats", 10, "Free", user1.userCity));





        User user4 = myData.dataUsers.get(3);
        user4.userName = "ALF";
        user4.userContact = "555-123-9876\nCall me anytime";
        user4.userCity = "San Diego";
        user4.userEmail = "alf@gmail.com";

        User user5 = myData.dataUsers.get(4);
        user5.userName = "Donald Trump";
        user5.userContact = "555-123-9876\nCall me anytime";
        user5.userCity = "San Diego";
        user5.userEmail = "dtrump@gmail.com";

        //create lister with 2 animals listed
        User user2 = myData.dataUsers.get(1);
        user2.userName = "John McLain";
        user2.userCity = "San Diego";
        user2.userEmail = "DEMO_2@email.com";
        user2.userContact = "Jooh McLain\njohnmc@mail.ru\n555-888-2323\nCall anytime";
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet8);
        user2.listedPets.add(new Pets("McFly", "Male", "Attracted to shit", "p29", "1", pic, "Other", 0, "Free", user2.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet9);
        user2.listedPets.add(new Pets("Grizzly", "Male", "Just a panda", "p30", "1", pic, "Other", 4, "Free", user2.userCity));
        pic = BitmapFactory.decodeResource(getResources(), R.drawable.pet10);
        user2.listedPets.add(new Pets("Ratatouille", "Male", "Chef", "p31", "1", pic, "Other", 0, "No fee", user2.userCity));

        //create lister with 1 animal listed

        User user3 = myData.dataUsers.get(2);
        user3.userName = "Kalina Lalova";
        user3.userContact = "Kalina Lalova\nklalova@ucsd.edu\n111-111-1111\nCall me whenever";
        user3.userCity = "San Diego";
        user3.userEmail = "klalova@ucsd.edu";


        user1.listedPets.get(0).applicantId.put("2", "I love cats!!!");
        user1.listedPets.get(0).applicantId.put("1", "Give me this cat!");
        user1.listedPets.get(0).applicantId.put("3", "I will take good care of her");
        user1.listedPets.get(1).applicantId.put("4", "It kinda looks like me");
        user1.listedPets.get(2).applicantId.put("1", "We have the same classes");




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

    public void test1() {
        clearTest();
        runTest();
        currentUser = 0;

        PetsFragment.input = myData.dataUsers.get(0).listedPets;
        for (Pets pet : myData.dataUsers.get(0).listedPets) {
            PetsFragment.myPets.put(pet.getPetId(), pet);
        }
    }

    public void test2() {
        clearTest();
        runTest();
        currentUser = 2;

        PetsFragment.input = myData.dataUsers.get(2).listedPets;
        for (Pets pet : myData.dataUsers.get(2).listedPets) {
            PetsFragment.myPets.put(pet.getPetId(), pet);
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
