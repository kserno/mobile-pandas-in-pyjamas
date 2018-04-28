package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.AudioFileInfoResult;
import com.pip.phonexiaapi.data.result.ServerInfoResult;
import com.pip.phonexiaapi.data.result.StatusResult;
import com.pip.phonexiaapi.data.result.TasksResult;
import com.pip.phonexiaapi.data.result.TechnologiesResult;
import com.pip.phonexiaapi.data.result.UserSessionResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Service to handle following requests
 * <ul>
 *    <li>login</li>
 *    <li>directory</li>
 *    <li>audiofile</li>
 *    <li>audiofile metainfo</li>
 *    <li>audiofile info</li>
 *    <li>audiofile registration</li>
 *    <li>load statistics</li>
 *    <li>async req pending</li>
 *    <li>async req done</li>
 *    <li>current tasks</li>
 *    <li>technologies</li>
 *    <li>user information</li>
 *    <li>server status</li>
 *    <li>server info</li>
 * </ul>
 *
 * Created by filipsollar on 16.4.18
 */
public interface BasicService {

    @POST("/login")
    Call<ReqResult<UserSessionResult>> login(
        @Header("Authorization") String token
    );

    @POST("/audiofile")
    Call<ReqResult<AudioFileInfoResult>> audiofile_post(
            @Query("path") String path,
            @Body RequestBody audioData
    );

    @GET("/audiofile")
    Call<Void> audiofile_get( // TODO change return data type
            @Query("path") String path
    );

    @GET("/technologies")
    Call<ReqResult<TechnologiesResult>> technologies_get();

    @GET("/tasks")
    Call<ReqResult<TasksResult>> tasks_get();

    @GET("/status")
    Call<ReqResult<StatusResult>> status_get();

    @GET("/server/info")
    Call<ReqResult<ServerInfoResult>> serverInfo_get();

}
