package com.bufflife.bufflife;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by birdman on 10/16/15.
 */
public class culogin extends Activity {

        private WebView webView;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.culogin);

            webView = (WebView) findViewById(R.id.culogin1);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://m.colorado.edu");
        }
}