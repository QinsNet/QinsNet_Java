package com.ethereal.net.service.event.delegate;

import com.ethereal.net.net.core.Net;
import com.ethereal.net.node.core.Node;
import com.ethereal.net.service.core.Service;

import java.lang.reflect.Method;

public interface InterceptorDelegate {
    boolean onInterceptor(Service service, Method method, Node node);
}
