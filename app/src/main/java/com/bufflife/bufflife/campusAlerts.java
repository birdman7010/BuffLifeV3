package com.bufflife.bufflife;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Jesse Bird on 10/11/15.
 */
public class campusAlerts extends Activity {
    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campusalerts);

        webView = (WebView) findViewById(R.id.campusalerts1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://twitter.com/cuboulderalerts");
    }
}
