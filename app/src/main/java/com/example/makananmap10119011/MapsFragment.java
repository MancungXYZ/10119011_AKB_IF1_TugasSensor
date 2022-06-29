package com.example.makananmap10119011;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
//Identitas
//Nama  : Reihan Wiyanda
//Nim   : 10119011
//Kelas : IF-1
public class MapsFragment extends Fragment {

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
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bude, 13.0F));
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
}