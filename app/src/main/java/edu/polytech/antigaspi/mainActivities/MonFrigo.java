package edu.polytech.antigaspi.mainActivities;

import android.os.Bundle;

import edu.polytech.antigaspi.R;

public class MonFrigo extends ActivitesPrincipales {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mon_frigo);
        createLinks();
    }

//    Intent intent = new Intent(this, RecetteMagique.class);
//
//    Ingredient ingredient = new Ingredient("ingredient", 2);
//    intent.putExtra("ingredient", ingredient);
//
//    MonFrigo(intent) {
//    }
}
