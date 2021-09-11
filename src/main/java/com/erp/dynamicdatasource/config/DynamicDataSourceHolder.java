package com.erp.dynamicdatasource.config;

import com.erp.dynamicdatasource.entity.ConfigDbInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 2p
 * @date 2021/9/8 17:40
 * @desc DynamicDataSource
 */
@Component
public class DynamicDataSourceHolder {

    @Autowired
    DynamicConfig config;

    @Primary
    @Bean(name = "dynamicDataSource")
    public DynamicRoutingDataSource dynamicDataSource() {
        String defaultdb = config.getDefaultdb();
        Map<String, ConfigDbInfo> dbInfos = config.getDbInfos();
        Map<Object, Object> targetDataSources = new HashMap<>(dbInfos.size());
        if (defaultdb == null || defaultdb.trim().isEmpty() || !dbInfos.containsKey(defaultdb)) {
            System.err.println("初始化数据源失败，未找到默认数据源配置：" + defaultdb);
            System.exit(0);
        }
        dbInfos.forEach((key, value) -> {
            targetDataSources.put(key, value.createDataSource());
        });

        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        //设置数据源
        dynamicRoutingDataSource.setTargetDataSources(targetDataSources);
        //设置默认选择的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(targetDataSources.get(defaultdb));
        dynamicRoutingDataSource.afterPropertiesSet();
        return dynamicRoutingDataSource;
    }

    @Bean(name = "maiDataSource")
    public DataSource maiDataSource() {
        ConfigDbInfo maiDbInfo = config.getMaiDbInfo();
        return maiDbInfo.createDataSource();
    }
}
