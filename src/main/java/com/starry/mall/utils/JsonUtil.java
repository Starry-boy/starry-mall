package com.starry.mall.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 10:50
 */
public class JsonUtil {
    private static ObjectMapper jsonMapper = new ObjectMapper();

    public static String toString(Object obj){
        try {
            return jsonMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObject(String jsonStr,Class<T> cls){
        try {
            return jsonMapper.readValue(jsonStr, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
