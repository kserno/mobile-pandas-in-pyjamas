package com.pip.phonexiaapi.service;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by filipsollar on 16.4.18
 */
public interface TimeAnalysisService {

    @GET("/technologies/timeanalysis")
    Call<Void> timeAnalysis_get();

    @GET("/technologies/timeanalysis/stream")
    Call<Void> timeAnalysis_stream_get();

    @POST("/technologies/timeanalysis/stream")
    Call<Void> timeAnalysis_stream_post();

    @DELETE("/technologies/timeanalysis/stream")
    Call<Void> timeAnalysis_stream_delete();
}
