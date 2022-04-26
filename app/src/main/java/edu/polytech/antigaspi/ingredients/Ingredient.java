package edu.polytech.antigaspi.ingredients;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Ingredient implements Parcelable {
    private String nom;

    public Ingredient(String nom) {
        this.nom = nom;
    }

    protected Ingredient(Parcel in) {
        nom = in.readString();
    }

    public String getNom() {
        return nom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
    }
}
