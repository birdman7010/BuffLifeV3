package com.bufflife.bufflife;

import android.app.Activity;
import android.net.Uri;

/**
 * Created by birdman on 10/11/15.
 */
public class mapView extends Activity{
    Uri urimap = getIntent().getData();
    String path = urimap.getPath();
}
