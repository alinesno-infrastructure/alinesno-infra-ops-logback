package com.alinesno.infra.ops.logback.adapter.handle;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.ops.logback.core.constants.MessageConstant;
import com.alinesno.infra.ops.logback.core.utils.StringUtils;
import com.alinesno.infra.ops.logback.dto.database.DatabaseLogDto;
import com.alinesno.infra.ops.logback.dto.database.DatabaseSqlStatDto;
import com.alinesno.infra.ops.logback.entity.app.DatabaseLogEntity;
import com.alinesno.infra.ops.logback.entity.app.DatabaseSqlStatEntity;
import com.alinesno.infra.ops.logback.service.app.IDatabaseLogService;
import com.alinesno.infra.ops.logback.service.app.IDatabaseSqlStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理应用数据库操作日志
 */
@Slf4j
@Component(MessageConstant.REDIS_REST_DATABASE_KEY)
public class DatabaseLogHandle implements BaseHandle {

    @Autowired
    private IDatabaseLogService databaseLogService;

    @Autowired
    private IDatabaseSqlStatService databaseSqlStatService;

    @Override
    public void analyseMessage(String message) {
        log.debug("-->> DatabaseLogHandle message = {}" , JSONObject.parseObject(message));

        if(StringUtils.isNotEmpty(message)){

            DatabaseLogDto databaseLogDto = JSONObject.parseObject(JSONObject.parseObject(message).toJSONString() , DatabaseLogDto.class);
            log.debug("json object = {}" , databaseLogDto);

            DatabaseLogEntity databaseLogEntity = new DatabaseLogEntity();
            List<DatabaseSqlStatEntity> sqlListEntity = new ArrayList<>();

            BeanUtils.copyProperties(databaseLogDto , databaseLogEntity);

            // 处理直方图
            databaseLogEntity.setTransactionHistogram(convertHistogram(databaseLogDto.getTransactionHistogram()));
            databaseLogEntity.setConnectionHoldTimeHistogram(convertHistogram(databaseLogDto.getConnectionHoldTimeHistogram()));

            databaseLogService.save(databaseLogEntity);

            List<DatabaseSqlStatDto> sqlListDto = databaseLogDto.getSqlList();
            if(!CollectionUtils.isEmpty(sqlListDto)){

                sqlListDto.forEach(dto -> {
                    DatabaseSqlStatEntity sqlStatEntity = new DatabaseSqlStatEntity();
                    BeanUtils.copyProperties(dto , sqlStatEntity);

                    sqlStatEntity.setDatabaseLogId(databaseLogEntity.getId());

                    sqlStatEntity.setExecuteSql(SQLUtils.formatMySql(dto.getSql()));

                    // 处理直方图
                    sqlStatEntity.setFetchRowHistogram(convertHistogram(dto.getFetchRowHistogram()));
                    sqlStatEntity.setUpdateHistogram(convertHistogram(dto.getUpdateHistogram()));
                    sqlStatEntity.setExecuteHistogram(convertHistogram(dto.getExecuteHistogram()));
                    sqlStatEntity.setExecuteAndResultHoldHistogram(convertHistogram(dto.getExecuteAndResultHoldHistogram()));

                    sqlListEntity.add(sqlStatEntity);
                });

                databaseSqlStatService.saveBatch(sqlListEntity) ;
            }

        }
    }

    public static String convertHistogram(List<Integer> list) {
        if (!CollectionUtils.isEmpty(list)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            return sb.toString();
        }
        return null;
    }

}
