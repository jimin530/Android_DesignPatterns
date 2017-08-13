package com.jmdroid.boxofficechart.patterns.mvp.basic.view;

import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;

public interface MvpMainView {
    void initView();
    void showSuccess(ResBoxOffice resBoxOffice);
    void showError();
}
