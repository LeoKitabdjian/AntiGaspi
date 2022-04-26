package edu.polytech.antigaspi.ingredients;

import android.os.Parcel;

public class SaltIngredient extends Ingredient {

    public SaltIngredient(String nom) {
        super(nom);
    }

    protected SaltIngredient(Parcel in) {
        super(in);
    }

    public static final Creator<SaltIngredient> CREATOR = new Creator<SaltIngredient>() {
        @Override
        public SaltIngredient createFromParcel(Parcel parcel) {
            return new SaltIngredient(parcel);
        }

        @Override
        public SaltIngredient[] newArray(int i) {
            return new SaltIngredient[i];
        }
    };
}
