package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.anns.Language;
import com.pip.phonexiaapi.data.common.OneBestResult;

/**
 * Created by filipsollar on 17.4.18
 */
public class SpeechRecognitionOnlineResult extends BaseResult {
    @Language
    private String model;
    @SerializedName("is_last")
    private boolean isLast;
    @SerializedName("delete_n_words")
    private int deleteNWords;
    @SerializedName("one_best_result")
    private OneBestResult recognitionResult;

    @Language
    public String getModel() {
        return model;
    }

    public boolean isLast() {
        return isLast;
    }

    public int getDeleteNWords() {
        return deleteNWords;
    }

    public OneBestResult getRecognitionResult() {
        return recognitionResult;
    }

}
