package com.pip.phonexiaapi.data;

import java.io.Serializable;

/**
 * Created by filipsollar on 6.4.18.
 */

public class AudioFileInfoResult extends BaseResponse implements Serializable{

    private AudioFileInfo info;

    public AudioFileInfo getInfo() {
        return info;
    }
}
