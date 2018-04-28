package com.pip.phonexiaapi.data.anns;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by filipsollar on 17.4.18
 */
@StringDef({Language.CZECH, Language.ENGLISH})
@Retention(RetentionPolicy.SOURCE)
public @interface Language {
    String CZECH = "CS_CZ";
    String ENGLISH = "ENGLISH";
}
