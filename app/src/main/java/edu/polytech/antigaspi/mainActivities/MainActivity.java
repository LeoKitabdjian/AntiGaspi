package edu.polytech.antigaspi.mainActivities;


import static edu.polytech.antigaspi.ApplicationTip.TIP;

import android.Manifest;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import edu.polytech.antigaspi.Astuce;
import edu.polytech.antigaspi.R;
import edu.polytech.antigaspi.Tip;
import edu.polytech.antigaspi.TipActivity;
import edu.polytech.antigaspi.Tips;

public class MainActivity extends ActivitesPrincipales {
    public LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createLinks();
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
        handleGPS();
        generateRandomTip();
    }

    @Override
    protected void onResume() {
        super.onResume();
        generateRandomTip();
    }

    private void generateRandomTip() {
        Tips tips = Tips.getInstance();
        Tip tip = tips.get(new Random().nextInt(tips.size()));
        TextView todayTip = ((TextView) findViewById(R.id.todayTip));
        todayTip.setText(tip.getIngredient().getNom());
        todayTip.setOnClickListener(view -> {
            Intent intent = new Intent( getApplicationContext(), TipActivity.class);
            intent.putExtra(TIP, (Parcelable) tip);
            startActivity(intent);
        });
    }

    private void handleGPS() {

    }
}