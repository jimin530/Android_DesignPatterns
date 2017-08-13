package com.jmdroid.boxofficechart.patterns.mvp.basic.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.jmdroid.boxofficechart.BaseActivity;
import com.jmdroid.boxofficechart.R;
import com.jmdroid.boxofficechart.adapter.RecyclerViewAdapter;
import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;
import com.jmdroid.boxofficechart.patterns.mvp.basic.presenter.MvpMainPresenterImp;

public class MvpMainActivity extends BaseActivity implements MvpMainView {

    private MvpMainPresenterImp presenter = null;
    private RecyclerView mvpRecyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_main);

        if (presenter == null) {
            presenter = new MvpMainPresenterImp(this);
        }
        presenter.initView();
    }

    @Override
    public void initView() {
        mvpRecyclerView = (RecyclerView) findViewById(R.id.mvpRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mvpRecyclerView.setLayoutManager(linearLayoutManager);

        presenter.sendRequest(this);
    }

    @Override
    public void showSuccess(ResBoxOffice resBoxOffice) {
        recyclerViewAdapter = new RecyclerViewAdapter(this, resBoxOffice.getBoxOfficeResult().getDailyBoxOfficeList());
        mvpRecyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void showError() {
    }
}
