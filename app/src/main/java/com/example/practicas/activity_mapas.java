package com.example.practicas;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class activity_mapas extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng guatemala = new LatLng(14.5963162, -90.5160369);
        mMap.addMarker(new MarkerOptions().position(guatemala).title("Guatemala City, Banco Promerica")
                .snippet("Banco Promerica, 1a Avenida Calzada Roosevelt 34-38").icon(BitmapDescriptorFactory.fromResource(R.drawable.localization)));

        LatLng naranjo = new LatLng(14.646044, -90.5388577);
        mMap.addMarker(new MarkerOptions().position(naranjo).title("Guatemala City, Banco Promerica")
                .snippet("Bulevar El Naranjo 36, Cdad. de Guatemala").icon(BitmapDescriptorFactory.fromResource(R.drawable.localization)));

        LatLng ciudad = new LatLng(14.6216205, -90.552901);
        mMap.addMarker(new MarkerOptions().position(ciudad).title("Guatemala City, Centro Comercial Miraflores")
                .snippet("22 Avenida 170, Cdad. de Guatemala").icon(BitmapDescriptorFactory.fromResource(R.drawable.localization)));

        LatLng reforma = new LatLng(14.611307, -90.5146138);
        mMap.addMarker(new MarkerOptions().position(reforma).title("Guatemala City , Banco Promerica")
                .snippet("Reforma 9-55 zona 10, Cdad. de Guatemala").icon(BitmapDescriptorFactory.fromResource(R.drawable.localization)));

        LatLng unicentro = new LatLng(14.5922686, -90.5123197);
        mMap.addMarker(new MarkerOptions().position(unicentro).title("Guatemala City Unicentro, Banco Promerica")
                .snippet("20 calle 534, Cdad. de Guatemala").icon(BitmapDescriptorFactory.fromResource(R.drawable.localization)));

        LatLng Bulevar = new LatLng(14.6073244, -90.4859061);
        mMap.addMarker(new MarkerOptions().position(Bulevar).title("Guatemala City La Playa, Banco Promerica")
                .snippet("Bulevar Rafael Landivar 10, Cdad. de Guatemala").icon(BitmapDescriptorFactory.fromResource(R.drawable.localization)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(guatemala, 15));
    }
}
