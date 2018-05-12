package com.pip.sdk;

/**
 * Created by filipsollar on 29.4.18
 */
public class StreamRunningException extends Throwable{

    public StreamRunningException() {
        super("Stream is already running");
    }
}
