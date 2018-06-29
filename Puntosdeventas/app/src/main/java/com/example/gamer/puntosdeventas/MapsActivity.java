package com.example.gamer.puntosdeventas;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gamer.puntosdeventas.entidades.PuntodeVenta;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener{

    private GoogleMap mMap;
    private Marker mimarker;
    private PuntodeVenta pv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        Bundle objetoenviado = getIntent().getExtras();
        //PuntodeVenta pv = null;
        if (objetoenviado!=null){
            pv= (PuntodeVenta)objetoenviado.getSerializable("puntoventa");
        }
       /* LatLng peru = new LatLng(pv.getPv_latitud(), pv.getPv_longitud());
        mMap.addMarker(new MarkerOptions().position(peru).title(pv.getPv_nombre()));
        */
        LatLng prueba= new LatLng(pv.getPv_latitud(), pv.getPv_longitud());
        mimarker=googleMap.addMarker(new MarkerOptions().position(prueba).title(pv.getPv_nombre()));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(prueba,18));
        mMap.getUiSettings().setZoomControlsEnabled(true);

        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.e("ERROR","ENTRO");
        if(marker.equals(mimarker)){
            Intent i = new Intent(MapsActivity.this,ListaProductoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("puntoventamapa",pv);
            i.putExtras(bundle);
            startActivity(i);
        }
        return false;
    }
}
