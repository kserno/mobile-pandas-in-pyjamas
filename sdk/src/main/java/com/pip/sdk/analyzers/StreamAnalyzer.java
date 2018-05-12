package com.pip.sdk.analyzers;

import android.text.TextUtils;

import com.pip.phonexiaapi.data.result.BaseResult;
import com.pip.sdk.IPhonexiaSdk;
import com.pip.sdk.PhonexiaSdk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by filipsollar on 18.4.18
 */
public abstract class StreamAnalyzer<T extends BaseResult> {

    private IPhonexiaSdk mPhonexiaSdk;
    private Callback<T> mCallback;
    protected String mTaskId;


    protected StreamAnalyzer(IPhonexiaSdk phonexiaSdk) {
        mPhonexiaSdk = phonexiaSdk;
    }

    public void attachAnalyzer(String streamId) {
        if (!mPhonexiaSdk.isStreamRunning() || streamId == null || TextUtils.isEmpty(streamId)) {
            throw new RuntimeException("You need to start stream first !");
        }
        attachToStream(streamId);
    }

    protected Callback<T> getCallback() {
        return mCallback;
    }

    public void setCallback(Callback<T> callback) {
        mCallback = callback;
    }

    protected IPhonexiaSdk getPhonexiaSdk() {
        return mPhonexiaSdk;
    }

    protected abstract void attachToStream(String streamId);
    public abstract void pollResults();

    public interface Callback<T> {
        void onAttach();
        void onData(T data);
        void onClose();
        void onFailure(Throwable t);
    }

    public static abstract class Factory<ANALYZER extends StreamAnalyzer<?>> {
        private PhonexiaSdk mPhonexiaSdk;

        public Factory setPhonexiaSdk(PhonexiaSdk phonexiaSdk) {
            mPhonexiaSdk = phonexiaSdk;
            return this;
        }

        public PhonexiaSdk getPhonexiaSdk() {
            return mPhonexiaSdk;
        }

        public abstract ANALYZER build();
    }
}
