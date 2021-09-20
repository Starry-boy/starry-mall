package com.starry.mall.admin.ums.log.service;

import com.starry.mall.admin.ums.log.po.UmsApiLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.starry.mall.commons.api.APILogDTO;

public interface UmsApiLogService extends IService<UmsApiLog>{

    /**
     * 异步保存
     * @param apiLogDTO
     */
    void asyncSave(APILogDTO apiLogDTO);
}
