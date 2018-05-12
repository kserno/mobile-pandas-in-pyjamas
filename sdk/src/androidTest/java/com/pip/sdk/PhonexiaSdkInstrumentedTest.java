package com.pip.sdk;

import android.support.test.runner.AndroidJUnit4;

import com.pip.phonexiaapi.data.anns.Language;
import com.pip.sdk.analyzers.DictateAnalyzer;
import com.pip.sdk.analyzers.StreamAnalyzer;
import com.pip.sdk.data.ServerInfoModel;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by filipsollar on 3.5.18
 */
@RunWith(AndroidJUnit4.class)
public class PhonexiaSdkInstrumentedTest {

    private PhonexiaSdk mPhonexiaSdk;

    @Before
    public void setUp() throws Exception {
        mPhonexiaSdk = new PhonexiaSdk();
    }

    @Test
    public void shouldLoadServerInfoModel_correctly() {
        mPhonexiaSdk.loadServerInformation(new SdkCallback<ServerInfoModel>() {
            @Override
            public void onSuccess(ServerInfoModel result) {
                Assert.assertNotNull(result);
                Assert.assertTrue(result.isServerInfoLoaded());
                Assert.assertTrue(result.isServerStatusLoaded());
                Assert.assertTrue(result.isTechnologiesLoaded());
                System.out.println(result.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Assert.fail(t.getMessage());
            }
        });

    }

    @Test
    public void shouldStartStream() {
        int frequency = 4000;
        mPhonexiaSdk.startStream(frequency, new SdkCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                Assert.assertTrue(result);
                Assert.assertTrue(mPhonexiaSdk.isStreamRunning());
            }

            @Override
            public void onFailure(Throwable t) {
                Assert.fail(t.getMessage());
            }
        });
    }

    @Test
    public void shouldNotAttachAnalyzer_streamNotRunning() {
        System.out.println("sna");
        mPhonexiaSdk.attachStreamAnalyzer(DictateAnalyzer.create(Language.ENGLISH), new StreamAnalyzer.Callback() {
            @Override
            public void onAttach() {
                Assert.fail();
            }

            @Override
            public void onData(Object data) {
                Assert.fail();
            }

            @Override
            public void onClose() {
                Assert.fail();

            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
