package com.starry.mall.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 15:36
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public DataSource devDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://dev.computer:3306/mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("Ratel@0804");
        druidDataSource.setInitialSize(5);
        druidDataSource.setMinIdle(10);
        druidDataSource.setMaxActive(20);
        log.debug("devDataSource struct success");
        return druidDataSource;
    }

    @Bean
    @Profile("sit")
    public DataSource sitDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://129.204.172.25:3306/starry_mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("Root@0804");
        druidDataSource.setInitialSize(5);
        druidDataSource.setMinIdle(10);
        druidDataSource.setMaxActive(20);
        log.debug("sitDataSource struct success");
        return druidDataSource;
    }
}
