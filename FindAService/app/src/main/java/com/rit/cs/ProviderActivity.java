package com.rit.cs;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ProviderActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_provider);
//        WebView myWebView = (WebView) findViewById(R.id.webview);
//        myWebView.loadUrl("www.google.com");
//        myWebView.setWebViewClient(new myWebViewClient());
//
//    }
    private WebView mWebview ;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });

        mWebview .loadUrl("http://192.168.0.12:8080/FindMyServiceApp/verifyPage.jsp");
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.getSettings().setAllowContentAccess(true);
        mWebview.getSettings().setGeolocationEnabled(true);
        mWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebview.getSettings().setSaveFormData(true);
        mWebview.getSettings().setDomStorageEnabled(true);
        mWebview.getSettings().setDatabaseEnabled(true);
        setContentView(mWebview );

    }
}
