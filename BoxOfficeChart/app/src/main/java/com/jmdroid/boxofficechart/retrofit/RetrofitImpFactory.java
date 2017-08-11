package com.jmdroid.boxofficechart.retrofit;


import com.jmdroid.boxofficechart.dto.res.ResBoxOffice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitImpFactory {

    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    Call<ResBoxOffice> getChart(@Query("key") String key, @Query("targetDt") String targetDt);
}