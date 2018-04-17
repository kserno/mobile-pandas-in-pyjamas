package com.pip.sdk;

import com.pip.sdk.data.BaseResponseModel;

/**
 * Created by filipsollar on 17.4.18
 */
public interface SdkCallback<T extends BaseResponseModel> {
    void onSuccess(T result);
    void onFailure(Throwable t);
}
