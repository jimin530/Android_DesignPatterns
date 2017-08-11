package com.jmdroid.boxofficechart.patterns.mvc.basic.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jmdroid.boxofficechart.R;
import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;
import com.jmdroid.boxofficechart.patterns.mvc.basic.model.MvcMainModel;
import com.jmdroid.boxofficechart.patterns.mvc.basic.model.MvcOnBoxOfficeListener;
import com.jmdroid.boxofficechart.patterns.mvc.basic.view.MvcMainView;
import com.jmdroid.boxofficechart.patterns.mvc.basic.view.MvcReqMainView;
import com.jmdroid.boxofficechart.retrofit.RetrofitGenterator;

public class MvcMainActivity extends AppCompatActivity implements MvcReqMainView, MvcOnBoxOfficeListener {

    private MvcMainView mainView;
    private MvcMainModel mainModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 레트로핏 초기 설정
        RetrofitGenterator.getInstance().launch_retrofit(getApplicationContext());
        setContentView(R.layout.activity_mvc_main);

        if (mainModel == null) {
            mainModel = new MvcMainModel();
        }
        mainView = new MvcMainView(this, this);
    }

    @Override
    public void onSuccess(ResBoxOffice resBoxOffice) {
        mainView.showSuccess(resBoxOffice);
    }

    @Override
    public void onError() {
        mainView.showFailed();
    }

    @Override
    public void sendRequest() {
        mainModel.getBoxOffice(this);
    }
}
