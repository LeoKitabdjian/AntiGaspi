package edu.polytech.antigaspi.mainActivities;

import static edu.polytech.antigaspi.ApplicationTip.TIP;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

import edu.polytech.antigaspi.R;
import edu.polytech.antigaspi.IListner;
import edu.polytech.antigaspi.Tip;
import edu.polytech.antigaspi.TipActivity;
import edu.polytech.antigaspi.Tips;
import edu.polytech.antigaspi.TipsAdapter;

public class RechercheAstuce extends ActivitesPrincipales implements IListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_astuce);
        createLinks(R.mipmap.tip_icon, "Recherche d'astuces");
        Tips tips = new Tips();

        //Création et initialisation de l'Adapter pour les tip
        TipsAdapter adapter = new TipsAdapter(getApplicationContext(), tips);

        //Récupération du composant ListView
        ListView list = findViewById(R.id.listView);

        //Initialisation de la liste avec les données
        list.setAdapter(adapter);

        adapter.addListener(this);
    }

    @Override
    public void onClickTip(Tip item) {
        Intent intent = new Intent( getApplicationContext(), TipActivity.class);
        intent.putExtra(TIP, (Parcelable)item);
        startActivity(intent);
    }
}