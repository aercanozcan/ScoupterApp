package com.apptopus.scoupter;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.apptopus.scoupter.databinding.ActivityScoupterBinding;
import com.apptopus.scoupter.di.component.DaggerScoupterPresenterComponent;
import com.apptopus.scoupter.di.module.ScoupterPresenterModule;
import com.apptopus.scoupter.model.Scooter;
import com.apptopus.scoupter.presenter.ScoupterActivityContract;
import com.apptopus.scoupter.presenter.ScoupterPresenter;
import com.apptopus.scoupter.util.ColorUtils;
import com.apptopus.scoupter.util.LocationUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import javax.inject.Inject;

public class ScoupterActivity extends FragmentActivity implements OnMapReadyCallback, ScoupterActivityContract.View, ScoupterActivityContract.ActionListener {

    @Inject
    ScoupterPresenter presenter;

    private GoogleMap mMap;

    private ActivityScoupterBinding binding;


    private final LatLng BERLIN = new LatLng(52.520008, 13.404954);//Berlin <3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scoupter);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        DaggerScoupterPresenterComponent.builder()
                .scoupterPresenterModule(new ScoupterPresenterModule(this)).build().inject(this);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(BERLIN)
                .zoom(13)
                .build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        //To avoid drawing all markers at first we zoom to a location(would be changed to current location later)
        presenter.getScoters();
    }

    @Override
    public void updateMapMarkers(List<Scooter> scooters) {
        for (final Scooter scooter : scooters) {
            mMap.addMarker(new MarkerOptions()
                    .position(LocationUtils.getLatLng(scooter.getLocation()))
                    .icon(ColorUtils.getBitmapDescriptorFromPercent(scooter.getEnergyLevel())))
                    .setTag(scooter);//might need later
        }
    }

    @Override
    public void onMapCameraChanged() {

    }

    @Override
    public void hideProgressSpinner() {
        binding.progressBar.setVisibility(View.GONE);
    }
}
