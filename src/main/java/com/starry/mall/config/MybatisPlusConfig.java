package com.starry.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/13 15:36
 */
@Configuration
@Transactional
@MapperScan("com.starry.mall.**.mapper")
public class MybatisPlusConfig {

}
