package com.pip.phonexiaapi.data.response;

import com.pip.phonexiaapi.data.BaseResponse;
import com.pip.phonexiaapi.data.result.Task;

import java.util.List;

/**
 * Created by filipsollar on 16.4.18
 */
public class GetTasksResponse extends BaseResponse {
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }
}
