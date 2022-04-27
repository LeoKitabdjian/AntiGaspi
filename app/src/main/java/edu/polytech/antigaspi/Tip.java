package edu.polytech.antigaspi;

import android.os.Parcel;
import android.os.Parcelable;

import edu.polytech.antigaspi.ingredients.Ingredient;
import edu.polytech.antigaspi.ingredients.SaltIngredient;

public class Tip implements Parcelable {
    private Ingredient ingredient;
    private String ContenuTip;

    public Tip(Ingredient IngredientName, String ContenuTip) {
        this.ingredient = IngredientName;
        this.ContenuTip = ContenuTip;
    }

    protected Tip(Parcel in) {
        ingredient = new SaltIngredient(in.readString());
        ContenuTip = in.readString();
    }

    public static final Creator<Tip> CREATOR = new Creator<Tip>() {
        @Override
        public Tip createFromParcel(Parcel in) {
            return new Tip(in);
        }

        @Override
        public Tip[] newArray(int size) {
            return new Tip[size];
        }
    };

    public Ingredient getIngredient() {
        return ingredient;
    }

    public String getContenuTip() {
        return ContenuTip;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ingredient.toString());
        dest.writeString(ContenuTip);
    }
}
