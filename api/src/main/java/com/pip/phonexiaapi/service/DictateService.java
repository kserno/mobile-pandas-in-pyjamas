package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.anns.SpeechRecognitionResultMode;
import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.SpeechRecognitionOnlineResult;
import com.pip.phonexiaapi.data.result.UserStreamTaskInfoResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 16.4.18
 */
public interface DictateService {

    @POST("/technologies/dictate")
    Call<ReqResult<UserStreamTaskInfoResult>> dictate_post(
            @Query("stream") String streamId,
            @Query("model") @SpeechRecognitionResultMode String model
    );

    @GET("/technologies/dictate")
    Call<ReqResult<SpeechRecognitionOnlineResult>> dictate_get(
            @Query("task") String task
    );
}
