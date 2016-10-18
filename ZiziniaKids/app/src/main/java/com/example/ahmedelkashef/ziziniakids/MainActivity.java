package com.example.ahmedelkashef.ziziniakids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button Signup_btn;
    Button Login_btn ;
    Button Back_btn ;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.btn, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.about_us:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                startActivity(new Intent(getApplication(), about_us.class));

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button Signup_btn = (Button) findViewById(R.id.SignBtn);
        final Button Login_btn = (Button) findViewById(R.id.LoginBtn);
        final ImageButton Back_btn = (ImageButton) findViewById(R.id.backbtn);
        String[] mPlanetTitles = {"About us"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        String open ="",close="";
        // Set the adapter for the list view

        ArrayAdapter<String> adapter = new about_usAdapter(this, Arrays.asList(mPlanetTitles));
        mDrawerList.setAdapter(adapter);

        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0)
                {
                    startActivity(new Intent(getApplication(), about_us.class));
                }
            }
        });

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), LoginActivity.class);
                startActivity(intent);
            }
        });
        Signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SignupActivity.class);
                startActivity(intent);
            }
        });


        /*mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle( this,                  *//* host Activity *//*
                mDrawerLayout,         *//* DrawerLayout object *//*
                (R.drawable.navigation),  *//* nav drawer icon to replace 'Up' caret *//*
                0,  *//* "open drawer" description *//*
                0  *//* "close drawer" description *//*

        ) {

            *//** Called when a drawer has settled in a completely closed state. *//*
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);

            }

            *//** Called when a drawer has settled in a completely open state. *//*
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);*/


    }
   /* @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }*/
}
