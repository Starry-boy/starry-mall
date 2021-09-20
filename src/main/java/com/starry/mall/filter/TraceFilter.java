package com.starry.mall.filter;

import com.starry.mall.utils.LogContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ratel
 * @version 1.0
 * @description: 链路追踪过滤器
 * @date 2021/6/14 11:26
 */
public class TraceFilter implements Filter {

    @Autowired
    private LogContext logContext;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            logContext.setAttribute(LogContext.Key.TRACE_ID, UUID.randomUUID().toString().replace("-",""));
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            logContext.remove(LogContext.Key.TRACE_ID);
        }
    }

    public TraceFilter(LogContext logContext) {
        this.logContext = logContext;
    }
}
