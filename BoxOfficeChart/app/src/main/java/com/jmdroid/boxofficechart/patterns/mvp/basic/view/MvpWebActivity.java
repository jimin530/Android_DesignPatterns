package com.jmdroid.boxofficechart.patterns.mvp.basic.view;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.jmdroid.boxofficechart.BaseActivity;
import com.jmdroid.boxofficechart.R;

public class MvpWebActivity extends BaseActivity {

    private String movieNm;
    private WebView mvpWebView;
    private ProgressBar mvpProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_web);

        movieNm = getIntent().getStringExtra("movieNm");

        mvpProgressBar = (ProgressBar) findViewById(R.id.mvpProgressBar);

        mvpWebView = (WebView) findViewById(R.id.mvpWebView);
        mvpWebView.getSettings().setJavaScriptEnabled(true);
        mvpWebView.getSettings().setAppCacheEnabled(false);
        mvpWebView.getSettings().setDatabaseEnabled(true);
        mvpWebView.getSettings().setDomStorageEnabled(true);
        mvpWebView.getSettings().setSaveFormData(false);
        mvpWebView.getSettings().setAllowContentAccess(false);
        mvpWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mvpWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mvpWebView.getSettings().setSupportMultipleWindows(true);
        mvpWebView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mvpProgressBar.setVisibility(View.VISIBLE);
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mvpProgressBar.setVisibility(View.INVISIBLE);
            }
        });
        mvpWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mvpProgressBar.setProgress(newProgress);
            }
        });

        mvpWebView.loadUrl("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=영화 " + movieNm);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mvpWebView.canGoBack()) {
            mvpWebView.goBack();
            return true;
        }
        if ((keyCode == KeyEvent.KEYCODE_BACK) && (mvpWebView.canGoBack() == false)) {
            onBackPressed();
        }

        return super.onKeyDown(keyCode, event);
    }
}
