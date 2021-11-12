package com.haythem.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etURL;
WebView wv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv1= (WebView) findViewById(R.id.wv1);
        wv1.setWebViewClient(new myWebView());

        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        etURL=(EditText) findViewById(R.id.etURL);
        wv1.loadUrl("https://www.youtube.com/");

    }

    public void buForword(View view) {
        wv1.goForward();
    }

    public void buBack(View view) {
        wv1.goBack();
    }

    public void buGo(View view) {
        LoadURL(etURL.getText().toString());
    }
    String url;
    void LoadURL(String url){
        this.url=url;
        wv1.loadUrl(url);
    }
    private class myWebView extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(url);
            return true;
        }
        }

    }
