package com.starry.mall.admin.ums.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starry.mall.admin.ums.admin.mapper.UmsAdminMapper;
import com.starry.mall.admin.ums.admin.po.UmsAdmin;
import com.starry.mall.admin.ums.admin.service.UmsAdminService;
import com.starry.mall.helper.UmsAdminHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService{
    @Autowired
    private UmsAdminHelper umsAdminHelper;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UmsAdmin umsAdmin = getOne(new LambdaQueryWrapper<UmsAdmin>().eq(UmsAdmin::getUsername, username));
//        if (umsAdmin == null){
//            throw new UsernameNotFoundException("用户不存在");
//        }
//
//        return umsAdminHelper.convertUser(umsAdmin);
//    }
}
