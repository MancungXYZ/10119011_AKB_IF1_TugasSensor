package com.example.makananmap10119011;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

//Identitas
//Nama  : Reihan Wiyanda
//Nim   : 10119011
//Kelas : IF-1
public class PetaFragmen extends Fragment {
    private FusedLocationProviderClient client;
    private SupportMapFragment mapFragment;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng Bude = new LatLng(-6.886445022750337, 107.61753119497389);
            LatLng Gokana = new LatLng(-6.893771418418906, 107.60569530468088);
            LatLng Bebek = new LatLng(-6.891923811064537, 107.616765035);
            LatLng Steak = new LatLng(-6.890193668498541, 107.61623594751403);
            LatLng Add = new LatLng(-6.886106290664078, 107.61495205407499);
            googleMap.addMarker(new MarkerOptions().position(Bude).title("Warung Makan Bu karsi/Bude!"));
            googleMap.addMarker(new MarkerOptions().position(Gokana).title("Gokana Ramen & Teppan Ciwalk"));
            googleMap.addMarker(new MarkerOptions().position(Bebek).title("Bebek Ali Borme"));
            googleMap.addMarker(new MarkerOptions().position(Steak).title("Waroeng Steak & Shake Dipatiukur"));
            googleMap.addMarker(new MarkerOptions().position(Add).title("Warkop Add"));
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            client = LocationServices.getFusedLocationProviderClient(getActivity());
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bude, 13.0F));
            mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
            getCurrentLocation();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    private void getCurrentLocation() {

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        client = LocationServices.getFusedLocationProviderClient(getActivity());

//        LocationManager locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
//        Location lastKnownLocation = locationManager.getLastKnownLocation(locationManager);

        client.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            Log.e("Last Location: ", location.toString());
                            LatLng currentLoc = new LatLng(location.getLatitude(), location.getLongitude());
                            googleMap.addMarker(new MarkerOptions().position(currentLoc).title("Lokasi anda saat ini"));
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLoc, 17));
                        }
                    });

                }
            }
        });
    }



}