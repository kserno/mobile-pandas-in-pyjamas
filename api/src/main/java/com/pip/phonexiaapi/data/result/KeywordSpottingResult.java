package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.anns.Language;
import com.pip.phonexiaapi.data.common.Segment;
import com.pip.phonexiaapi.data.common.TimeRange;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class KeywordSpottingResult extends BaseResult {
    private String file;
    @Language
    private String model;
    @SerializedName("keyword_list")
    private String keywordList;
    @SerializedName("time_range")
    private TimeRange timeRange;
    private List<Segment> words;

    public String getFile() {
        return file;
    }

    public String getModel() {
        return model;
    }

    public String getKeywordList() {
        return keywordList;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public List<Segment> getWords() {
        return words;
    }
}
