package com.example.ahmedelkashef.ziziniakids;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by crema on 14/10/2016.
 */
public class about_us extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.about_us);
        about_usFragment fragment = new about_usFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.about_us_fragment, fragment)
                .commit();

    }
}
