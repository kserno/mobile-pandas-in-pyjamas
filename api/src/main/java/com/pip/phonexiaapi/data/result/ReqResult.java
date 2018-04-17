package com.pip.phonexiaapi.data.result;

import com.pip.phonexiaapi.data.BaseResponse;

/**
 * Created by filipsollar on 6.4.18.
 */

public class ReqResult<T extends BaseResponse> {
    private T result;

    public T getResult() {
        return result;
    }
}
