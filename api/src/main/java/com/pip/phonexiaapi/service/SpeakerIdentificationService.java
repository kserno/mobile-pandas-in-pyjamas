package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.AudioFileInfoResult;
import com.pip.phonexiaapi.data.SpeakerModelsResponse;
import com.pip.phonexiaapi.data.SpeakerStreamResult;
import com.pip.phonexiaapi.data.SpeakersResult;
import com.pip.phonexiaapi.data.result.ReqResult;
import com.pip.phonexiaapi.request.SpeakerModels;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 16.4.18
 */
public interface SpeakerIdentificationService {


    @POST("/technologies/speakerid/speakermodels/{name}")
    Call<Void> userSpeakerModels_post(
            @Path("name") String name
    );

    @POST("/technologies/speakerid/speakermodels/{name}/audiofile")
    Call<ReqResult<AudioFileInfoResult>> speakerModels_audioFile_post(
            @Path("name") String userName,
            @Query("path") String path,
            @Body RequestBody audioData
    );


    @PUT("/technologies/speakerid/groups/{group_name}")
    Call<Void> groups_put(
            @Path("group_name") String groupName
    );

    @POST("/technologies/speakerid/groups/{group_name}/speakermodel")
    Call<Void> groupsSpeakerModel_post(
            @Path("group_name") String groupName,
            @Body SpeakerModels speakers
    );

    @PUT("/technologies/speakerid/speakermodels/{user_name}/prepare?model=XL3")
    Call<Void> userSpeakerModelPrepare_put(
            @Path("user_name") String speakerName
    );

    @PUT("/technologies/speakerid/groups/{group_name}/prepare?model=XL3")
    Call<Void> groupSpeakerModelPrepare_put(
            @Path("group_name") String groupName
    );

    @POST("/technologies/speakerid/stream?model=XL3")
    Call<ReqResult<SpeakerStreamResult>> stream_post(
            @Query("group") String groupName,
            @Query("stream") String streamId

    );

    @GET("/technologies/speakerid/stream")
    Call<ReqResult<SpeakersResult>> getSpeakersResults(
            @Query("task") String taskId
    );


    @GET("/technologies/speakerid/speakermodels")
    Call<ReqResult<SpeakerModelsResponse>> getSpeakerModels();
}
