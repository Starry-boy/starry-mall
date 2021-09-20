package com.starry.mall.admin.ums.log.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
    * 接口日志
    */
@Data
@TableName(value = "ums_api_log")
public class UmsApiLog {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 业务主键
     */
    @TableField(value = "business_key")
    private String businessKey;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 链路ID
     */
    @TableField(value = "trace_id")
    private String traceId;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    private String ip;

    /**
     * 操作系统
     */
    @TableField(value = "os")
    private String os;

    /**
     * 浏览器
     */
    @TableField(value = "browser")
    private String browser;

    /**
     * 请求时间
     */
    @TableField(value = "request_time")
    private Date requestTime;

    /**
     * 响应时间
     */
    @TableField(value = "response_time")
    private Date responseTime;

    /**
     * 请求参数
     */
    @TableField(value = "request_args")
    private String requestArgs;

    /**
     * 响应结果
     */
    @TableField(value = "response_result")
    private String responseResult;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time")
    private Date modifyTime;
}