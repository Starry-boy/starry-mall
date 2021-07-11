package com.starry.mall.exception;

import com.starry.mall.commons.api.CommonResult;
import com.starry.mall.commons.api.CommonResultCode;
import com.starry.mall.commons.domain.WebResult;
import com.starry.mall.utils.LogContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/14 11:18
 */
@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {
    @Autowired
    private LogContext logContext;

    @ExceptionHandler(Exception.class)
    public WebResult exception(Exception e){
        log.error("no catch exception,traceId:{}", logContext.getAttribute(LogContext.Key.TRACE_ID),e);
        return WebResult.failed(CommonResultCode.FAILED);
    }

    @ExceptionHandler(RuntimeException.class)
    public WebResult runTimeException(RuntimeException e){
        log.error("no catch runtime exception,traceId:{}", logContext.getAttribute(LogContext.Key.TRACE_ID),e);
        return WebResult.failed(CommonResultCode.FAILED);
    }
}
