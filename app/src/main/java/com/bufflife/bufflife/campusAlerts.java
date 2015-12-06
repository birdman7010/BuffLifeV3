package com.bufflife.bufflife;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * @author Jesse Bird
 * @version 1.0
 */
public class campusAlerts extends Activity {
    private WebView webView;

    /**
     * Create Webview for twitter alerts
     * @param savedInstanceState display webview of url
     * API Still needs to be implented
     * currently goes to external browser since twitter API difficulties
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campusalerts);
        //utilizing webview to load a webpage and display within app without going to external browser
        webView = (WebView) findViewById(R.id.campusalerts1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://twitter.com/cuboulderalerts");
    }
}
