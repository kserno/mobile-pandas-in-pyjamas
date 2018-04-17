package com.pip.phonexiaapi.data.response;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.BaseResponse;
import com.pip.phonexiaapi.data.result.Segment;
import com.pip.phonexiaapi.data.result.TimeRange;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class GetDiarizationResponse extends BaseResponse {
    private String file;
    private String model;// diarization model
    @SerializedName("max_speakers")
    private int maxSpeakers;
    @SerializedName("total_speakers")
    private int totalSpeakers;
    @SerializedName("time_range")
    private TimeRange timeRange;
    private List<Segment> segmentation;

    public String getFile() {
        return file;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeakers() {
        return maxSpeakers;
    }

    public int getTotalSpeakers() {
        return totalSpeakers;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }

    public List<Segment> getSegmentation() {
        return segmentation;
    }


}
