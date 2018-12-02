package com.example.a1.campr;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class User {
    public String userID;
    public String userName;
    public String userCity;
    public String userEmail;
    public String userContact;
    public ArrayList<Pets> chosenPets; //adopter
    public ArrayList<Pets> listedPets; //lister
    public Set<String> swipedPets;     //adopter
    public HashMap<String, String> appliedPets; //adopter   petID - (applied, approved, declined)
    //public ArrayList<Pair<String, String>> myApplicants;

    public User(String mID) {
        userID = mID;
        userName = "John Doe";
        chosenPets = new ArrayList<Pets>();
        listedPets = new ArrayList<Pets>();
        swipedPets = new HashSet<>();
        appliedPets = new HashMap<>();
        //myApplicants = new ArrayList<Pair<String, String>>();
    }
}
