package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.anns.Language;
import com.pip.phonexiaapi.data.anns.SpeechToTextResultType;
import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.SpeechRecognitionOneBestResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 16.4.18
 */
public interface SpeechToTextService {

    @GET("/technologies/stt")
    Call<ReqResult<SpeechRecognitionOneBestResult>> stt_get(
            @Query("path") String path,
            @Query("model") @Language String model,
            @Query("result_type") @SpeechToTextResultType String resultType,
            @Query("cache_only") Boolean cacheOnly,
            @Query("cache_disable") Boolean cacheDisable,
            @Query("from_time") Double fromTime,
            @Query("to_time") Double toTime
    );
}
