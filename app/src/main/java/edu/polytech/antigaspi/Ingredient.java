package edu.polytech.antigaspi;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable {
    private String nom;
    private int quantite;

    public Ingredient(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }

    protected Ingredient(Parcel in) {
        nom = in.readString();
        quantite = in.readInt();
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeInt(quantite);
    }
}
