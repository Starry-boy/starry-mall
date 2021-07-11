package com.starry.mall.commons;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 19:05
 */
public interface IBaseService<T> extends IService<T> {

    Long insert(T po);
}
