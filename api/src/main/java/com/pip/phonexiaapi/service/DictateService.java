package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.AttachDictateResult;
import com.pip.phonexiaapi.data.Language;
import com.pip.phonexiaapi.data.result.ReqResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 16.4.18
 */
public interface DictateService {

    @POST("/technologies/dictate")
    Call<ReqResult<AttachDictateResult>> dictate_post(
            @Query("stream") String streamId,
            @Query("model") Language language
    );

    @GET("/technologies/dictate")
    Call<ReqResult<SpeechRecognitionResult>> dictate_get(
            @Query("task") String task
    );
}
