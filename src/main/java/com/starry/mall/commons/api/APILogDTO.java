package com.starry.mall.commons.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 14:17
 */
@Data
@Accessors(chain = true)
public class APILogDTO {
    private Long userId;
    private String os;
    private String ip;
    private String browser;
    private boolean success;
    private String code;
    private String desc;
    private Long elapsedTime;
    private Date requestTime;
    private Date ResponseTime;
    private String requestArgs;
    private String responseResult;
    private Date createTime;
    private String businessKey;
    private String threadName;

}
