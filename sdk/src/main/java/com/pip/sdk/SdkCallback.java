package com.pip.sdk;

/**
 * Created by filipsollar on 17.4.18
 */
public interface SdkCallback<T> {
    void onSuccess(T result);
    void onFailure(Throwable t);
}
