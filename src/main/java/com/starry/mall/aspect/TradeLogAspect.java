package com.starry.mall.aspect;

import com.starry.mall.commons.annon.TraceLog;
import com.starry.mall.utils.JsonUtil;
import com.starry.mall.utils.LogContext;
import com.starry.mall.utils.SessionContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @author ratel
 * @version 1.0
 * @description: 日志切面，记录用户IP，用户名，工号，操作类型，入参 等信息
 * @date 2021/4/18 10:20
 * @see TraceLog
 */
@Slf4j
@Aspect
@Component
public class TradeLogAspect {

    @Autowired
    private LogContext logContext;
    @Autowired
    private SessionContext sessionContext;

    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();


    @Pointcut("@annotation(com.starry.mall.commons.annon.TraceLog)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        //目标对象
        Object target = joinPoint.getTarget();
        //方法签名
        Signature signature = joinPoint.getSignature();
        if (log.isDebugEnabled()) {
            log.debug("TradeLogAspect API 类名:{} 方法名:{} 入参:{}", target.getClass().getSimpleName(), signature.getName(), JsonUtil.toString(joinPoint.getArgs()));
        }

        //用户ID
        long userId = sessionContext.getCurrentUserId();

        if (signature instanceof MethodSignature) {
            Method method = ((MethodSignature) signature).getMethod();
            TraceLog traceLog = method.getAnnotation(TraceLog.class);

            //将操作人的信息保存到日志上下文
            Object[] args = joinPoint.getArgs();
            if (args != null && args.length > 0) {
                ExpressionParser parser = new SpelExpressionParser();
                Expression expression = parser.parseExpression(traceLog.businessKey());
                EvaluationContext evaluationContext = bindParam(method, joinPoint.getArgs());
                Object value = expression.getValue(evaluationContext);
                logContext.setAttribute(LogContext.Key.BUSINESS_KEY, Optional.ofNullable(value).orElse("").toString());
            }

            logContext.setAttribute(LogContext.Key.USER_ID, String.valueOf(userId));
        }
        return joinPoint.proceed(joinPoint.getArgs());
    }


    private EvaluationContext bindParam(Method method, Object[] args) {
        //获取方法的参数名
        String[] params = discoverer.getParameterNames(method);

        //将参数名与参数值对应起来
        EvaluationContext context = new StandardEvaluationContext();
        for (int len = 0; len < params.length; len++) {
            context.setVariable(params[len], args[len]);
        }
        return context;
    }
}
