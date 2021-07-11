package com.starry.mall.aspect;

import com.starry.mall.commons.annon.TraceLog;
import com.starry.mall.commons.api.APILogDTO;
import com.starry.mall.utils.JsonUtil;
import com.starry.mall.utils.SessionContext;
import com.starry.mall.utils.WebUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author ratel
 * @version 1.0
 * @description: 接口调用日志切面
 * @date 2021/6/13 16:11
 */
@Slf4j
@Aspect
@Component
public class ApiLogAspect {

    @Autowired
    private SessionContext sessionContext;

    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void pointCut() {
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //目标对象
        Object target = joinPoint.getTarget();
        //方法签名
        Signature signature = joinPoint.getSignature();

        if (log.isDebugEnabled()) {
            log.debug("APILogAspect API 类名:{} 方法名:{} 入参:{}", target.getClass().getSimpleName(), signature.getName(), JsonUtil.toString(joinPoint.getArgs()));
        }

        if (signature instanceof MethodSignature) {
            //用户ID
            Long userId = sessionContext.getCurrentUserId();
            Date requestDate = new Date();
            Method method = ((MethodSignature) signature).getMethod();
            ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);

            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            HttpServletRequest req = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            APILogDTO apiLogDTO = new APILogDTO()
                    .setUserId(userId)
                    .setBrowser(WebUtil.getBrowers(req))
                    .setIp(WebUtil.getIpAddr(req))
                    .setOs(WebUtil.getOS(req))
                    .setDesc(apiOperation.value())
                    .setRequestTime(requestDate)
                    .setCreateTime(new Date())
                    .setRequestArgs(JsonUtil.toString(joinPoint.getArgs()));
            //todo 保存日志
        }

        return joinPoint.proceed(joinPoint.getArgs());
    }
}
