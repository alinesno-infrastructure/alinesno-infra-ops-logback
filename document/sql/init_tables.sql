-- 创建发送任务列表表
CREATE TABLE a_log_task
(
    has_delete Int32 COMMENT '是否删除(1删除|0正常|null正常)',
    delete_manager String COMMENT '删除的人',
    application_id Int64 COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
    application_name String COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的application.name对应】',
    tenant_id String COMMENT '所属租户 , 租户权限',
    field_id String COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
    department_id String COMMENT '部门权限: 只能看到自己所在部门的数据',
    id Int64 COMMENT '唯一ID号',
    field_prop String COMMENT '字段属性',
    add_time DateTime COMMENT '添加时间',
    delete_time DateTime COMMENT '删除时间',
    has_status Int32 COMMENT '状态(0启用|1禁用)',
    update_time DateTime COMMENT '更新时间',
    operator_id Int64 COMMENT '操作员 用户权限: 只能看到自己操作的数据',
    last_update_operator_id Int64 COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据',
    task_name String COMMENT '任务名称',
    cron_expression String COMMENT '定时CRON表达式',
    is_running UInt8 COMMENT '是否运行',
    status String COMMENT '运行状态'
)
ENGINE = MergeTree
ORDER BY id;
COMMENT ON TABLE log_task IS '发送任务列表表';



CREATE TABLE a_log_record (
    timestamp DateTime COMMENT '时间戳',
    log_level String COMMENT '日志级别',
    logger_name String COMMENT '日志来源',
    thread_name String COMMENT '线程名',
    log_message String COMMENT '日志消息',
    exception String COMMENT '异常信息',
    username String COMMENT '用户名',
    ip_address String COMMENT 'IP地址',
    request_url String COMMENT '请求URL',
    request_method String COMMENT '请求方法',
    request_parameters String COMMENT '请求参数',
    response_code Int32 COMMENT '响应代码',
    response_time Int64 COMMENT '响应时间',
    server_name String COMMENT '服务器名',
    log_id String COMMENT '日志ID',
    log_tags String COMMENT '日志标签',
    source_application String COMMENT '日志来源应用程序',
    log_category String COMMENT '日志分类',
    log_location String COMMENT '日志位置',
    log_context String COMMENT '日志上下文',
    log_markers String COMMENT '日志标记',
    log_extra_data String COMMENT '日志附加数据',
    log_duration Int64 COMMENT '日志持续时间',
    log_environment String COMMENT '日志环境',
    standardized_fields String COMMENT '日志标准化字段',
    has_delete Nullable(Int32) COMMENT '是否删除(1删除|0正常|null正常)',
    delete_manager String COMMENT '删除的人',
    application_id Nullable(Int64) COMMENT '所属应用 应用权限: 只能看到所属应用的权限【默认】',
    application_name String COMMENT '应用名称，唯一性，用于做应用标识【最好与springboot的applicaiotn.name对应】',
    tenant_id String COMMENT '所属租户 , 租户权限',
    field_id String COMMENT '字段权限：部分字段权限无法加密或者不显示，或者大于某个值',
    department_id String COMMENT '部门权限: 只能看到自己所在部门的数据',
    id Nullable(Int64) COMMENT '唯一ID号',
    field_prop String COMMENT '字段属性',
    add_time DateTime COMMENT '添加时间',
    delete_time Nullable(DateTime) COMMENT '删除时间',
    has_status Int32 COMMENT '状态(0启用|1禁用)',
    update_time Nullable(DateTime) COMMENT '更新时间',
    operator_id Nullable(Int64) COMMENT '操作员 用户权限: 只能看到自己操作的数据',
    last_update_operator_id Nullable(Int64) COMMENT '最后更新操作员 用户权限: 只能看到自己操作的数据'
) ENGINE = MergeTree()
ORDER BY timestamp;

COMMENT ON TABLE a_log_record IS '日志记录表';
