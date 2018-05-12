package com.pip.sdk;



import android.support.annotation.NonNull;

import com.pip.phonexiaapi.IPhonexiaApi;
import com.pip.phonexiaapi.PhonexiaApi;
import com.pip.phonexiaapi.RecorderCallback;
import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.HttpStreamResult;
import com.pip.phonexiaapi.data.result.ServerInfoResult;
import com.pip.phonexiaapi.data.result.StatusResult;
import com.pip.phonexiaapi.data.result.TechnologiesResult;
import com.pip.sdk.analyzers.StreamAnalyzer;
import com.pip.sdk.data.ServerInfoMapper;
import com.pip.sdk.data.ServerInfoModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by filipsollar on 18.4.18
 */
public class PhonexiaSdk implements IPhonexiaSdk {

    private IPhonexiaApi mPhonexiaApi;
    private StreamData mStreamData = new StreamData();
    private RecorderCallback mRecorderCallback = new RecorderCallback() {
        @Override
        public void onRecording(byte[] data) {
            sendBytesToStream(data);
        }

        @Override
        public void finished() {

        }
    };

    public PhonexiaSdk() {
        mPhonexiaApi = new PhonexiaApi();
    }

    @Override
    public void loadServerInformation(final SdkCallback<ServerInfoModel> callback) {

        final ServerInfoModel model = new ServerInfoModel();

        mPhonexiaApi.getServerStatus().enqueue(new Callback<ReqResult<StatusResult>>() {
            @Override
            public void onResponse(Call<ReqResult<StatusResult>> call, Response<ReqResult<StatusResult>> response) {
                ServerInfoMapper.addServerStatus(model, response.body().getResult());
                processResponseServerInfo(model, callback);
            }

            @Override
            public void onFailure(Call<ReqResult<StatusResult>> call, Throwable t) {
                callback.onFailure(t);
            }
        });


        mPhonexiaApi.getServerInformation().enqueue(new Callback<ReqResult<ServerInfoResult>>() {
            @Override
            public void onResponse(Call<ReqResult<ServerInfoResult>> call, Response<ReqResult<ServerInfoResult>> response) {
                ServerInfoMapper.addServerInfo(model, response.body().getResult());
                processResponseServerInfo(model, callback);
            }

            @Override
            public void onFailure(Call<ReqResult<ServerInfoResult>> call, Throwable t) {
                callback.onFailure(t);
            }
        });

        mPhonexiaApi.getTechnologiesAvailable().enqueue(new Callback<ReqResult<TechnologiesResult>>() {
            @Override
            public void onResponse(Call<ReqResult<TechnologiesResult>> call, Response<ReqResult<TechnologiesResult>> response) {
                ServerInfoMapper.addTechnologies(model, response.body().getResult());
                processResponseServerInfo(model, callback);
            }

            @Override
            public void onFailure(Call<ReqResult<TechnologiesResult>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    private void sendBytesToStream(byte[] data) {
        if (isStreamRunning()) {
            mPhonexiaApi.sendDataToStream(mStreamData.getStreamId(), data).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    for (StreamAnalyzer analyzer: mStreamData.getAnalyzers()) {
                        analyzer.pollResults();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }

    @Override
    public void startStream(int frequency, SdkCallback<Boolean> callback) {
        startStream(frequency, null, callback);
    }

    @Override
    public void startStream(final int frequency, final String pathToFile, final SdkCallback<Boolean> callback) {
        if (mStreamData != null && !mStreamData.isRunning()) {
            callback.onFailure(new StreamRunningException());
        }
        mStreamData = new StreamData();

        mPhonexiaApi.startStream(frequency, null, pathToFile).enqueue(new Callback<ReqResult<HttpStreamResult>>() {
            @Override
            public void onResponse(Call<ReqResult<HttpStreamResult>> call, Response<ReqResult<HttpStreamResult>> response) {
                mStreamData.setRunning(true);
                mStreamData.setFrequency(frequency);
                mStreamData.setPathToFile(pathToFile);
                mStreamData.setStreamId(response.body().getResult().getStream());

                callback.onSuccess(true);
            }

            @Override
            public void onFailure(Call<ReqResult<HttpStreamResult>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    @Override
    public boolean isStreamRunning() {
        return mStreamData != null && mStreamData.isRunning();
    }

    @Override
    public void stopStream(final SdkCallback<Boolean> callback) {
        if (isStreamRunning()) {
            mPhonexiaApi.closeStream(mStreamData.getStreamId()).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    callback.onSuccess(response.isSuccessful());
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    callback.onFailure(t);
                }
            });
        }
    }

    @Override
    public void attachStreamAnalyzer(StreamAnalyzer.Factory plugin, StreamAnalyzer.Callback analyzerCallback) {
        StreamAnalyzer analyzer = plugin
                .setPhonexiaSdk(this)
                .build();
        analyzer.attachAnalyzer(mStreamData.getStreamId());
    }


    @Override
    public IPhonexiaApi getPhonexiaApi() {
        return mPhonexiaApi;
    }

    private void processResponseServerInfo(ServerInfoModel model, SdkCallback<ServerInfoModel> callback) {
        if (model.isServerInfoLoaded() && model.isServerStatusLoaded() && model.isTechnologiesLoaded()) {
            callback.onSuccess(model);
        }
    }


}
