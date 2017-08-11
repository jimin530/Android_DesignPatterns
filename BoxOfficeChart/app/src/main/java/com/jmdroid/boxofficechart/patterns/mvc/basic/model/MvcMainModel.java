package com.jmdroid.boxofficechart.patterns.mvc.basic.model;

import android.util.Log;

import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;
import com.jmdroid.boxofficechart.retrofit.RetrofitGenterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MvcMainModel {

    private static final String TAG = "MvcMainModel";

    public void getBoxOffice(final MvcOnBoxOfficeListener listener) {
        Call<ResBoxOffice> call = RetrofitGenterator.getInstance().getRetrofitImpFactory().getChart("99b6816e76ba5210c6c65ef822a824f4", "20170810");
        call.enqueue(new Callback<ResBoxOffice>() {
            @Override
            public void onResponse(Call<ResBoxOffice> call, Response<ResBoxOffice> response) {
                Log.i(TAG, "RES SUCCESS");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ResBoxOffice> call, Throwable t) {
                Log.i(TAG, "RES FAIL : " + t.toString());
                listener.onError();
            }
        });
    }
}
