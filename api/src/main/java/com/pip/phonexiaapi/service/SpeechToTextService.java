package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.Language;
import com.pip.phonexiaapi.data.response.GetSpeechToTextResponse;
import com.pip.phonexiaapi.data.result.ReqResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 16.4.18
 */
public interface SpeechToTextService {

    @GET("/technologies/stt")
    Call<ReqResult<GetSpeechToTextResponse>> stt_get(
            @Query("path") String path,
            @Query("model") Language model
    );
}
