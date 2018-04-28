package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by filipsollar on 17.4.18
 */
public class StatusResult extends BaseResult{
    private String database;
    private String licenses;
    @SerializedName("internal_services")
    private String internalServices;

    public String getDatabase() {
        return database;
    }

    public String getLicenses() {
        return licenses;
    }

    public String getInternalServices() {
        return internalServices;
    }
}
