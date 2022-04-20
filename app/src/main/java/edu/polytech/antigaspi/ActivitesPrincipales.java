package edu.polytech.antigaspi;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public abstract class ActivitesPrincipales extends AppCompatActivity {

    public void createLinks() {
        findViewById(R.id.navigation_bar_frigo).setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MonFrigo.class);
            startActivity(intent);
        });
        findViewById(R.id.navigation_bar_astuces).setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RechercheAstuce.class);
            startActivity(intent);
        });
        findViewById(R.id.navigation_bar_home).setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.navigation_bar_map).setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RechercheAssociation.class);
            startActivity(intent);
        });
        findViewById(R.id.navigation_bar_recette).setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RecetteMagique.class);
            startActivity(intent);
        });
    }

}
