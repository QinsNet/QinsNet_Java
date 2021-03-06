package com.qins.net.core.exception;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@Accessors(chain = true)
public class ResponseException extends Exception{
    public enum ExceptionCode { Intercepted,NotFoundMeta,NotFoundMethod,NotFoundNet,BufferFlow,Common,MaxConnects,NotFoundAbstractType,NotFoundParam, RemoteException,HttpException}
    @Expose
    private ExceptionCode code;
    @Expose
    private String message;
    @Expose
    private String data;

    public ResponseException(ExceptionCode code, String message, String data) {
        super(message);
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseException(ExceptionCode code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
