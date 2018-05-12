package com.pip.sdk.analyzers;

import com.pip.phonexiaapi.data.anns.Language;
import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.SpeakerIdentificationStreamMultiResult;
import com.pip.phonexiaapi.data.result.SpeechRecognitionOneBestResult;
import com.pip.phonexiaapi.data.result.SpeechRecognitionOnlineResult;
import com.pip.phonexiaapi.data.result.UserStreamTaskInfoResult;
import com.pip.sdk.IPhonexiaSdk;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by filipsollar on 29.4.18
 */
public class DictateAnalyzer extends StreamAnalyzer<SpeechRecognitionOnlineResult> {

    @Language
    private String mModel;

    protected DictateAnalyzer(IPhonexiaSdk phonexiaSdk, String model) {
        super(phonexiaSdk);
        mModel = model;
    }

    @Override
    protected void attachToStream(String streamId) {
        getPhonexiaSdk().getPhonexiaApi().attachDictateToStream(streamId, mModel, null).enqueue(new retrofit2.Callback<ReqResult<UserStreamTaskInfoResult>>() {
            @Override
            public void onResponse(Call<ReqResult<UserStreamTaskInfoResult>> call, Response<ReqResult<UserStreamTaskInfoResult>> response) {
                mTaskId = response.body().getResult().getStreamTaskInfo().getStreamId();
                getCallback().onAttach();
            }

            @Override
            public void onFailure(Call<ReqResult<UserStreamTaskInfoResult>> call, Throwable t) {
                getCallback().onFailure(t);
            }
        });
    }

    @Override
    public void pollResults() {
        getPhonexiaSdk().getPhonexiaApi().getDictateResults(mTaskId).enqueue(new retrofit2.Callback<ReqResult<SpeechRecognitionOnlineResult>>() {
            @Override
            public void onResponse(Call<ReqResult<SpeechRecognitionOnlineResult>> call, Response<ReqResult<SpeechRecognitionOnlineResult>> response) {
                getCallback().onData(response.body().getResult());
            }

            @Override
            public void onFailure(Call<ReqResult<SpeechRecognitionOnlineResult>> call, Throwable t) {
                getCallback().onFailure(t);
            }
        });
    }

    public static Factory create(String model) {
        return new Factory(model);
    }

    public static class Factory extends StreamAnalyzer.Factory<DictateAnalyzer> {

        private String mModel;

        public Factory(String model) {
            mModel = model;
        }

        @Override
        public DictateAnalyzer build() {
            return new DictateAnalyzer(getPhonexiaSdk(), mModel);
        }
    }
}

