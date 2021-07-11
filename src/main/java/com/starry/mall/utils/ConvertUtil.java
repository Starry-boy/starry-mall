package com.starry.mall.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 17:55
 */
public class ConvertUtil {

    public static <S,T> T convert(S s, Supplier<T> supplier){
        if (s == null){
            return null;
        }
        T t = supplier.get();
        BeanUtils.copyProperties(s,t);
        return t;
    }

    public static <S,T> T convert(S s,Function<S,T> mapper){
        return s == null ? null : mapper.apply(s);
    }


    public static <S,T> List<T> convert(List<S> s, Function<S,T> mapper){
        return s.stream().map(a-> convert(a,mapper)).collect(Collectors.toList());
    }

    public static <S,T> List<T> convert(List<S> s, Supplier<T> supplier){
        return s.stream().map(a-> convert(a,supplier)).collect(Collectors.toList());
    }


}
