package com.ethereal.meta.core.entity;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Error {
    public enum ErrorCode { Intercepted,NotFoundMeta,NotFoundMethod,NotFoundNet,BufferFlow,Common,MaxConnects,NotFoundAbstractType,Exception }
    @Expose
    private ErrorCode Code;
    @Expose
    private String Message;
    @Expose
    private String Data;

    public Error(ErrorCode code, String message, String data) {
        Code = code;
        Message = message;
        Data = data;
    }
    public Error(ErrorCode code, String message) {
        Code = code;
        Message = message;
    }

}