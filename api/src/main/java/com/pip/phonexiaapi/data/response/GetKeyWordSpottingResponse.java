package com.pip.phonexiaapi.data.response;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.BaseResponse;
import com.pip.phonexiaapi.data.Language;
import com.pip.phonexiaapi.data.result.Segment;
import com.pip.phonexiaapi.data.result.TimeRange;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class GetKeyWordSpottingResponse extends BaseResponse{
    private String file;
    private Language model;
    @SerializedName("keyword_list")
    private String keywordList;
    @SerializedName("time_range")
    private TimeRange timeRange;
    private List<Segment> words;

    public String getFile() {
        return file;
    }

    public Language getModel() {
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
