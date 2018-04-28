package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.common.Conversation;
import com.pip.phonexiaapi.data.common.Monologue;

/**
 * Created by filipsollar on 18.4.18
 */
public class TimeAnalysisStreamResult extends BaseResult{
    private String model;
    @SerializedName("is_last")
    private boolean isLast;
    @SerializedName("task_id")
    private String taskId;
    @SerializedName("task_execution_time")
    private double taskExecutionTime;
    @SerializedName("stream_id")
    private String streamId;
    private Monologue monologue;
    private Conversation conversation;

    public String getModel() {
        return model;
    }

    public boolean isLast() {
        return isLast;
    }

    public String getTaskId() {
        return taskId;
    }

    public double getTaskExecutionTime() {
        return taskExecutionTime;
    }

    public String getStreamId() {
        return streamId;
    }

    public Monologue getMonologue() {
        return monologue;
    }

    public Conversation getConversation() {
        return conversation;
    }
}
