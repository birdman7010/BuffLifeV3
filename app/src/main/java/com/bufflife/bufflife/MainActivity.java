package com.bufflife.bufflife;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intentmap = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cubouldermap.com"));
                startActivity(intentmap);
            }
        });
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View x) {
                Intent intentbus = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.boulderbustracker.com"));
                startActivity(intentbus);
            }
        });
        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View y) {
                Intent intentalerts = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/cuboulderalerts?lang=en"));
                startActivity(intentalerts);
            }
        });
    }
}
