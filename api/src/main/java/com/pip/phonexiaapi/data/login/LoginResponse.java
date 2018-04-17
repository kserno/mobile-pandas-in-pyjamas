package com.pip.phonexiaapi.data.login;

import com.pip.phonexiaapi.data.BaseResponse;

/**
 * Created by filipsollar on 16.4.18
 */
public class LoginResponse extends BaseResponse {

    private UserSessionResult session;

    public UserSessionResult getSession() {
        return session;
    }
}
