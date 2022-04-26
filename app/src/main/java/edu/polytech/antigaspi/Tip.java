package edu.polytech.antigaspi;

import android.os.Parcel;
import android.os.Parcelable;

public class Tip implements Parcelable {
    private String IngredientName;
    private String ContenuTip;

    public Tip(String IngredientName, String ContenuTip) {
        this.IngredientName = IngredientName;
        this.ContenuTip = ContenuTip;
    }

    protected Tip(Parcel in) {
        IngredientName = in.readString();
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

    public String getIngredientName() {
        return IngredientName;
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
        dest.writeString(IngredientName);
        dest.writeString(ContenuTip);
    }
}
