package com.jmdroid.boxofficechart.patterns.mvc.basic.model;


import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;

public interface MvcOnBoxOfficeListener {
    void onSuccess(ResBoxOffice resBoxOffice);

    void onError();
}
