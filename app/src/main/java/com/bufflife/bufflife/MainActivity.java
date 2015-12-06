package com.bufflife.bufflife;

/**
 * Main Activity Page for all of our buttons to access correct information
 * @author Jesse Bird
 * @version 1.0
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button buttonmapView;
    public Button buttonbusTracker;
    public Button buttoncampusAlerts;
    public Button buttonculogin;
    public Button buttondiningHallMenu;

    /**
     * Creating all buttons
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        buttonmapView = (Button) findViewById(R.id.button);

        buttonmapView.setOnClickListener(new View.OnClickListener() {
            /**
             * Button to go to mapView class
             * @param v
             */
            @Override
            public void onClick(View v) {
                //start intent activity of mapview
                Intent intentmap = new Intent(MainActivity.this, mapView.class);
                startActivity(intentmap);
            }

        });
        buttonbusTracker = (Button) findViewById(R.id.button2);
        buttonbusTracker.setOnClickListener(new View.OnClickListener() {
            /**
             *Button to go to busTracker class
             * @param v On click go the view
             */
            @Override
            public void onClick(View v) {
                //start intent activity of bustracker
                Intent intentmap = new Intent(MainActivity.this, busTracker.class);
                startActivity(intentmap);
            }
        });
        buttoncampusAlerts = (Button) findViewById(R.id.button3);
        buttoncampusAlerts.setOnClickListener(new View.OnClickListener() {
            /**
             *Button to go to campusAlerts class
             * @param v On click go the view
             */
            @Override
            public void onClick(View v) {
                //start intent activity of campusAlerts
                Intent intentmap = new Intent(MainActivity.this, campusAlerts.class);
                startActivity(intentmap);
            }
        });
        buttonculogin = (Button) findViewById(R.id.button4);
        buttonculogin.setOnClickListener(new View.OnClickListener() {
            /**
             *Button to go to culogin class
             * @param v On click go the view
             */
            @Override
            public void onClick(View v) {
                //start intent activity of culogin
                Intent intentmap = new Intent(MainActivity.this, culogin.class);
                startActivity(intentmap);
            }
        });

        buttondiningHallMenu = (Button) findViewById(R.id.button5);
        buttondiningHallMenu.setOnClickListener(new View.OnClickListener() {
            /**
             *Button to go to diningHallMenu Class
             * @param v On click go the view
             * @author  Daniel Yedidovich
             * @version 1.5
             */
            @Override
            public void onClick(View v) {
                //start intent activity of diningHallMenu
                Intent intentdininghall = new Intent(MainActivity.this, diningHallMenu.class);
                startActivity(intentdininghall);
            }
        });
    }

    /**
     * Creating the Action Bar
     * @param menu to create menu
     * @return action bar
     * currently not used since no action bar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
