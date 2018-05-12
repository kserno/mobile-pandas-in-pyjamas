package com.pip.sdk.data;

import com.pip.phonexiaapi.data.common.Plugin;
import com.pip.phonexiaapi.data.common.ServerInfo;
import com.pip.phonexiaapi.data.common.Technology;

import java.util.List;

/**
 * Created by filipsollar on 17.4.18
 */
public class ServerInfoModel {

    private boolean serverInfoLoaded;
    private boolean serverStatusLoaded;
    private boolean technologiesLoaded;

    private String version;
    private String buildNumber;
    private String bsapiVersion;
    private boolean audioConverterEnabled;
    private long maximumUploadFileSize;
    private long maximumUploadMetaFileSize;
    private boolean rtpStreamsEnabled;
    private boolean httpStreamsEnabled;
    private List<Plugin> plugins;
    private String database;
    private String licenses;
    private String internalServices;
    private List<Technology> technologies;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getBsapiVersion() {
        return bsapiVersion;
    }

    public void setBsapiVersion(String bsapiVersion) {
        this.bsapiVersion = bsapiVersion;
    }

    public boolean isAudioConverterEnabled() {
        return audioConverterEnabled;
    }

    public void setAudioConverterEnabled(boolean audioConverterEnabled) {
        this.audioConverterEnabled = audioConverterEnabled;
    }

    public long getMaximumUploadFileSize() {
        return maximumUploadFileSize;
    }

    public void setMaximumUploadFileSize(long maximumUploadFileSize) {
        this.maximumUploadFileSize = maximumUploadFileSize;
    }

    public long getMaximumUploadMetaFileSize() {
        return maximumUploadMetaFileSize;
    }

    public void setMaximumUploadMetaFileSize(long maximumUploadMetaFileSize) {
        this.maximumUploadMetaFileSize = maximumUploadMetaFileSize;
    }

    public boolean isRtpStreamsEnabled() {
        return rtpStreamsEnabled;
    }

    public void setRtpStreamsEnabled(boolean rtpStreamsEnabled) {
        this.rtpStreamsEnabled = rtpStreamsEnabled;
    }

    public boolean isHttpStreamsEnabled() {
        return httpStreamsEnabled;
    }

    public void setHttpStreamsEnabled(boolean httpStreamsEnabled) {
        this.httpStreamsEnabled = httpStreamsEnabled;
    }

    public List<Plugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<Plugin> plugins) {
        this.plugins = plugins;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getLicenses() {
        return licenses;
    }

    public void setLicenses(String licenses) {
        this.licenses = licenses;
    }

    public String getInternalServices() {
        return internalServices;
    }

    public void setInternalServices(String internalServices) {
        this.internalServices = internalServices;
    }

    public boolean isServerInfoLoaded() {
        return serverInfoLoaded;
    }

    /*package*/ void setServerInfoLoaded(boolean serverInfoLoaded) {
        this.serverInfoLoaded = serverInfoLoaded;
    }

    public boolean isServerStatusLoaded() {
        return serverStatusLoaded;
    }

    /*package*/ void setServerStatusLoaded(boolean serverStatusLoaded) {
        this.serverStatusLoaded = serverStatusLoaded;
    }

    public boolean isTechnologiesLoaded() {
        return technologiesLoaded;
    }

    /*package*/ void setTechnologiesLoaded(boolean technologiesLoaded) {
        this.technologiesLoaded = technologiesLoaded;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    @Override
    public String toString() {
        return "ServerInfoModel{" +
                "serverInfoLoaded=" + serverInfoLoaded +
                ", serverStatusLoaded=" + serverStatusLoaded +
                ", technologiesLoaded=" + technologiesLoaded +
                ", version='" + version + '\'' +
                ", buildNumber='" + buildNumber + '\'' +
                ", bsapiVersion='" + bsapiVersion + '\'' +
                ", audioConverterEnabled=" + audioConverterEnabled +
                ", maximumUploadFileSize=" + maximumUploadFileSize +
                ", maximumUploadMetaFileSize=" + maximumUploadMetaFileSize +
                ", rtpStreamsEnabled=" + rtpStreamsEnabled +
                ", httpStreamsEnabled=" + httpStreamsEnabled +
                ", plugins=" + plugins +
                ", database='" + database + '\'' +
                ", licenses='" + licenses + '\'' +
                ", internalServices='" + internalServices + '\'' +
                ", technologies=" + technologies +
                '}';
    }
}
