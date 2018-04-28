package com.pip.phonexiaapi.data.common;

import com.pip.phonexiaapi.data.result.BaseResult;

/**
 * Created by filipsollar on 6.4.18.
 */

public class ReqResult<T extends BaseResult> {
    private T result;

    public T getResult() {
        return result;
    }
}
