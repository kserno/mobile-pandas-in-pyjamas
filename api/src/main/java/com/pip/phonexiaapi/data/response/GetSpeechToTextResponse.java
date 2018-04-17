package com.pip.phonexiaapi.data.response;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.BaseResponse;
import com.pip.phonexiaapi.data.Language;
import com.pip.phonexiaapi.data.result.OneBestResult;

/**
 * Created by filipsollar on 17.4.18
 */
public class GetSpeechToTextResponse extends BaseResponse {
    private Language model;
    @SerializedName("is_last")
    private boolean isLast;
    @SerializedName("delete_n_words")
    private int deleteNWords;
    @SerializedName("one_best_result")
    private OneBestResult recognitionResult;

    public Language getModel() {
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
