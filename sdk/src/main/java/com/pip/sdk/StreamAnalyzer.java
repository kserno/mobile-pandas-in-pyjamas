package com.pip.sdk;

import com.pip.phonexiaapi.data.result.BaseResult;

import java.lang.reflect.Method;

/**
 * Created by filipsollar on 18.4.18
 */
public abstract class StreamAnalyzer<T extends BaseResult> {

    private IPhonexiaSdk mPhonexiaSdk;
    private StreamAnalyzerCallback<T> mCallback;

    public StreamAnalyzer(IPhonexiaSdk phonexiaSdk, StreamAnalyzer<>) {
        mPhonexiaSdk = phonexiaSdk;
    }

    public void attachAnalyzer() {
        if (!mPhonexiaSdk.isStreamRunning()) {
            mPhonexiaSdk.startStream();


        }



    }

    public StreamAnalyzerCallback<T> getCallback() {
        return mCallback;
    }

    protected abstract void attach();

    interface StreamAnalyzerCallback<T> {
        void onAttach();
        void onData(T data);
        void onClose();
        void onFailure(Throwable t);
    }
}
