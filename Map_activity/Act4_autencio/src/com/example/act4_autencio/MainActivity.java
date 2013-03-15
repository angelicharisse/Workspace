package com.example.act4_autencio;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.os.Bundle;
import android.graphics.drawable.Drawable;

public class MainActivity extends MapActivity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     // Displaying Zooming controls
        MapView mapView = (MapView) findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        
        MapController mc = mapView.getController();
        double lat = Double.parseDouble("10.35410"); // latitude
        double lon = Double.parseDouble("123.91145"); // longitude
        GeoPoint geoPoint = new GeoPoint((int)(lat * 1E6), (int)(lon * 1E6));
        mc.animateTo(geoPoint);
        mc.setZoom(15);
        mapView.invalidate();
        
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.marker);
        AddItemizedOverlay itemizedOverlay =
        new AddItemizedOverlay(drawable, this);
         
        OverlayItem overlayitem = new OverlayItem(geoPoint, "Hello", "Talamban Campus");
         
        itemizedOverlay.addOverlay(overlayitem);
        mapOverlays.add(itemizedOverlay);
    }
 
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
    
}
