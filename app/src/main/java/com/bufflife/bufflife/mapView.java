package com.bufflife.bufflife;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by birdman on 10/11/15.
 */
public class mapView extends Activity {

    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);

        webView = (WebView) findViewById(R.id.mapview1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.cubouldermap.com");
    }
}
