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
    private WebView mvcWebView;
    private ProgressBar mvcProgressBar;

    public MvcWebView(MvcWebActivity webActivity, String movieNm) {
        this.webActivity = webActivity;
        this.movieNm = movieNm;
        initView();
    }

    private void initView() {
        mvcProgressBar = (ProgressBar) webActivity.findViewById(R.id.mvcProgressBar);

        mvcWebView = (WebView) webActivity.findViewById(R.id.mvcWebView);
        mvcWebView.getSettings().setJavaScriptEnabled(true);
        mvcWebView.getSettings().setAppCacheEnabled(false);
        mvcWebView.getSettings().setDatabaseEnabled(true);
        mvcWebView.getSettings().setDomStorageEnabled(true);
        mvcWebView.getSettings().setSaveFormData(false);
        mvcWebView.getSettings().setAllowContentAccess(false);
        mvcWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mvcWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mvcWebView.getSettings().setSupportMultipleWindows(true);
        mvcWebView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mvcProgressBar.setVisibility(View.VISIBLE);
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mvcProgressBar.setVisibility(View.INVISIBLE);
            }
        });
        mvcWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mvcProgressBar.setProgress(newProgress);
            }
        });
        mvcWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() != KeyEvent.ACTION_DOWN)
                    return true;

                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    if (mvcWebView.canGoBack()) {
                        mvcWebView.goBack();
                    } else {
                        webActivity.onBackPressed();
                    }
                    return true;
                }

                return false;
            }
        });
        mvcWebView.loadUrl("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=영화 " + movieNm);
    }
}
