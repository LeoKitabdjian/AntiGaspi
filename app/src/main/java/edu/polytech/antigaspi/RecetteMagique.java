package edu.polytech.antigaspi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
