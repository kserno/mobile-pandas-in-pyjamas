package com.pip.sdk;

import com.pip.phonexiaapi.data.result.DiarizationResult;
import com.pip.phonexiaapi.data.result.KeywordSpottingResult;
import com.pip.phonexiaapi.data.result.SpeechRecognitionOneBestResult;
import com.pip.phonexiaapi.data.result.TimeAnalysisResult;

import java.util.List;

/**
 * Created by filipsollar on 19.4.18
 */
public interface IPhonexiaQuickAccess {
    void diarization(AsyncRequestCallback<DiarizationResult> asyncCallback);
    void speechToText(AsyncRequestCallback<SpeechRecognitionOneBestResult> asyncCallback);
    void keywordSpotting(AsyncRequestCallback<KeywordSpottingResult> asyncCallback);
    void timeAnalysis(AsyncRequestCallback<TimeAnalysisResult> asyncCallback);

    void startStream();
    void stopStream();

    void attachDictate();
    void attachDiarization();
    void attachTimeAnalysis();
    void attachSpeakerIdentification();

    void createAndPrepareGroup(List<String> speakerModels);
    void createSpeakerModelAndAttachAudioFile();







}
