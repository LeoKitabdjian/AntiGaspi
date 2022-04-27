package edu.polytech.antigaspi.mainActivities;


import android.Manifest;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

import edu.polytech.antigaspi.Astuce;
import edu.polytech.antigaspi.R;

public class MainActivity extends ActivitesPrincipales {
    public LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createLinks();
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
        handleGPS();
        findViewById(R.id.notif).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Astuce.class);
                startActivity(intent);
            }
        });
    }

    private void handleGPS() {

    }
}