package com.pip.phonexiaapi.data.result;

import com.pip.phonexiaapi.data.common.AudioFileInfo;

import java.io.Serializable;

/**
 * Created by filipsollar on 6.4.18.
 */

public class AudioFileInfoResult extends BaseResult implements Serializable{

    private AudioFileInfo info;

    public AudioFileInfo getInfo() {
        return info;
    }
}
