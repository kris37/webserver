package com.qyer.javaapi.service;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jaxb.internal.XmlCollectionJaxbProvider;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by panqiang on 2017/4/23.
 */
public class AppResource extends ResourceConfig{
    public AppResource(){
        packages("com.qyer.javaapi.resource");
        //注册JSON转换器
        register(JacksonJsonProvider.class);
        // 打印访问日志，便于跟踪调试，正式发布可清除
        register(LoggingFilter.class);
    }
}
