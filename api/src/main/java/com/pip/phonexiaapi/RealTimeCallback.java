package com.pip.phonexiaapi;

/**
 * Created by filipsollar on 6.4.18.
 */

public interface RealTimeCallback<T>{
    void onStarted();
    void onError(Throwable t);
    void onResult(T result);
    void finished();


}