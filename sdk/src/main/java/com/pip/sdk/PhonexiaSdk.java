package com.pip.sdk;



import com.pip.phonexiaapi.IPhonexiaApi;
import com.pip.phonexiaapi.PhonexiaApi;
import com.pip.sdk.data.ServerInfoModel;

import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by filipsollar on 18.4.18
 */
public class PhonexiaSdk implements IPhonexiaSdk {

    private IPhonexiaApi mPhonexiaApi;
    private StreamData mStreamData;

    public PhonexiaSdk() {
        mPhonexiaApi = new PhonexiaApi();

    }

    @Override
    public void loadServerInformation(SdkCallback<ServerInfoModel> callback) {
        Call<> call

        call



    }



    private <T> void call(Call<T> call, Callback<T> callback) {
        call.enqueue(callback);
    }





    class StreamData {
        private String streamId;
        private boolean isRunning;

        public String getStreamId() {
            return streamId;
        }

        public void setStreamId(String streamId) {
            this.streamId = streamId;
        }

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean running) {
            isRunning = running;
        }
    }

}
