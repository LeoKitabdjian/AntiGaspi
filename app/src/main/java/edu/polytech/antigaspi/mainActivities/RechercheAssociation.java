package edu.polytech.antigaspi.mainActivities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.preference.PreferenceManager;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

import edu.polytech.antigaspi.R;

public class RechercheAssociation extends ActivitesPrincipales {
    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        setContentView(R.layout.recherche_association);
        createLinks();
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        GeoPoint startPoint;
        startPoint = new GeoPoint(43.615221,7.072744);
        IMapController mapController = map.getController();
        mapController.setZoom(18.0);
        mapController.setCenter(startPoint);
        handleStartPoint(mapController);
        ArrayList<OverlayItem> items = new ArrayList<>();
        OverlayItem home = new OverlayItem("Association Coup de Pouce",
                "Adresse :\n" +
                        "10 Rue du Directeur Chaudon\n" +
                        "06600, Antibes\n" +
                        "        Numéro de téléphone :\n" +
                        "04 93 61 82 04\n" +
                        "\nHoraires :" +
                        "      8h - 12h, 14h - 18h",
                new GeoPoint(43.579822,7.118646));
        Drawable m = home.getMarker(0);
        items.add(home);
        items.add(new OverlayItem("Association Les Restos du Coeur",
                "Adresse :\n" +
                        "7 Boulevard Maurice Rouvier\n" +
                        "06220, Vallauris" +
                        "\nNuméro de téléphone :\n" +
                        "09 72 44 30 45\n" +
                        "\nHoraires :" +
                        "   9h - 12h, 13h - 17h",
                new GeoPoint(43.578440,7.054838)));
        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(getApplicationContext(),
                items, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        });
        mOverlay.setFocusItemsOnTap(true);
        map.getOverlays().add(mOverlay);
    }
    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }
    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    private void handleStartPoint(IMapController map) {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.i("UPDATE", "pas de perms");
        }
        else {
            LocationListener locationListener = new LocationListener() {
                public void onLocationChanged(Location location) {
                    Log.i("UPDATE", String.valueOf(location.getLongitude()));
                    Log.i("UPDATE", String.valueOf(location.getLatitude()));
                    map.setCenter(new GeoPoint(location.getLatitude(), location.getLongitude()));
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                    Log.i("UPDATE", "status changed");
                }
            };
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
        }
    }
}
