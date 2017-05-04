package com.qyer.javaapi.rest.application;



import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;


/**
 * Created by panqiang on 2017/4/23.
 */
public class Application extends ResourceConfig{
    public Application(){
        //服务 也可以用register
        packages("com.qyer.javaapi.rest");
        //register( BookResourceImp.class);
        register(RequestContextFilter.class);
        //注册jackson JSON转换器
        register(JacksonFeature.class);
        // 打印访问日志，便于跟踪调试，正式发布可清除
        register(LoggingFilter.class);
    }

}
