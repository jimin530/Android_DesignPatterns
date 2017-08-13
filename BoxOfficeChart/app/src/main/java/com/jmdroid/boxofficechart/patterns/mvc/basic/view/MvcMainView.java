package com.jmdroid.boxofficechart.patterns.mvc.basic.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.jmdroid.boxofficechart.R;
import com.jmdroid.boxofficechart.adapter.RecyclerViewAdapter;
import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;
import com.jmdroid.boxofficechart.patterns.mvc.basic.controller.MvcMainActivity;


/**
 * Created by jimin on 2017. 8. 11..
 */

public class MvcMainView {
    private MvcMainActivity mainActivity;
    private MvcReqMainView reqMainView;

    private RecyclerView mvcRecyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    public MvcMainView(MvcMainActivity mainActivity, MvcReqMainView reqMainView) {
        this.mainActivity = mainActivity;
        this.reqMainView = reqMainView;
        initView();
    }

    private void initView() {
        mvcRecyclerView = (RecyclerView) mainActivity.findViewById(R.id.mvcRecyclerView);
        linearLayoutManager = new LinearLayoutManager(mainActivity);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mvcRecyclerView.setLayoutManager(linearLayoutManager);

        reqMainView.sendRequest();
    }

    public void showSuccess(ResBoxOffice resBoxOffice) {
        recyclerViewAdapter = new RecyclerViewAdapter(mainActivity, resBoxOffice.getBoxOfficeResult().getDailyBoxOfficeList());
        mvcRecyclerView.setAdapter(recyclerViewAdapter);
    }

    public void showFailed() {

    }
}
