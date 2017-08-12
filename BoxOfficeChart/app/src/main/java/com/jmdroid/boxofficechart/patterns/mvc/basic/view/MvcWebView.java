package com.jmdroid.boxofficechart.patterns.mvc.basic.view;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.jmdroid.boxofficechart.R;
import com.jmdroid.boxofficechart.patterns.mvc.basic.controller.MvcWebActivity;


/**
 * Created by jimin on 2017. 8. 11..
 */

public class MvcWebView {
    private MvcWebActivity webActivity;
    private String movieNm;
    private WebView webView;
    private ProgressBar progressBar;

    public MvcWebView(MvcWebActivity webActivity, String movieNm) {
        this.webActivity = webActivity;
        this.movieNm = movieNm;
        initView();
    }

    private void initView() {
        progressBar = (ProgressBar) webActivity.findViewById(R.id.progressBar);

        webView = (WebView) webActivity.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSaveFormData(false);
        webView.getSettings().setAllowContentAccess(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }
        });
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() != KeyEvent.ACTION_DOWN)
                    return true;

                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        webActivity.onBackPressed();
                    }
                    return true;
                }

                return false;
            }
        });
        webView.loadUrl("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=영화 " + movieNm);
    }
}
