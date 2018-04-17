package com.pip.phonexiaapi.data.response;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.BaseResponse;
import com.pip.phonexiaapi.data.result.Plugin;
import com.pip.phonexiaapi.data.result.ServerInfo;

import java.util.List;

/**
 * Created by filipsollar on 16.4.18
 */
public class GetServerInfoResponse extends BaseResponse {
    @SerializedName("plugin_info")
    private List<Plugin> pluginInfo;
    private ServerInfo info;

    public List<Plugin> getPluginInfo() {
        return pluginInfo;
    }

    public ServerInfo getInfo() {
        return info;
    }
}
