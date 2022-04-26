package edu.polytech.antigaspi.mainActivities;

import android.os.Bundle;

import edu.polytech.antigaspi.R;

public class RecetteMagique extends ActivitesPrincipales {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recette_magique);
        createLinks();
    }

//    Intent intent = getIntent();
//    if (intent != null){
//        Ingredient ingredient = intent.getParcelableExtra("ingredient");
//        if (ingredient != null){
//
//        }
//    }
}
