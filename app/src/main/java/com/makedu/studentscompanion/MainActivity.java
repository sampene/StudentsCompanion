package com.makedu.studentscompanion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.CustomGridViewAdapter;
import model.Schools;


public class MainActivity extends ActionBarActivity {
    GridView gridView;
    ArrayList<Schools> gridArray = new ArrayList<Schools>();
    CustomGridViewAdapter customGridAdapter;
    Button button;
    String school;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
       button = (Button)findViewById(R.id.continuebtn);
        button.setVisibility(View.INVISIBLE);

        Bitmap bolga = BitmapFactory.decodeResource(this.getResources(), R.mipmap.bolgapoly);
        Bitmap cape = BitmapFactory.decodeResource(this.getResources(), R.mipmap.capecoast_poly);
        Bitmap ho = BitmapFactory.decodeResource(this.getResources(), R.mipmap.hopoly);
        Bitmap tadi = BitmapFactory.decodeResource(this.getResources(), R.mipmap.tpoly);

        gridArray.add(new Schools(bolga,"Bolga Poly"));
        gridArray.add(new Schools(cape,"Cape Coast Poly"));
        gridArray.add(new Schools(ho,"Ho Poly"));
        gridArray.add(new Schools(tadi,"Takoradi Poly"));



        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.grid_item, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                button.setVisibility(View.VISIBLE);
                switch (position){
                    case 0:
                 school= "Bolga";
                        break;
                    case 1:
                        school= "Cape";
                        break;
                    case 2:
                        school= "Ho";
                        break;
                    case 3:
                        school= "Takoradi";
                        break;
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,school,Toast.LENGTH_LONG).show();
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
