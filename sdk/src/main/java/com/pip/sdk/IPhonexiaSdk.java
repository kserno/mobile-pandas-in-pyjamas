package com.pip.sdk;

import com.pip.phonexiaapi.IPhonexiaApi;
import com.pip.sdk.analyzers.StreamAnalyzer;
import com.pip.sdk.data.ServerInfoModel;

/**
 * Created by filipsollar on 17.4.18
 */
public interface IPhonexiaSdk {

    /**
     * Aggregated call
     * Loads server status and information
     * @param callback
     */
    void loadServerInformation(SdkCallback<ServerInfoModel> callback);

    void startStream(int frequency, SdkCallback<Boolean> callback);
    void startStream(int frequency, String pathToFile, SdkCallback<Boolean> callback);
    boolean isStreamRunning();

    void stopStream(SdkCallback<Boolean> callback);

    void attachStreamAnalyzer(StreamAnalyzer.Factory plugin, StreamAnalyzer.Callback analyzerCallback);

    /*boolean isStreamRunning();

    void speechToText();
    void diarization();
    void timeAnalysis();*/

    IPhonexiaApi getPhonexiaApi();

}
