package com.pip.phonexiaapi;

import android.util.Log;

import com.google.gson.Gson;
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
import com.pip.phonexiaapi.request.SpeakerModels;
import com.pip.phonexiaapi.service.BasicService;
import com.pip.phonexiaapi.service.DiarizationService;
import com.pip.phonexiaapi.service.DictateService;
import com.pip.phonexiaapi.service.KeywordSpottingService;
import com.pip.phonexiaapi.service.SpeakerIdentificationService;
import com.pip.phonexiaapi.service.SpeechToTextService;
import com.pip.phonexiaapi.service.StreamService;
import com.pip.phonexiaapi.service.TimeAnalysisService;

import java.io.IOException;
import java.util.List;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by filipsollar on 19.4.18
 */
public class PhonexiaApi implements IPhonexiaApi {

    private static final String TAG = PhonexiaApi.class.getSimpleName();

    public static final String SERVER_API = "http://77.240.177.148:8601";

    public static final String USERNAME = "team2";
    public static final String PASS = "hackathon";

    private Retrofit mRetrofit;
    private OkHttpClient mClient;

    private Gson mGson = new Gson();

    private BasicService mBasicService;
    private StreamService mStreamService;
    private DictateService mDictateService;
    private DiarizationService mDiarizationService;
    private KeywordSpottingService mKeywordSpottingService;
    private SpeakerIdentificationService mSpeakerIdentificationService;
    private TimeAnalysisService mTimeAnalysisService;
    private SpeechToTextService mSpeechToTextService;


    public PhonexiaApi() {
        this(SERVER_API, USERNAME, PASS);
    }

    public PhonexiaApi(String baseUrl, final String username, final String password) {
        mClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        request = request.newBuilder()
                                .addHeader("Authorization",  Credentials.basic(username, password))
                                .build();

                        if (request.body() != null) {
                            Log.d(TAG, request.body().toString());
                        }
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(getInterceptor())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mClient)
                .baseUrl(baseUrl)
                .build();

