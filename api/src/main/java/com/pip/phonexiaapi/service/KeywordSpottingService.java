package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.anns.Language;
import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.KeywordSpottingResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 17.4.18
 */
public interface KeywordSpottingService {
    @GET("/technolgies/keywordspotting")
    Call<ReqResult<KeywordSpottingResult>> keywordSpotting_get(
            @Query("path") String path,
            @Query("model") @Language String model,
            @Query("kwlist") String keyWordList,
            @Query("cache_only") Boolean cacheOnly,
            @Query("cache_disable") Boolean cacheDisable,
            @Query("from_time") Double fromTime,
            @Query("to_time") Double toTime
    );

}
