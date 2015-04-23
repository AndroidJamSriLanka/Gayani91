package com.test.gayaninanayakkara.hikingpal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    Marker adams_peak,horton_plains,sinharaja,knuckles,belihuloya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        setUpMapIfNeeded();
        //setMarkerClickListener(mMap);

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) { 

                if(marker.equals(sinharaja)) {
                    Intent intent = new Intent(MapsActivity.this, Sinharaja.class);
                    startActivity(intent);
                }else if (marker.equals(adams_peak)){
                    Intent intent = new Intent(MapsActivity.this, Adams_Peak.class);
                    startActivity(intent);
                }else if (marker.equals(belihuloya)){
                    Intent intent = new Intent(MapsActivity.this, Belihuloya.class);
                    startActivity(intent);
                }else if (marker.equals(horton_plains)){
                    Intent intent = new Intent(MapsActivity.this, Horton_Plains.class);
                    startActivity(intent);
                }else if (marker.equals(knuckles)){
                    Intent intent = new Intent(MapsActivity.this, Knuckles.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();

    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
                mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    public void setUpMap() {

        LatLng HORTON_PLAINS = new LatLng(6.811578,80.787887);
        horton_plains = mMap.addMarker(new MarkerOptions()
                .position(HORTON_PLAINS)
                .snippet("Latitude 6.811578,Longitude 80.787887")
                .snippet("Elevation ")
                .title("Horton Plains National Park")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng ADAMS_PEAK = new LatLng(6.810900,80.499302);
        adams_peak = mMap.addMarker(new MarkerOptions()
                .position(ADAMS_PEAK)
                .snippet("Latitude 6.810900, Longitude 80.499302")
                .title("Adams Peak")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng KNUCKLES = new LatLng(7.402632,80.80884);
        knuckles = mMap.addMarker(new MarkerOptions()
                .position(KNUCKLES)
                .snippet("Latitude 7.402632, Longitude 80.80884")
                .title("Knuckles Forest Reserve")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng SINHARAJA = new LatLng(6.390037,80.501325);
        sinharaja = mMap.addMarker(new MarkerOptions()
                .position(SINHARAJA)
                .snippet("Latitude 6.390037, Longitude 80.501325"+ "\n " +
                        "ddddd")
                .title("Sinharaja Forest Reserve")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        LatLng BELIHULOYA = new LatLng(6.715212,80.771817);
        belihuloya = mMap.addMarker(new MarkerOptions()
                .position(BELIHULOYA)
                .title("Belihuloya")
                .snippet("Latitude 6.715212 /n gggggg /n ddddd")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));



    }

}
