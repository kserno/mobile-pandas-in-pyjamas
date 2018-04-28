package com.pip.phonexiaapi.data.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class User {
    private String login;
    private boolean active;
    @SerializedName("max_pending_requests")
    private int maxPendingRequests;
    private List<String> roles;

    public String getLogin() {
        return login;
    }

    public boolean isActive() {
        return active;
    }

    public int getMaxPendingRequests() {
        return maxPendingRequests;
    }

    public List<String> getRoles() {
        return roles;
    }
}
