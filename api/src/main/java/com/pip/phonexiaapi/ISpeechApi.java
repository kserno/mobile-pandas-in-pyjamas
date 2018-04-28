package com.pip.phonexiaapi;

import com.pip.phonexiaapi.data.result.AudioFileInfoResult;

import java.io.File;
import java.util.List;

/**
 * Created by filipsollar on 6.4.18.
 */

public interface ISpeechApi {


    void realTimeProcessing(
            int frequency,
            Language language,
            RealTimeCallback<SpeechRecognitionResult> realTimeCallback
    );

    RecorderCallback getCallback();

    void createSpeakerModel(String userName, File wavFile, ApiCallback<AudioFileInfoResult> callback);

    void getUserModels(ApiCallback<List<String>> callback);

    void stopProcessing();

    void createAndPrepareGroup(List<String> userModels, String groupName, ApiCallback<Boolean> callback);

    void speechToText(String path, ApiCallback callback);

    Call

}
