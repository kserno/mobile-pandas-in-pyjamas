package com.pip.phonexiaapi.data.response;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.BaseResponse;

/**
 * Created by filipsollar on 16.4.18
 */
public class GetStatusResponse extends BaseResponse {

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
