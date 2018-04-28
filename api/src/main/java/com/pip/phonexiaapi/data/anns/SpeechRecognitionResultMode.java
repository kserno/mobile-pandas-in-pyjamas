package com.pip.phonexiaapi.data.anns;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by filipsollar on 17.4.18
 */
@StringDef({SpeechRecognitionResultMode.COMPLETE, SpeechRecognitionResultMode.INCREMENTAL})
@Retention(RetentionPolicy.SOURCE)
public @interface SpeechRecognitionResultMode {
    String COMPLETE = "complete";
    String INCREMENTAL = "incremental";
}
