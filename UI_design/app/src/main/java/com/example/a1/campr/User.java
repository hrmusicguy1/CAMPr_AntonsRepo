package com.example.a1.campr;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class User {
    public String userID;
    public String userName;
    public ArrayList<Pets> chosenPets; //adaptor
    public ArrayList<Pets> listedPets; //lister
    public Set<String> swipedPets;     //adaptor
    //public ArrayList<Pair<String, String>> myApplicants;

    public User(String mID) {
        userID = mID;
        userName = "John Doe";
        chosenPets = new ArrayList<Pets>();
        listedPets = new ArrayList<Pets>();
        swipedPets = new HashSet<>();
        //myApplicants = new ArrayList<Pair<String, String>>();
    }
}
