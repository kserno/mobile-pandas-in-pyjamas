package com.pip.phonexiaapi;

import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.ServerInfoResult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by filipsollar on 1.5.18
 */
@RunWith(JUnit4.class)
public class BasicServiceTest {

    private PhonexiaApi mApi;

    @Before
    public void setUp() throws Exception {
        mApi = new PhonexiaApi();
    }

    @Test
    public void shouldLoadServerInfoCorrectly() {

    }
}
