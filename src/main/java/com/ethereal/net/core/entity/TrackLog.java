package com.ethereal.net.core.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class TrackLog {

    public enum LogCode { Core, Runtime }
    private String message;
    private LogCode code;
    private Object sender;
    public TrackLog(LogCode code,String message) {
        this.message = message;
        this.code = code;
    }
    public TrackLog(LogCode code,String message,Object sender) {
        this.message = message;
        this.code = code;
        this.sender = sender;
    }
}