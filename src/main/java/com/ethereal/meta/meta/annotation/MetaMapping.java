package com.ethereal.meta.meta.annotation;

import com.ethereal.meta.meta.Meta;
import com.ethereal.meta.net.core.Net;
import com.ethereal.meta.request.core.Request;
import com.ethereal.meta.service.core.Service;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MetaMapping {
    String mapping() default "";
}