        mBasicService = retrofit.create(BasicService.class);
        mStreamService = retrofit.create(StreamService.class);
        mDictateService = retrofit.create(DictateService.class);
        mSpeechToTextService = retrofit.create(SpeechToTextService.class);
        mDiarizationService = retrofit.create(DiarizationService.class);
        mKeywordSpottingService = retrofit.create(KeywordSpottingService.class);
        mSpeakerIdentificationService = retrofit.create(SpeakerIdentificationService.class);
        mTimeAnalysisService = retrofit.create(TimeAnalysisService.class);
    }

    @Override
    public Call<ReqResult<UserSessionResult>> login() {
        // return mBasicService.login(); todo
        return null;
    }

    @Override
    public Call<ReqResult<AudioFileInfoResult>> uploadAudioFile(String path, byte[] audioData) {
        RequestBody body = RequestBody.create(MediaType.parse("audio/wav"), audioData);
        return mBasicService.audiofile_post(path, body);
    }

    @Override
    public Call<ReqResult<TechnologiesResult>> getTechnologiesAvailable() {
        return mBasicService.technologies_get();
    }

    @Override
    public Call<ReqResult<TasksResult>> getRunningTasks() {
        return mBasicService.tasks_get();
    }

    @Override
    public Call<ReqResult<StatusResult>> getServerStatus() {
        return mBasicService.status_get();
    }

    @Override
    public Call<ReqResult<ServerInfoResult>> getServerInformation() {
        return mBasicService.serverInfo_get();
    }

    @Override
    public Call<ReqResult<DiarizationResult>> getDiarizationResults(String path, String model, Integer maxSpeakers, Integer totalSpeakers, Boolean cacheOnly, Boolean cacheDisable, Double fromTime, Double toTime) {
        return mDiarizationService.diarization_get(
                path,
                model,
                maxSpeakers,
                totalSpeakers,
                cacheOnly,
                cacheDisable,
                fromTime,
                toTime
        );
    }

    @Override
    public Call<ReqResult<UserStreamTaskInfoResult>> attachDictateToStream(String streamId, String model, String resultMode) {
        return mDictateService.dictate_post(streamId, model);
    }

    @Override
    public Call<ReqResult<SpeechRecognitionOnlineResult>> getDictateResults(String taskId) {
        return mDictateService.dictate_get(taskId);
    }

    @Override
    public Call<ReqResult<KeywordSpottingResult>> keywordSpotting(String path, String model, String keyWordList, Boolean cacheOnly, Boolean cacheDisable, Double fromTime, Double toTime) {
        return mKeywordSpottingService.keywordSpotting_get(
                path,
                model,
                keyWordList,
                cacheOnly,
                cacheDisable,
                fromTime,
                toTime
        );
    }

    @Override
    public Call<Void> createSpeakerModel(String name) {
        return mSpeakerIdentificationService.speakerModels_post(name);
    }

    @Override
    public Call<ReqResult<AudioFileInfoResult>> attachAudioFileToSpeakerModel(String userName, String path, RequestBody audioData) {
        return mSpeakerIdentificationService.speakerModels_audioFile_post(
                userName,
                path,
                audioData
        );
    }

    @Override
    public Call<Void> createGroup(String groupName) {
        return mSpeakerIdentificationService.groups_post(groupName);
    }

    @Override
    public Call<Void> addSpeakerModelsToGroup(String groupName, List<String> speakerModelNames) {
        SpeakerModels reqData = new SpeakerModels();
        reqData.setSpeakerNames(speakerModelNames);
        return mSpeakerIdentificationService.groups_speakerModel_post(groupName, reqData);
    }

    @Override
    public Call<Void> prepareSpeakerModel(String speakerName) {
        return mSpeakerIdentificationService.speakerModels_prepare_put(speakerName);
    }

    @Override
    public Call<Void> prepareGroup(String groupName) {
        return mSpeakerIdentificationService.groups_prepare_put(groupName);
    }

    @Override
    public Call<ReqResult<UserStreamTaskInfoResult>> attachSidToStream(String groupName, String streamId) {
        return mSpeakerIdentificationService.stream_post(groupName, streamId);
    }

    @Override
    public Call<ReqResult<SpeakerIdentificationStreamMultiResult>> getSidStreamResults(String taskId) {
        return mSpeakerIdentificationService.stream_get(taskId);
    }

    @Override
    public Call<ReqResult<SpeakerIdentificationModelsResult>> getSpeakerModels() {
        return mSpeakerIdentificationService.speakerModels_get();
    }

    @Override
    public Call<ReqResult<SpeechRecognitionOneBestResult>> speechToText(String path, String model, String resultType, Boolean cacheOnly, Boolean cacheDisable, Double fromTime, Double toTime) {
        return mSpeechToTextService.stt_get(
                path,
                model,
                resultType,
                cacheOnly,
                cacheDisable,
                fromTime,
                toTime
        );
    }

    @Override
    public Call<ReqResult<HttpStreamResult>> startStream(int frequency, Integer numberOfChannels, String pathToFile) {
        return mStreamService.httpStream_post(frequency, numberOfChannels, pathToFile);
    }

    @Override
    public Call<Void> sendDataToStream(String streamId, byte[] data) {
        RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), data);
        return mStreamService.httpStream_put(streamId, body);
    }

    @Override
    public Call<Void> closeStream(String streamId) {
        return mStreamService.httpStream_delete(streamId);
    }

    @Override
    public Call<ReqResult<TimeAnalysisResult>> timeAnalysis(String path, String model, Boolean segmentation, Boolean cacheOnly, Boolean cacheDisable, Double fromTime, Double toTime) {
        return mTimeAnalysisService.timeAnalysis_get(
                path,
                model,
                segmentation,
                cacheOnly,
                cacheDisable,
                fromTime,
                toTime
        );
    }

    @Override
    public Call<ReqResult<TimeAnalysisStreamResult>> getTimeAnalysisStreamResults(String taskId) {
        return mTimeAnalysisService.timeAnalysis_stream_get(taskId);
    }

    @Override
    public Call<ReqResult<UserStreamTaskInfoResult>> attachTimeAnalysisToStream(String streamId, String model) {
        return mTimeAnalysisService.timeAnalysis_stream_post(streamId, model);
    }

    private Interceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }
}
