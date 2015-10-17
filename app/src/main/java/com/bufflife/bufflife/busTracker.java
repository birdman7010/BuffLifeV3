package com.bufflife.bufflife;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by birdman on 10/11/15.
 */
public class busTracker extends Activity {
    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bustracker);

        webView = (WebView) findViewById(R.id.bustracker1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.boulderbustracker.com");
    }
}
