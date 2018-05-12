package com.pip.sdk;

import com.pip.sdk.data.ServerInfoModel;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by filipsollar on 29.4.18
 */
@RunWith(JUnit4.class)
public class PhonexiaSdkTest {

    private IPhonexiaSdk mPhonexiaSdk;

    @Before
    public void setUp() throws Exception {
        mPhonexiaSdk = new PhonexiaSdk();
    }

    @Test
    public void shouldLoadServerInfoModelCorrectly() {
        System.out.println("test");
        mPhonexiaSdk.loadServerInformation(new SdkCallback<ServerInfoModel>() {
            @Override
            public void onSuccess(ServerInfoModel result) {
                Assert.assertTrue(!result.isServerStatusLoaded());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
