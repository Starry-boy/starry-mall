package com.starry.mall.admin.ums.admin.service;

import com.starry.mall.admin.ums.admin.po.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UmsAdminService extends IService<UmsAdmin>, UserDetailsService {


}
