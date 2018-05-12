package com.pip.phonexiaapi;

import android.support.test.runner.AndroidJUnit4;

import com.pip.phonexiaapi.data.common.ReqResult;
import com.pip.phonexiaapi.data.result.ServerInfoResult;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;


/**
 * Created by filipsollar on 1.5.18
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTes {

    private PhonexiaApi mApi;

    @Before
    public void setUp() throws Exception {
        mApi = new PhonexiaApi();
    }

    @Test
    public void shouldWork() {
        try {
            ReqResult<ServerInfoResult> result = mApi.getServerInformation().execute().body();
            System.out.println(result.toString());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}
