package com.starry.mall.commons.domain;

import com.starry.mall.commons.api.CommonResultCode;
import com.starry.mall.commons.api.ErrorCode;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 15:59
 */
@Data
@Accessors(chain = true)
public class WebResult<T> implements Serializable {
    private String code;
    private String message;
    private T data;

    public static <T> WebResult<T> success(T data) {
        return success(data,null);
    }

    public static <T> WebResult<T> success(T data, String message) {
        return new WebResult<T>()
                .setData(data)
                .setCode(CommonResultCode.SUCCESS.toString())
                .setMessage(message == null ? CommonResultCode.SUCCESS.getMessage() : message);
    }

    public static <T> WebResult<T> failed(ErrorCode errorCode,String message) {
        return new WebResult<T>()
                .setCode(errorCode.getCode())
                .setMessage(message == null ? errorCode.getMessage() : message);
    }


    public static <T> WebResult<T> failed(ErrorCode errorCode){
        return failed(errorCode,null);
    }
}
