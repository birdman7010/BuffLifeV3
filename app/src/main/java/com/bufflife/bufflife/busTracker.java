package com.bufflife.bufflife;

import android.app.Activity;
import android.net.Uri;

/**
 * Created by birdman on 10/11/15.
 */
public class busTracker extends Activity {
    Uri uribus = getIntent().getData();
    String path = uribus.getPath();
}
