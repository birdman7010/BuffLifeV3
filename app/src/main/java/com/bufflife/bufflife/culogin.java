package com.bufflife.bufflife;

/**
 * @author Jesse Bird
 * @version 2.0
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;

    public class culogin extends Activity {

        /**
         * Url to be loaded and saved for that API
         */
        private static final String target_url="http://m.colorado.edu";
        private static final String target_url_prefix="m.colorado.edu";
        private Context mContext;
        private WebView mWebview;
        private WebView mWebviewPop;
        private FrameLayout mContainer;
        private long mLastBackPressTime = 0;
        private Toast mToast;

        /**
         * Creating web API with webview
         * @param savedInstanceState display within app
         */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.culogin);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            mWebview = (WebView) findViewById(R.id.culogin1);
            mContainer = (FrameLayout) findViewById(R.id.webview_frame);
            WebSettings webSettings = mWebview.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setAppCacheEnabled(true);
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            webSettings.setSupportMultipleWindows(true);
            mWebview.setWebViewClient(new UriWebViewClient());
            mWebview.setWebChromeClient(new UriChromeClient());
            mWebview.loadUrl(target_url);

            mContext=this.getApplicationContext();

        }


        private class UriWebViewClient extends WebViewClient {
            /**
             *
             * @param view loading the view
             * @param url loading the url
             * @return start activity
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String host = Uri.parse(url).getHost();
                if (host.equals(target_url_prefix))
                {
                    // let my WebView load
                    if(mWebviewPop!=null)
                    {
                        mWebviewPop.setVisibility(View.GONE);
                        mContainer.removeView(mWebviewPop);
                        mWebviewPop=null;
                    }
                    return false;
                }

                if(host.equals("m.colorado.edu"))
                {
                    return false;
                }
                // Otherwise, the link is not for a page on my site, so launch
                // another Activity that handles URLs
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }

            /**
             * Error Handler
             * @param view checking the view
             * @param handler SSL handler built in android studio
             * @param error checking errors
             */
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                           SslError error) {
                Log.d("onReceivedSslError", "onReceivedSslError");
                //super.onReceivedSslError(view, handler, error);
            }
        }

        class UriChromeClient extends WebChromeClient {
            /**
             * Creating the webview API
             * @param view using the webview
             * @param isDialog boolean of window dialogs
             * @param isUserGesture boolean of gestures of user in window
             * @param resultMsg taking information of webview
             * @return created new window API for that webview
             */
            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog,
                                          boolean isUserGesture, Message resultMsg) {
                mWebviewPop = new WebView(mContext);
                mWebviewPop.setVerticalScrollBarEnabled(false);
                mWebviewPop.setHorizontalScrollBarEnabled(false);
                mWebviewPop.setWebViewClient(new UriWebViewClient());
                mWebviewPop.getSettings().setJavaScriptEnabled(true);
                mWebviewPop.getSettings().setSavePassword(false);
                mWebviewPop.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                mContainer.addView(mWebviewPop);
                WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
                transport.setWebView(mWebviewPop);
                resultMsg.sendToTarget();

                return true;
            }

            /**
             * Closing API window at end
             * @param window
             */
            @Override
            public void onCloseWindow(WebView window) {
                Log.d("onCloseWindow", "called");
            }

        }
    }