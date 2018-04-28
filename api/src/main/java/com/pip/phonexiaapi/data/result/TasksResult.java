package com.pip.phonexiaapi.data.result;

import com.pip.phonexiaapi.data.common.Task;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class TasksResult extends BaseResult{
    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }
}
