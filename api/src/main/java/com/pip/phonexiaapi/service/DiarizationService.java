package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.DiarizationResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Calls used for diarization
 *
 * Created by filipsollar on 16.4.18
 */
public interface DiarizationService {
    @GET("/technologies/diarization")
    Call<ReqResult<DiarizationResult>> diarization_get(
            @Query("path") String path,
            @Query("model") String model, // diarization model
            @Query("max_speakers") Integer maxSpeakers,
            @Query("total_speaker") Integer totalSpeakers,
            @Query("cache_only") Boolean cacheOnly,
            @Query("cache_disable") Boolean cacheDisable,
            @Query("from_time") Double fromTime,
            @Query("to_time") Double toTime
    );
}
