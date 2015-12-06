package com.bufflife.bufflife;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * @author Jesse Bird
 * @version  1.0
 */
public class busTracker extends Activity {
    private WebView webView;

    /**
     * Create webview for buffbusmobile.etaspot.net
     * @param savedInstanceState display webview of url within app
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bustracker);
        //utilizing webview to load a webpage and display within app without going to external browser
        webView = (WebView) findViewById(R.id.bustracker1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://buffbusmobile.etaspot.net");
    }
}
