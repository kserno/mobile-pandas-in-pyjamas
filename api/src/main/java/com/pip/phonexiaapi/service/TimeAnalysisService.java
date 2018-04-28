package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.anns.Language;
import com.pip.phonexiaapi.data.anns.SpeechToTextResultType;
import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.TimeAnalysisResult;
import com.pip.phonexiaapi.data.result.TimeAnalysisStreamResult;
import com.pip.phonexiaapi.data.result.UserStreamTaskInfoResult;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 16.4.18
 */
public interface TimeAnalysisService {

    @GET("/technologies/timeanalysis")
    Call<ReqResult<TimeAnalysisResult>> timeAnalysis_get(
            @Query("path") String path,
            @Query("model") String model, // time analysis model
            @Query("segmentation") Boolean segmentation,
            @Query("cache_only") Boolean cacheOnly,
            @Query("cache_disable") Boolean cacheDisable,
            @Query("from_time") Double fromTime,
            @Query("to_time") Double toTime
    );

    @GET("/technologies/timeanalysis/stream")
    Call<ReqResult<TimeAnalysisStreamResult>> timeAnalysis_stream_get(
            @Query("task") String taskId
    );

    @POST("/technologies/timeanalysis/stream")
    Call<ReqResult<UserStreamTaskInfoResult>> timeAnalysis_stream_post(
            @Query("stream") String streamId,
            @Query("model") String model
    );


}
