package com.pip.phonexiaapi.service;

import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.HttpStreamResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 16.4.18
 */
public interface StreamService {

    @POST("/stream/http")
    Call<ReqResult<HttpStreamResult>> httpStream_post(
            @Query("frequency") int frequency,
            @Query("n_channels") Integer numberOfChannels,
            @Query("path") String pathToFile // path to file where saved if not set no data is saved
    );

    /**
     * Send chunks of data
     * @param streamId
     * @param s16IErawData
     * @return
     */
    @PUT("/stream/http")
    Call<Void> httpStream_put(
            @Query("stream") String streamId,
            @Body RequestBody s16IErawData
    );

    @DELETE("/stream/http")
    Call<Void> httpStream_delete(
            @Query("stream") String streamId
    );

}
