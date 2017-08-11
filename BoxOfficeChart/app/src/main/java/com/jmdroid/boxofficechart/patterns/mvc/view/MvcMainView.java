package com.jmdroid.boxofficechart.patterns.mvc.view;

import android.util.Log;

import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;
import com.jmdroid.boxofficechart.patterns.mvc.controller.MvcMainActivity;


/**
 * Created by jimin on 2017. 8. 11..
 */

public class MvcMainView {
    private MvcMainActivity mainActivity;
    MvcReqMainView reqMainView;

    public MvcMainView(MvcMainActivity mainActivity, MvcReqMainView reqMainView) {
        this.mainActivity = mainActivity;
        this.reqMainView = reqMainView;
        initView();
    }

    private void initView() {
        reqMainView.sendRequest();
    }

    public void showSuccess(ResBoxOffice resBoxOffice) {
        Log.i("Final Result ", resBoxOffice.getBoxOfficeResult().getDailyBoxOfficeList().get(0).getMovieNm());
    }

    public void showFailed() {

    }
}
