package edu.polytech.antigaspi.ingredients;

import android.os.Parcel;

public class SweetIngredient extends Ingredient{
    public SweetIngredient(String nom) {
        super(nom);
    }

    protected SweetIngredient(Parcel in) {
        super(in);
    }

    public static final Creator<SweetIngredient> CREATOR = new Creator<SweetIngredient>() {
        @Override
        public SweetIngredient createFromParcel(Parcel parcel) {
            return new SweetIngredient(parcel);
        }

        @Override
        public SweetIngredient[] newArray(int i) {
            return new SweetIngredient[i];
        }
    };

}
