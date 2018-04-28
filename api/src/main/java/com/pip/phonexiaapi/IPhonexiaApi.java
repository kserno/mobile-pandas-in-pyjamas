package com.pip.phonexiaapi;

import com.pip.phonexiaapi.data.anns.Language;
import com.pip.phonexiaapi.data.anns.SpeechRecognitionResultMode;
import com.pip.phonexiaapi.data.anns.SpeechToTextResultType;
import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.AudioFileInfoResult;
import com.pip.phonexiaapi.data.result.DiarizationResult;
import com.pip.phonexiaapi.data.result.HttpStreamResult;
import com.pip.phonexiaapi.data.result.KeywordSpottingResult;
import com.pip.phonexiaapi.data.result.ServerInfoResult;
import com.pip.phonexiaapi.data.result.SpeakerIdentificationModelsResult;
import com.pip.phonexiaapi.data.result.SpeakerIdentificationMultiResult;
import com.pip.phonexiaapi.data.result.SpeakerIdentificationStreamMultiResult;
import com.pip.phonexiaapi.data.result.SpeechRecognitionOneBestResult;
import com.pip.phonexiaapi.data.result.SpeechRecognitionOnlineResult;
import com.pip.phonexiaapi.data.result.StatusResult;
import com.pip.phonexiaapi.data.result.TasksResult;
import com.pip.phonexiaapi.data.result.TechnologiesResult;
import com.pip.phonexiaapi.data.result.TimeAnalysisResult;
import com.pip.phonexiaapi.data.result.TimeAnalysisStreamResult;
import com.pip.phonexiaapi.data.result.UserSessionResult;
import com.pip.phonexiaapi.data.result.UserStreamTaskInfoResult;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by filipsollar on 17.4.18
 */
public interface IPhonexiaApi {
    // <--------- BasicService start--------->
    Call<ReqResult<UserSessionResult>> login();
    Call<ReqResult<AudioFileInfoResult>> uploadAudioFile(String path, byte[] audioData);
    Call<ReqResult<TechnologiesResult>> getTechnologiesAvailable();
    Call<ReqResult<TasksResult>> getRunningTasks();
    Call<ReqResult<StatusResult>> getServerStatus();
    Call<ReqResult<ServerInfoResult>> getServerInformation();
    // <--------- BasicService end--------->
    // <--------- DiarizationService start--------->
    Call<ReqResult<DiarizationResult>> getDiarizationResults(
            String path,
            String model,
            Integer maxSpeakers,
            Integer totalSpeakers,
            Boolean cacheOnly,
            Boolean cacheDisable,
            Double fromTime,
            Double toTime
    );
    // <--------- DiarizationService end--------->
    // <--------- DictateService start--------->
    Call<ReqResult<UserStreamTaskInfoResult>> attachDictateToStream(
            String streamId,
            @Language String model,
            @SpeechRecognitionResultMode String resultMode
    );
    Call<ReqResult<SpeechRecognitionOnlineResult>> getDictateResults(
            String taskId
    );
    // <--------- DictateService end---------->
    // <--------- KeywordSpottingService start---------->
    Call<ReqResult<KeywordSpottingResult>> keywordSpotting(
            String path,
            @Language String model,
            String keyWordList,
            Boolean cacheOnly,
            Boolean cacheDisable,
            Double fromTime,
            Double toTime
    );
    // <--------- KeywordSpottingService end---------->
    // <--------- SIDService begin ----------->
    Call<Void> createSpeakerModel(String name);
    Call<ReqResult<AudioFileInfoResult>> attachAudioFileToSpeakerModel(
            String userName,
            String path,
            RequestBody audioData
    );
    Call<Void> createGroup(String groupName);
    Call<Void> addSpeakerModelsToGroup(String groupName, List<String> speakerModelNames);
    Call<Void> prepareSpeakerModel(String speakerName);
    Call<Void> prepareGroup(String groupName);
    Call<ReqResult<UserStreamTaskInfoResult>> attachSidToStream(
            String groupName,
            String streamId
    );
    Call<ReqResult<SpeakerIdentificationStreamMultiResult>> getSidRealTimeResults(String taskId);
    Call<ReqResult<SpeakerIdentificationModelsResult>> getSpeakerModels();
    // <--------- SIDService end ------------->
    // <--------- STT Service begin ---------->
    Call<ReqResult<SpeechRecognitionOneBestResult>> speechToText(
            String path,
            @Language String model,
            @SpeechToTextResultType String resultType,
            Boolean cacheOnly,
            Boolean cacheDisable,
            Double fromTime,
            Double toTime
    );
    // <--------- STT Service end ------------>
    // <--------- Stream Service begin ------->
    Call<ReqResult<HttpStreamResult>> startStream(
            int frequency,
            Integer numberOfChannels,
            String pathToFile // path to file where saved if not set no data is saved
    );
    Call<Void> sendDataToStream(
            String streamId,
            byte[] data
    );
    Call<Void> closeStream(
            String streamId
    );
    // <--------- Stream Service end --------->
    // <--------- TimeAnalysis Service begin --------->
    Call<ReqResult<TimeAnalysisResult>> timeAnalysis(
            String path,
            String model, // time analysis model
            Boolean segmentation,
            Boolean cacheOnly,
            Boolean cacheDisable,
            Double fromTime,
            Double toTime
    );
    Call<ReqResult<TimeAnalysisStreamResult>> getTimeAnalysisStreamResults(
            String taskId
    );
    Call<ReqResult<UserStreamTaskInfoResult>> attachTimeAnalysisToStream(
            String streamId,
            String model
    );
    // <--------- TimeAnalysis Service end --------->





}
