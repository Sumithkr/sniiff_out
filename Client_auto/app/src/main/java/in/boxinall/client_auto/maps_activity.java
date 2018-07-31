package in.boxinall.client_auto;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class maps_activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_layout);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toast.makeText(getApplicationContext(),"Completed", Toast.LENGTH_SHORT).show();
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng basic = new LatLng(13.3586592, 80.14399300000001);
        mMap.addMarker(new MarkerOptions().position(basic));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        CameraUpdate center= CameraUpdateFactory.newLatLng(new LatLng(13.3586592, 80.14399300000001));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(17);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }
}
