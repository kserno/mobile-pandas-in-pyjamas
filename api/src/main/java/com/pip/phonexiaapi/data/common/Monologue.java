package com.pip.phonexiaapi.data.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by filipsollar on 18.4.18
 */
public class Monologue {
    private int channel;
    @SerializedName("speech_length")
    private double speechLength;
    @SerializedName("speech_speed")
    private double speechSpeed;
    @SerializedName("total_length")
    private double totalLength;

    public int getChannel() {
        return channel;
    }

    public double getSpeechLength() {
        return speechLength;
    }

    public double getSpeechSpeed() {
        return speechSpeed;
    }

    public double getTotalLength() {
        return totalLength;
    }
}
