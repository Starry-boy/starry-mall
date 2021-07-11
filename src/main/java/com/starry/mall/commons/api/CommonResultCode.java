package com.starry.mall.commons.api;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 16:02
 */
public enum CommonResultCode implements ErrorCode {
    SUCCESS("200", "操作成功"),
    FAILED("500", "操作失败"),
    VALIDATE_FAILED("404", "参数检验失败"),
    UNAUTHORIZED("401", "暂未登录或token已经过期"),
    FORBIDDEN("403", "没有相关权限"),

    UMS_MENU_INSERT_FAILED("UMS0001", "新增菜单失败"),
    UMS_MENU_UPDATE_FAILED("UMS0002", "修改菜单失败"),
    UMS_MENU_DELETE_FAILED("UMS0003", "删除菜单失败"),
    ;
    private String code;
    private String message;

    CommonResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
