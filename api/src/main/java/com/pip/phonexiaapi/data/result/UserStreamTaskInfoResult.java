package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.common.StreamTaskInfo;

/**
 * Created by filipsollar on 17.4.18
 */
public class UserStreamTaskInfoResult extends BaseResult{

    @SerializedName("stream_task_info")
    private StreamTaskInfo streamTaskInfo;

    public StreamTaskInfo getStreamTaskInfo() {
        return streamTaskInfo;
    }
}
