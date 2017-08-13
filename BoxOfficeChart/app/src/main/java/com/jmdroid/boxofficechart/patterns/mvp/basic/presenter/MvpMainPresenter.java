package com.jmdroid.boxofficechart.patterns.mvp.basic.presenter;

import android.content.Context;

import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;

public interface MvpMainPresenter {
    void onSuccess(ResBoxOffice resBoxOffice);
    void onError();
    void initView();
    void sendRequest(Context context);
}
