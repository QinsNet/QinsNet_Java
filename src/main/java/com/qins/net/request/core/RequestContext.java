package com.qins.net.request.core;

import com.qins.net.core.entity.NodeAddress;
import com.qins.net.core.entity.RequestMeta;
import com.qins.net.core.entity.ResponseMeta;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;
import java.util.HashMap;

@Getter
@Setter
public class RequestContext {
    private ResponseMeta responseMeta;
    private RequestMeta requestMeta;
    private Object instance;
    private Method method;
    private HashMap<String,Object> params;
    private NodeAddress remote;
    private boolean isVoid = false;
}