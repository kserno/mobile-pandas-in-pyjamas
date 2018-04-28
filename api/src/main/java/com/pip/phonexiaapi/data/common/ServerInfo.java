package com.pip.phonexiaapi.data.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by filipsollar on 16.4.18
 */
public class ServerInfo {
    private String version;
    @SerializedName("build_number")
    private String buildNumber;
    @SerializedName("bsapi_version")
    private String bsapiVersion;
    @SerializedName("audio_converter_enabled")
    private boolean audioConverterEnabled;
    @SerializedName("maximum_upload_file_size")
    private long maximumUploadFileSize;
    @SerializedName("maximum_upload_meta_file_size")
    private long maximumUploadMetaFileSize;
    @SerializedName("rtp_streams_enabled")
    private boolean rtpStreamsEnabled;
    @SerializedName("http_streams_enabled")
    private boolean httpStreamsEnabled;

    public String getVersion() {
        return version;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public String getBsapiVersion() {
        return bsapiVersion;
    }

    public boolean isAudioConverterEnabled() {
        return audioConverterEnabled;
    }

    public long getMaximumUploadFileSize() {
        return maximumUploadFileSize;
    }

    public long getMaximumUploadMetaFileSize() {
        return maximumUploadMetaFileSize;
    }

    public boolean isRtpStreamsEnabled() {
        return rtpStreamsEnabled;
    }

    public boolean isHttpStreamsEnabled() {
        return httpStreamsEnabled;
    }
}
