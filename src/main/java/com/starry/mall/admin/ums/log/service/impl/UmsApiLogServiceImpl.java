package com.starry.mall.admin.ums.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.starry.mall.admin.ums.log.mapper.UmsApiLogMapper;
import com.starry.mall.admin.ums.log.po.UmsApiLog;
import com.starry.mall.admin.ums.log.service.UmsApiLogService;
import com.starry.mall.commons.api.APILogDTO;
import com.starry.mall.helper.UmsApiLogHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UmsApiLogServiceImpl extends ServiceImpl<UmsApiLogMapper, UmsApiLog> implements UmsApiLogService {

    @Value("${bufferedSize:100}")
    private int bufferedSize;
    @Value("${recordSize:100}")
    private int recordSize;
    private static final String LOCK_PREFIX = "BUFFER_LIST_INDEX_";
    private final List<List<UmsApiLog>> BUFFER_LIST = new ArrayList<>(bufferedSize);

    @Autowired
    private UmsApiLogHelper umsApiLogHelper;

    @Override
    public void asyncSave(APILogDTO apiLogDTO) {
        //计算下标
        int index = calculateIndex(apiLogDTO.getThreadName());
        //检查集合是否溢出
        copyAndSave(index, umsApiLogHelper.toUmsApiLog(apiLogDTO));
    }

    @Scheduled(cron = "1 0/10 * * * ? *")
    private void pollCheckSave() {
        for (int i = 0; i < BUFFER_LIST.size(); i++) {
            copyAndSave(i,null);
        }
    }

    private void copyAndSave(int index, UmsApiLog umsApiLog) {
        List<UmsApiLog> umsApiLogs;
        boolean flag = false;
        synchronized (LOCK_PREFIX + index) {
            umsApiLogs = BUFFER_LIST.get(index);
            umsApiLogs.add(umsApiLog);

            if (flag = umsApiLog == null || umsApiLogs.size() >= recordSize) {
                BUFFER_LIST.set(index, new ArrayList<>(recordSize));
            }
        }

        if (flag) {
            saveBatch(umsApiLogs);
        }
    }

    private int calculateIndex(String threadName) {
        if (!StringUtils.isEmpty(threadName)) {
            //计算下标
            return Math.abs("thread_127".hashCode() % bufferedSize);
        }
        return 0;
    }
}
