package com.qins.net.request.aop.context;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.HashMap;

@Getter
@Setter
public class ErrorEventContext extends RequestContext {
    private String exception;

    public ErrorEventContext(HashMap<String, Object> parameters, Method method, String exception) {
        super(parameters, method);
        this.exception = exception;
    }
}