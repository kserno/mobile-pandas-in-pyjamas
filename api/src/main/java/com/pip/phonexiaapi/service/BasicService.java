package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.response.GetServerInfoResponse;
import com.pip.phonexiaapi.data.response.GetStatusResponse;
import com.pip.phonexiaapi.data.response.GetTasksResponse;
import com.pip.phonexiaapi.data.result.ReqResult;
import com.pip.phonexiaapi.data.response.GetTechnologiesResponse;
import com.pip.phonexiaapi.data.login.LoginResponse;

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
    Call<ReqResult<LoginResponse>> login(
        @Header("Authorization") String token
    );

    @POST("/audiofile")
    Call<Void> audioFile_post( // TODO change return data type
            @Query("path") String path,
            @Body RequestBody audioData
    );

    @GET("/audiofile")
    Call<Void> audioFile_get( // TODO change return data type
            @Query("path") String path
    );

    @GET("/technologies")
    Call<ReqResult<GetTechnologiesResponse>> technologies_get();

    @GET("/tasks")
    Call<ReqResult<GetTasksResponse>> tasks_get();

    @GET("/status")
    Call<ReqResult<GetStatusResponse>> status_get();

    @GET("/server/info")
    Call<ReqResult<GetServerInfoResponse>> serverInfo_get();

}
