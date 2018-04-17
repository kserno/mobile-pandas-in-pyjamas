package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.Language;
import com.pip.phonexiaapi.data.response.GetDiarizationResponse;
import com.pip.phonexiaapi.data.result.ReqResult;

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
    Call<ReqResult<GetDiarizationResponse>> diarization_get(
            @Query("path") String path,
            @Query("model") String model, // diarization model
            @Query("max_speakers") int maxSpeakers,
            @Query("total_speaker") int totalSpeakers,
            @Query("cache_only") boolean cacheOnly,
            @Query("cache_disable") boolean cacheDisable,
            @Query("from_time") double fromTime,
            @Query("to_time") double toTime
    );
}
