package com.starry.mall.helper;

import com.starry.mall.admin.ums.log.po.UmsApiLog;
import com.starry.mall.commons.api.APILogDTO;
import com.starry.mall.utils.LogContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UmsApiLogHelper {
    @Autowired
    private LogContext logContext;

    public UmsApiLog toUmsApiLog(APILogDTO apiLogDTO){
        UmsApiLog umsApiLog = new UmsApiLog();
        umsApiLog.setBusinessKey(apiLogDTO.getBusinessKey());
        umsApiLog.setUserId(apiLogDTO.getUserId());
        umsApiLog.setTraceId(logContext.getAttribute(LogContext.Key.TRACE_ID));
        umsApiLog.setIp(apiLogDTO.getIp());
        umsApiLog.setOs(apiLogDTO.getOs());
        umsApiLog.setBrowser(apiLogDTO.getBrowser());
        umsApiLog.setRequestTime(apiLogDTO.getRequestTime());
        umsApiLog.setResponseTime(apiLogDTO.getResponseTime());
        umsApiLog.setRequestArgs(apiLogDTO.getRequestArgs());
        umsApiLog.setResponseResult(apiLogDTO.getResponseResult());
        Date now = new Date();
        umsApiLog.setCreateTime(now);
        umsApiLog.setModifyTime(now);
        return umsApiLog;
    }
}
