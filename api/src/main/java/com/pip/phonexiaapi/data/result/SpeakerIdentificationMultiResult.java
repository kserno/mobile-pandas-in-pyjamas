package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.common.Speaker;
import com.pip.phonexiaapi.data.common.TimeRange;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class SpeakerIdentificationMultiResult extends BaseResult{
    private String model;

    @SerializedName("speaker_group")
    private String speakerGroup;
    @SerializedName("calibration_set")
    private String calibrationSet;
    @SerializedName("max_fa_rate")
    private double maxFaRate;
    @SerializedName("time_range")
    private TimeRange timeRange;
    private List<Speaker> results;

    public String getModel() {
        return model;
    }

    public String getSpeakerGroup() {
        return speakerGroup;
    }

    public String getCalibrationSet() {
        return calibrationSet;
    }

    public double getMaxFaRate() {
        return maxFaRate;
    }

    public TimeRange getTimeRange() {
        return timeRange;
    }
}
