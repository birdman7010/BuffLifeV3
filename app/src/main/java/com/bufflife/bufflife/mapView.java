package com.bufflife.bufflife;

/**
 * @author Jesse Bird
 * @version 1.0
 */

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class mapView extends Activity {

    private WebView webView;

    /**
     * Creating webview for cubouldermap.com
     * @param savedInstanceState display webview of url within app
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);
        //utilizing webview to load a webpage and display within app without going to external browser
        webView = (WebView) findViewById(R.id.mapview1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.cubouldermap.com");
    }
}
