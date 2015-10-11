package com.bufflife.bufflife;

import android.app.Activity;
import android.net.Uri;

/**
 * Created by birdman on 10/11/15.
 */
public class campusAlerts extends Activity {
    Uri urialert = getIntent().getData();
    String path = urialert.getPath();
}
