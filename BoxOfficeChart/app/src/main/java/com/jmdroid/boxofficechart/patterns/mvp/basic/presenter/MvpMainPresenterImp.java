package com.jmdroid.boxofficechart.patterns.mvp.basic.presenter;

import android.content.Context;

import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;
import com.jmdroid.boxofficechart.patterns.mvp.basic.model.MvpMainModel;
import com.jmdroid.boxofficechart.patterns.mvp.basic.view.MvpMainView;

public class MvpMainPresenterImp implements MvpMainPresenter {
    private MvpMainView mainView;
    private MvpMainModel mainModel;

    public MvpMainPresenterImp(MvpMainView mainView) {
        this.mainView = mainView;
        mainModel = new MvpMainModel();
    }

    @Override
    public void onSuccess(ResBoxOffice resBoxOffice) {
        mainView.showSuccess(resBoxOffice);
    }

    @Override
    public void onError() {
        mainView.showError();
    }


    @Override
    public void initView() {
        mainView.initView();
    }

    @Override
    public void sendRequest(Context context) {
        mainModel.getBoxOffice(this);
    }
}
