package com.jmdroid.boxofficechart.patterns.mvc.basic.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.jmdroid.boxofficechart.R;
import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;
import com.jmdroid.boxofficechart.patterns.mvc.basic.adapter.MvcRecyclerViewAdapter;
import com.jmdroid.boxofficechart.patterns.mvc.basic.controller.MvcMainActivity;


/**
 * Created by jimin on 2017. 8. 11..
 */

public class MvcMainView {
    private MvcMainActivity mainActivity;
    private MvcReqMainView reqMainView;

    private RecyclerView recyclerView;
    private MvcRecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    public MvcMainView(MvcMainActivity mainActivity, MvcReqMainView reqMainView) {
        this.mainActivity = mainActivity;
        this.reqMainView = reqMainView;
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) mainActivity.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(mainActivity);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        reqMainView.sendRequest();
    }

    public void showSuccess(ResBoxOffice resBoxOffice) {
        recyclerViewAdapter = new MvcRecyclerViewAdapter(mainActivity, resBoxOffice.getBoxOfficeResult().getDailyBoxOfficeList());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void showFailed() {
        
    }
}
