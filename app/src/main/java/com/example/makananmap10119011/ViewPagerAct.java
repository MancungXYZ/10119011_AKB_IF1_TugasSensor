package com.example.makananmap10119011;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

//Identitas
//Nama  : Reihan Wiyanda
//Nim   : 10119011
//Kelas : IF-1
public class ViewPagerAct extends AppCompatActivity {
    Button button;
    androidx.viewpager.widget.ViewPager viewPager;
    int[] layouts;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.pager);

        layouts = new int[] {
                R.layout.layout1,
                R.layout.layout2
        };

        adapter = new Adapter(this, layouts);
        viewPager.setAdapter(adapter);


    }

    public void Alihkan(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}