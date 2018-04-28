package com.pip.sdk;

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

    /*void startStream();
    void stopStream();

    void attachStreamAnalyzer(StreamAnalyzer streamAnalyzer);

    boolean isStreamRunning();

    void speechToText();
    void diarization();
    void timeAnalysis();*/

}
