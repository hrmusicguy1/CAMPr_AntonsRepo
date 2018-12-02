package com.example.a1.campr;


import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Pets implements Parcelable {
    private String name;
    private String gender;
    private String info;
    private String petId;
    private String ownerId;
    private Bitmap petPic;
    public HashMap<String, String> applicantId; //applicantID, applicationMessage
    public boolean approved;
    public boolean adopted;

    public Pets(String mName, String mGender, String mInfo, String mId, String mOwnerId, Bitmap mPic) {
        name = mName;
        gender = mGender;
        info = mInfo;
        petId = mId;
        ownerId = mOwnerId;
        petPic = mPic;
        applicantId = new HashMap<String, String>();
        approved = false;
        adopted = false;
    }

    public Pets(Parcel in) {
        name = in.readString();
        gender = in.readString();
        info = in.readString();
        petId = in.readString();
        ownerId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(info);
        dest.writeString(petId);
        dest.writeString(ownerId);
    }

    public static final Parcelable.Creator<Pets> CREATOR = new Parcelable.Creator<Pets>() {
        public Pets createFromParcel(Parcel in) {
            return new Pets(in);
        }

        public Pets[] newArray(int size) {
            return new Pets[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getInfo() {
        return info;
    }

    public String getPetId() {
        return petId;
    }

    public String getOwnerId() { return ownerId; }

    public Bitmap getPetPic() { return  petPic; }

    public void setName(String mName) {
        name = mName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }

    public void setPetPic(Bitmap petPic) {
        this.petPic = petPic;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.petId.equals(((Pets) obj).petId));
    }

}

