package com.starry.mall.utils;

import org.springframework.stereotype.Component;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 16:07
 */
@Component
public class SessionContext implements IContext{

    public long getCurrentUserId(){
        return 0L;
    }

    @Override
    public void cleanAll() {

    }
}
