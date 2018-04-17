package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;


/**
 * Created by filipsollar on 16.4.18
 */
public class Task {
    private String id;
    private State state;

    public String getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public enum State {
        @SerializedName("finished") FINISHED,
        @SerializedName("running") RUNNING
    }
}
