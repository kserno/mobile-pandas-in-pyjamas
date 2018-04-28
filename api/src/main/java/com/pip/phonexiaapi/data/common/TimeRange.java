package com.pip.phonexiaapi.data.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by filipsollar on 17.4.18
 */
public class TimeRange {

    @SerializedName("from_time")
    private double fromTime;
    @SerializedName("to_time")
    private double toTime;

    public double getFromTime() {
        return fromTime;
    }

    public double getToTime() {
        return toTime;
    }
}
