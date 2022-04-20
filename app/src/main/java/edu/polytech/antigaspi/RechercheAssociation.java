package edu.polytech.antigaspi;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
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

public class RechercheAssociation extends AppCompatActivity {
    private MapView map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        setContentView(R.layout.recherche_association);
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        GeoPoint startPoint = new GeoPoint(43.615221,7.072744);
        IMapController mapController = map.getController();
        mapController.setZoom(18.0);
        mapController.setCenter(startPoint);

        ArrayList<OverlayItem> items = new ArrayList<>();
        OverlayItem home = new OverlayItem("Nom de l'association 1","Description de l'association 1",new GeoPoint(43.605221,7.062744));
        Drawable m = home.getMarker(0);
        items.add(home);
        items.add(new OverlayItem("Nom de l'association 2","Description de l'association 2",new GeoPoint(43.625221,7.082744)));
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
}
