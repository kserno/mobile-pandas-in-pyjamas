package com.pip.phonexiaapi;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pip.phonexiaapi.data.result.AudioFileInfoResult;
import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.common.Technology;
import com.pip.phonexiaapi.request.SpeakerModels;
import com.pip.phonexiaapi.service.BasicService;
import com.pip.phonexiaapi.service.DiarizationService;
import com.pip.phonexiaapi.service.DictateService;
import com.pip.phonexiaapi.service.KeywordSpottingService;
import com.pip.phonexiaapi.service.PhonexiaService;
import com.pip.phonexiaapi.service.SpeakerIdentificationService;
import com.pip.phonexiaapi.service.StreamService;
import com.pip.phonexiaapi.service.TimeAnalysisService;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by filipsollar on 6.4.18.
 */

public class SpeechApi {

    /**
    public static final int SUCCESS_CODE = 200;
    public static final int PENDING_CODE = 202;

    public static final String RECORD = "/record.wav";
    public static final String SERVER_API = "http://77.240.177.148:8601";

    public static final String USERNAME = "team2";
    public static final String PASS = "hackathon";

    private Retrofit mRetrofit;
    private OkHttpClient mClient;

    private Gson mGson = new Gson();

    private PhonexiaService mPhonexiaService;

    private BasicService mBasicService;
    private StreamService mStreamService;
    private DictateService mDictateService;
    private DiarizationService mDiarizationService;
    private KeywordSpottingService mKeywordSpottingService;
    private SpeakerIdentificationService mSpeakerIdentificationService;
    private TimeAnalysisService mTimeAnalysisService;

    /*private String mStreamId;
    private String mTaskId;
    private String mRecognitionTaskId;

    private static final String TAG = SpeechApi.class.getSimpleName();

    private RecorderCallback mRecorderCallback = new RecorderCallback() {

        @Override
        public void onRecording(byte[] data) {
            sendData(mStreamId, mTaskId, data);
        }

        @Override
        public void finished() {

        }
    };

    private RealTimeCallback<SpeechRecognitionResult> mCallback;

    public SpeechApi() {
        mClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        request = request.newBuilder()
                                .addHeader("Authorization",  Credentials.basic(USERNAME, PASS))
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
                .baseUrl(SERVER_API)
                .build();


        mPhonexiaService = retrofit.create(PhonexiaService.class);
    }

    @Override
    public void realTimeProcessing(int frequency, Language language, final RealTimeCallback<SpeechRecognitionResult> realTimeCallback) {
        mCallback = realTimeCallback;

        checkTechnologiesDictate(frequency, language);
        //startStream(frequency, language);


    }

    private void checkTechnologiesDictate(final int frequency, final Language language) {
        mPhonexiaService.getTechnologiesAvailable()
                .enqueue(new Callback<ReqResult<GetTechnologiesResponse>>() {
                    @Override
                    public void onResponse(Call<ReqResult<GetTechnologiesResponse>> call, Response<ReqResult<GetTechnologiesResponse>> response) {
                        if (checkTechnologiesResult(response.body().getResult(), "Dictate")) {
                            startStream(frequency, language);
                        }
                    }

                    @Override
                    public void onFailure(Call<ReqResult<GetTechnologiesResponse>> call, Throwable t) {
                        mCallback.onError(t);
                    }
                });

    }

    private void startStream(int frequency, final Language language) {


        mPhonexiaService.startStream(frequency, null, "/test.wav")
                .enqueue(new Callback<ReqResult<StreamResult>>() {

                    @Override
                    public void onResponse(Call<ReqResult<StreamResult>> call, Response<ReqResult<StreamResult>> response) {
                        mStreamId = response.body().getResult().getStream();
                        attachDictate(language);
                    }

                    @Override
                    public void onFailure(Call<ReqResult<StreamResult>> call, Throwable t) {
                        mCallback.onError(t);
                    }
                });

    }


    private void attachDictate(Language language) {
        mPhonexiaService.attachDictate(mStreamId, language)
                .enqueue(new Callback<ReqResult<AttachDictateResult>>() {
                    @Override
                    public void onResponse(Call<ReqResult<AttachDictateResult>> call, Response<ReqResult<AttachDictateResult>> response) {
                        mTaskId = response.body().getResult().getStreamTaskInfo().getId();
                        mCallback.onStarted();
                    }

                    @Override
                    public void onFailure(Call<ReqResult<AttachDictateResult>> call, Throwable t) {
                        mCallback.onError(t);
                    }
                });



    }


    private void sendData(String streamId, final String taskId, byte[] data) {
        if (streamId == null || taskId == null) {
            return;
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), data);
        mPhonexiaService.sendChunksOfData(streamId, body)
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.code() == SUCCESS_CODE) { // SUCCESS
                            sendResultBack(taskId);
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        mCallback.onError(t);
                    }
                });


    }

    private void sendResultBack(String taskId) {
        mPhonexiaService.getResults(taskId)
                .enqueue(new Callback<ReqResult<SpeechRecognitionResult>>() {
                    @Override
                    public void onResponse(Call<ReqResult<SpeechRecognitionResult>> call, Response<ReqResult<SpeechRecognitionResult>> response) {
                        mCallback.onResult(response.body().getResult());
                    }

                    @Override
                    public void onFailure(Call<ReqResult<SpeechRecognitionResult>> call, Throwable t) {
                        mCallback.onError(t);
                    }
                });


        if (mRecognitionTaskId == null) {
            return;
        }

        mPhonexiaService.getSpeakersResults(mRecognitionTaskId)
                .enqueue(new Callback<ReqResult<SpeakersResult>>() {
                    @Override
                    public void onResponse(Call<ReqResult<SpeakersResult>> call, Response<ReqResult<SpeakersResult>> response) {
                        if (response.body() != null) {
                            mCallback.onSpeakerResult(response.body().getResult());
                        }
                    }

                    @Override
                    public void onFailure(Call<ReqResult<SpeakersResult>> call, Throwable t) {
                        mCallback.onError(t);
                    }

                });
    }


    private boolean checkTechnologiesResult(GetTechnologiesResponse result, String techName) {
        for (Technology technology:result.getTechnologies()) {
            if (technology.getName().equals(techName)) {
                return true;
            }
        }

        return false;
    }

    private Interceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }


    public RecorderCallback getCallback() {
        return mRecorderCallback;
    }


    @Override
    public void createSpeakerModel(final String userName, final File wavFile, final ApiCallback<AudioFileInfoResult> callback) {
        mPhonexiaService.createSpeaker(userName).enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                uploadWavFileToSpeakerModel(userName, wavFile, callback);

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t);
            }

        });
    }

    public void getUserModels(final ApiCallback<List<String>> callback) {
        mPhonexiaService.getSpeakerModels().enqueue(new Callback<ReqResult<SpeakerModelsResponse>>() {
            @Override
            public void onResponse(Call<ReqResult<SpeakerModelsResponse>> call, Response<ReqResult<SpeakerModelsResponse>> response) {
                callback.onSuccess(response.body().getResult().getModels());
            }

            @Override
            public void onFailure(Call<ReqResult<SpeakerModelsResponse>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    @Override
    public void stopProcessing() {
        mPhonexiaService.closeStream(mStreamId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    @Override
    public void createAndPrepareGroup(final List<String> userModels, final String groupName, final ApiCallback<Boolean> callback) {
        mPhonexiaService.createSpeakerGroup(groupName).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void>response) {
                addUsersToGroup(userModels, groupName, callback);
            }


            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    @Override
    public void speechToText(String path, ApiCallback callback) {

    }


    private void addUsersToGroup(List<String> userModels, final String groupName, final ApiCallback<Boolean> callback) {
        SpeakerModels models = new SpeakerModels();

        models.setSpeakerNames(userModels);

        mPhonexiaService.addToSpeakerGroup(groupName, models).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                prepareGroup(groupName, callback);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t);
            }


        });
    }

    private void prepareGroup(final String groupName, final ApiCallback<Boolean> callback) {
        mPhonexiaService.prepareSpeakerGroup(groupName).
                enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.code() == PENDING_CODE) {
                            String location = response.headers().get("Location");
                            location = location.substring(9, location.length());
                            System.out.println(location);
                            hookWebSocket(location, new ApiCallback<BaseResponse>() {
                                @Override
                                public void onSuccess(BaseResponse result) {
                                    callback.onSuccess(true);
                                }

                                @Override
                                public void onFailure(Throwable t) {
                                    callback.onFailure(t);
                                }
                            });
                        } else {

                            registerSidToStream(groupName, callback);
                        }
                    }


                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        callback.onFailure(t);
                    }
                });
    }

    private void registerSidToStream(String groupName, final ApiCallback<Boolean> callback) {
        mPhonexiaService.addSidToStream(groupName, mStreamId)
                .enqueue(new Callback<ReqResult<SpeakerStreamResult>>() {
                    @Override
                    public void onResponse(Call<ReqResult<SpeakerStreamResult>> call, Response<ReqResult<SpeakerStreamResult>> response) {
                        callback.onSuccess(true);
                        mRecognitionTaskId = response.body().getResult().getStreamTaskInfo().getId();
                    }

                    @Override
                    public void onFailure(Call<ReqResult<SpeakerStreamResult>> call, Throwable t) {
                        callback.onFailure(t);
                    }
        });
    }

    private void startChecking(ApiCallback<Boolean> callback) {
        // TODO !!!!!
    }

    private void uploadWavFileToSpeakerModel(String userName, File wavFile, final ApiCallback<AudioFileInfoResult> callback) {
        RequestBody body = RequestBody.create(MediaType.parse("audio/wav"), wavFile );

        mPhonexiaService.attachAudioFileToSpeaker(userName, RECORD,body)
                .enqueue(new Callback<ReqResult<AudioFileInfoResult>>() {
                    @Override
                    public void onResponse(Call<ReqResult<AudioFileInfoResult>> call, Response<ReqResult<AudioFileInfoResult>> response) {
                        callback.onSuccess(response.body().getResult());
                    }

                    @Override
                    public void onFailure(Call<ReqResult<AudioFileInfoResult>> call, Throwable t) {
                        t.printStackTrace();
                        callback.onFailure(t);
                    }
                });
    }


    private <T extends BaseResponse> void hookWebSocket(String location, ApiCallback<T> apiCallback) {
        String url = SERVER_API + "/pending/" + location;

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Connection", "Upgrade")
                .addHeader("Upgrade", "websocket")
                .addHeader("Sec-WebSocket-Version", "13")
                .addHeader("Sec-WebSocket-Key", "")
                .build();

        AsynchronousRequestListener listener = new AsynchronousRequestListener(location, apiCallback);
        WebSocket webSocket = mClient.newWebSocket(request, listener);
    }



    private class AsynchronousRequestListener<T extends BaseResponse> extends WebSocketListener {

        private String mLocation;
        private ApiCallback<T> mApiCallback;

        public AsynchronousRequestListener(String location, ApiCallback<T> apiCallback) {
            mLocation = location;
            mApiCallback = apiCallback;
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);
            Type type = new TypeToken<ReqResult<T>>() {}.getType();
            ReqResult<T> result = mGson.fromJson(text, type);

            mApiCallback.onSuccess(result.getResult());
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, okhttp3.Response response) {
            super.onFailure(webSocket, t, response);
            hookWebSocket(mLocation, mApiCallback); // retry on failure
        }
    }
    */
}
