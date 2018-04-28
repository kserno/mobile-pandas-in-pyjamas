package com.pip.phonexiaapi.data.result;

import com.google.gson.annotations.SerializedName;
import com.pip.phonexiaapi.data.common.Plugin;
import com.pip.phonexiaapi.data.common.ServerInfo;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class ServerInfoResult extends BaseResult{
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
