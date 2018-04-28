package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.anns.Language;
import com.pip.phonexiaapi.data.common.OneBestResult;
import com.pip.phonexiaapi.data.common.TimeRange;

/**
 * Created by filipsollar on 17.4.18
 */
public class SpeechRecognitionOneBestResult extends BaseResult {
    @Language
    private String model;
    private String file;
    @SerializedName("delete_n_words")
    private int deleteNWords;
    @SerializedName("one_best_result")
    private OneBestResult recognitionResult;
    @SerializedName("time_range")
    private TimeRange timeRange;

    public String getModel() {
        return model;
    }

    public String getFile() {
        return file;
    }

    public int getDeleteNWords() {
        return deleteNWords;
    }

    public OneBestResult getRecognitionResult() {
        return recognitionResult;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }
}
