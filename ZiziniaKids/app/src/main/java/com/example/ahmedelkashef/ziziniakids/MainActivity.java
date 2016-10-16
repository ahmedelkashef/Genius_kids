package com.example.ahmedelkashef.ziziniakids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
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
                Intent intent = new Intent(getApplication(),LoginActivity.class);
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



    }
   /* void Handlevisibility( int mode){
        final Button Signup_btn = (Button) findViewById(R.id.SignBtn);
        final Button Login_btn = (Button) findViewById(R.id.LoginBtn);
        final Button Student_btn = (Button) findViewById(R.id.StudentBtn);
        final Button Admin_btn = (Button) findViewById(R.id.AdminBtn);
        final ImageButton Back_btn = (ImageButton) findViewById(R.id.backbtn);

        if(mode == 1) {
            Signup_btn.setVisibility(View.INVISIBLE);
            Student_btn.setVisibility(View.VISIBLE);
            Admin_btn.setVisibility(View.VISIBLE);
            Login_btn.setVisibility(View.INVISIBLE);
            Back_btn.setVisibility(View.VISIBLE);
        }
        else
        {

            Signup_btn.setVisibility(View.VISIBLE);
            Student_btn.setVisibility(View.INVISIBLE);
            Admin_btn.setVisibility(View.INVISIBLE);
            Login_btn.setVisibility(View.VISIBLE);
            Back_btn.setVisibility(View.INVISIBLE);
        }
    }
*/
}
