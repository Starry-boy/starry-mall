create table ums_api_log
(
    id bigint primary key auto_increment,
    business_key varchar(20) not null comment '业务主键',
    user_id bigint not null comment '用户ID',
    trace_id varchar(50) not null default '' comment '链路ID',
    ip varchar(20) not null comment 'IP地址',
    os varchar(50) not null comment '操作系统',
    browser varchar(20) not null comment '浏览器',
    request_time DATETIME not null comment '请求时间',
    response_time Datetime not null comment '响应时间',
    request_args varchar(255) not null comment '请求参数',
    response_result text not null comment '响应结果',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    modify_time datetime default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP not null comment '修改时间'
) comment '接口日志'