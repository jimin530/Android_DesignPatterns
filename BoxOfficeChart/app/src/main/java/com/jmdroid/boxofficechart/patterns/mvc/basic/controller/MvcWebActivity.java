package com.jmdroid.boxofficechart.patterns.mvc.basic.controller;

import android.os.Bundle;

import com.jmdroid.boxofficechart.BaseActivity;
import com.jmdroid.boxofficechart.R;
import com.jmdroid.boxofficechart.patterns.mvc.basic.view.MvcWebView;

public class MvcWebActivity extends BaseActivity {

    private MvcWebView mvcWebView;
    private String movieNm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc_web);

        movieNm = getIntent().getStringExtra("movieNm");
        mvcWebView = new MvcWebView(this, movieNm);
    }
}
