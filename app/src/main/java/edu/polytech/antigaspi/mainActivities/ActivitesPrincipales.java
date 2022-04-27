package edu.polytech.antigaspi.mainActivities;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.polytech.antigaspi.R;

public abstract class ActivitesPrincipales extends AppCompatActivity {

    public void createLinks(int image, String text) {
        createLinks();
        ((TextView)findViewById(R.id.header_text)).setText(text);
        ((ImageView)findViewById(R.id.header_image)).setImageResource(image);
    }

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
