package com.example.ahmedelkashef.ziziniakids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Intro extends AppCompatActivity {

    private final int DURATION = 3000 ;
    private  Thread IntroThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        IntroThread = new Thread() {

            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(DURATION);
                    } catch (InterruptedException e) {
                    } finally {
                        finish();
                        Intent intent = new Intent(getBaseContext(),
                               MainActivity.class);
                        startActivity(intent);
                    }
                }
            }

        };
        IntroThread.start();
    }
}
