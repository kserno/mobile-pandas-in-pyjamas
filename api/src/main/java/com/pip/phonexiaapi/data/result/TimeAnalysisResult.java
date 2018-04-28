package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.common.Conversation;
import com.pip.phonexiaapi.data.common.Monologue;
import com.pip.phonexiaapi.data.common.Segment;
import com.pip.phonexiaapi.data.common.TimeRange;

import java.util.List;

/**
 * Created by filipsollar on 18.4.18
 */
public class TimeAnalysisResult extends BaseResult {
    private String file;
    private String model;
    @SerializedName("time_range")
    private TimeRange timeRange;
    @SerializedName("monologue")
    private List<Monologue> monologues;
    private Conversation conversation;
    private List<Segment> segmentation;

    public String getFile() {
        return file;
    }

    public String getModel() {
        return model;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public List<Monologue> getMonologues() {
        return monologues;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public List<Segment> getSegmentation() {
        return segmentation;
    }
}
