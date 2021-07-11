package com.starry.mall.helper;

import com.starry.mall.admin.ums.admin.po.UmsAdmin;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/16 20:33
 */
@Component
public class UmsAdminHelper {

    public User convertUser(UmsAdmin umsAdmin){
        User user = new User(umsAdmin.getUsername(),umsAdmin.getPassword(), Collections.emptyList());
        return user;
    }
}
