package edu.polytech.antigaspi.mainActivities;

import android.os.Bundle;

import edu.polytech.antigaspi.R;

public class RechercheAstuce extends ActivitesPrincipales {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_astuce);
        createLinks();
    }
}
