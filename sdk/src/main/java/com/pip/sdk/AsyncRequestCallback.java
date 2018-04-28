package com.pip.sdk;

/**
 * Created by filipsollar on 19.4.18
 */
public interface AsyncRequestCallback<T> {
    void onResponse(T response);
    void onFailure(Throwable t);
    void onWsAttached();

}
