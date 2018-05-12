package com.pip.sdk.analyzers;

import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.SpeakerIdentificationStreamMultiResult;
import com.pip.phonexiaapi.data.result.SpeechRecognitionOnlineResult;
import com.pip.phonexiaapi.data.result.UserStreamTaskInfoResult;
import com.pip.sdk.IPhonexiaSdk;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by filipsollar on 29.4.18
 */
public class SpeakerIdentificationAnalyzer extends StreamAnalyzer<SpeakerIdentificationStreamMultiResult> {

    private String mGroupName;

    protected SpeakerIdentificationAnalyzer(IPhonexiaSdk phonexiaSdk, String groupName) {
        super(phonexiaSdk);
        mGroupName = groupName;
    }

    @Override
    protected void attachToStream(String streamId) {
        getPhonexiaSdk().getPhonexiaApi().attachSidToStream(mGroupName, streamId).enqueue(new retrofit2.Callback<ReqResult<UserStreamTaskInfoResult>>() {
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
        getPhonexiaSdk().getPhonexiaApi().getSidStreamResults(mTaskId).enqueue(new retrofit2.Callback<ReqResult<SpeakerIdentificationStreamMultiResult>>() {
            @Override
            public void onResponse(Call<ReqResult<SpeakerIdentificationStreamMultiResult>> call, Response<ReqResult<SpeakerIdentificationStreamMultiResult>> response) {
                getCallback().onData(response.body().getResult());
            }

            @Override
            public void onFailure(Call<ReqResult<SpeakerIdentificationStreamMultiResult>> call, Throwable t) {
                getCallback().onFailure(t);
            }
        });
    }


    public static Factory create(String groupName) {
        return new Factory(groupName);
    }

    public static class Factory extends StreamAnalyzer.Factory<SpeakerIdentificationAnalyzer> {

        private String mGroupName;

        public Factory(String groupName) {
            mGroupName = groupName;
        }

        @Override
        public SpeakerIdentificationAnalyzer build() {
            return new SpeakerIdentificationAnalyzer(getPhonexiaSdk(), mGroupName);
        }
    }
}
