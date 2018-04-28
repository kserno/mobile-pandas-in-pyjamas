package com.pip.phonexiaapi.data.anns;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by filipsollar on 17.4.18
 */
@StringDef({SpeechToTextResultType.ONE_BEST, SpeechToTextResultType.N_BEST, SpeechToTextResultType.CONFUSION_NETWORK})
@Retention(RetentionPolicy.SOURCE)
public @interface SpeechToTextResultType {
    String ONE_BEST = "one_best";
    String N_BEST = "n_best";
    String CONFUSION_NETWORK = "confusion_network";
}
