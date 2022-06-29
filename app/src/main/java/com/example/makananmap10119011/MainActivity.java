package com.example.makananmap10119011;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
//Identitas
//Nama  : Reihan Wiyanda
//Nim   : 10119011
//Kelas : IF-1
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    PetaFragmen petaFragmen = new PetaFragmen();
    SettingFragment settingFragment = new SettingFragment();
    Aplikasi aplikasi = new Aplikasi();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, petaFragmen).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, petaFragmen).commit();
                        return true;

                    case R.id.tentang:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, settingFragment).commit();
                        return true;

                    case R.id.aplikasi:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, aplikasi).commit();
                        return true;
                }

                return false;
            }
        });


    }
}