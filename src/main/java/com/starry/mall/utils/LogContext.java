package com.starry.mall.utils;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;


/**
 * @author ratel
 * @version 1.0
 * @description: 日志上下文
 * @date 2021/4/18 11:59
 */
@Component
public class LogContext implements IContext{

    public void setAttribute(String k,String v){
        MDC.put(k, v);
    }

    public String getAttribute(String k){
        return MDC.get(k);
    }

    public void remove(String k){
        MDC.remove(k);
    }

    @Override
    public void cleanAll() {
        MDC.clear();
    }

   public interface Key {
        String BUSINESS_KEY = "BUSINESS_KEY";
        String USER_ID = "USER_ID";
        String TRACE_ID = "TRACE_ID";
    }
}
