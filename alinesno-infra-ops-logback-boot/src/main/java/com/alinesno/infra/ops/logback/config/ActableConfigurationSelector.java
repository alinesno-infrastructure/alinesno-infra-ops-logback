package com.alinesno.infra.ops.logback.config;

import com.alinesno.infra.common.facade.enable.ConfigRegisterBean;
import com.gitee.sunchenbin.mybatis.actable.base.BaseCRUDManagerImpl;
import com.gitee.sunchenbin.mybatis.actable.database.mysql.system.SysMysqlCreateTableManagerImpl;
import com.gitee.sunchenbin.mybatis.actable.database.oracle.system.SysOracleCreateTableManagerImpl;
import com.gitee.sunchenbin.mybatis.actable.database.postgresql.system.SysPostgreSqlCreateTableManagerImpl;
import com.gitee.sunchenbin.mybatis.actable.startup.StartUpHandlerImpl;
import com.gitee.sunchenbin.mybatis.actable.utils.ConfigurationUtil;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * 引入自动类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
public class ActableConfigurationSelector implements ImportSelector {

    @NotNull
    @Override
    public String[] selectImports(@NotNull AnnotationMetadata importingClassMetadata) {

        List<String> importBean = new ArrayList<>();

        // 引入dao层
        importBean.add(BaseCRUDManagerImpl.class.getName()) ;
        importBean.add(ConfigRegisterBean.class.getName()) ;

        // 引入manager
        importBean.add(StartUpHandlerImpl.class.getName()) ;

        // 引入数据库配置
        importBean.add(SysMysqlCreateTableManagerImpl.class.getName()) ;
        importBean.add(SysPostgreSqlCreateTableManagerImpl.class.getName()) ;
        importBean.add(SysOracleCreateTableManagerImpl.class.getName()) ;

        importBean.add(ConfigurationUtil.class.getName()) ;

        return importBean.toArray(new String[] {});
    }

}
