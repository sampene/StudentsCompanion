package com.makedu.studentscompanion;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

import adapter.CustomGridViewAdapter;
import model.Preferences;
import model.Schools;


public class MainActivity extends ActionBarActivity {
    GridView gridView;
    ArrayList<Schools> gridArray = new ArrayList<>();
    CustomGridViewAdapter customGridAdapter;
    Button button;
    String school;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);
        //gets context preferences and does checks if the person has already selected a school
        Preferences.myPrefs= getSharedPreferences(Preferences.prefernceName, Context.MODE_PRIVATE);
        Preferences.context=this;

        if(Preferences.getisLoggedIn()){
            Intent ints= new Intent(this,StudentHome.class);
            startActivity(ints);    //if school already selected, go to logged in scren
            finish();
        }

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.myWindowBackground));
        setSupportActionBar(toolbar);
        button = (Button)findViewById(R.id.continuebtn);
        button.setVisibility(View.INVISIBLE);

        Bitmap bolga = BitmapFactory.decodeResource(this.getResources(), R.mipmap.bolgapoly);
        Bitmap cape = BitmapFactory.decodeResource(this.getResources(), R.mipmap.capecoast_poly);
        Bitmap ho = BitmapFactory.decodeResource(this.getResources(), R.mipmap.hopoly);
        Bitmap tadi = BitmapFactory.decodeResource(this.getResources(), R.mipmap.tpoly);


        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new AccelerateInterpolator()); //add this
        fadeIn.setDuration(500);


        gridArray.add(new Schools(bolga,"Bolga Poly"));
        gridArray.add(new Schools(cape,"Cape Coast Poly"));
        gridArray.add(new Schools(ho,"Ho Poly"));
        gridArray.add(new Schools(tadi,"Takoradi Poly"));



        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.grid_item, gridArray);
        gridView.setAdapter(customGridAdapter);
        gridView.startAnimation(fadeIn);




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //button.setVisibility(View.VISIBLE);
                Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setInterpolator(new AccelerateInterpolator()); //add this
                fadeIn.setDuration(1000);
                button.startAnimation(fadeIn);
                button.setVisibility(View.VISIBLE);


                switch (position){
                    case 0:
                 school= "Bolga Poly";
                        break;
                    case 1:
                        school= "Cape-Coast Poly";
                        break;
                    case 2:
                        school= "Ho Poly";
                        break;
                    case 3:
                        school= "Takoradi Poly";
                        break;
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.setisLoggedIn(Preferences.context,true);
                Preferences.setSelectedSchool(school);
               Intent student_main = new Intent(MainActivity.this,StudentHome.class);
                startActivity(student_main);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
