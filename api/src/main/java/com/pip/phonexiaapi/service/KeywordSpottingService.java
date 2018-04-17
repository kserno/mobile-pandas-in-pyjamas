package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.Language;
import com.pip.phonexiaapi.data.response.GetKeyWordSpottingResponse;
import com.pip.phonexiaapi.data.result.ReqResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 17.4.18
 */
public interface KeywordSpottingService {
    @GET("/technolgies/keywordspotting")
    Call<ReqResult<GetKeyWordSpottingResponse>> keywordSpotting_get(
            @Query("path") String path,
            @Query("model") Language model,
            @Query("kwlist") String keyWordList,
            @Query("cache_only") boolean cacheOnly,
            @Query("cache_disable") boolean cacheDisable,
            @Query("from_time") double fromTime,
            @Query("to_time") double toTime
    );

}
