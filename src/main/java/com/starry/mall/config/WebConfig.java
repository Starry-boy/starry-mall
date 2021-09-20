package com.starry.mall.config;

import com.starry.mall.filter.TraceFilter;
import com.starry.mall.utils.LogContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/14 11:30
 */
//@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


    @Bean
    public FilterRegistrationBean<TraceFilter> registrationBean(@Autowired LogContext logContext){
        FilterRegistrationBean<TraceFilter> registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new TraceFilter(logContext));
        registrationBean.setOrder(1);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }
}
