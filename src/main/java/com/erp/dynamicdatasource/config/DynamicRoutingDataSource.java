package com.erp.dynamicdatasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author 2p
 * @date 2021/9/8 17:30
 * @desc 返回动态数据源map中我们期望的key，用于寻找数据源时的依据
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        Object lookupKey = DynamicRoutingDataSourceContext.getRoutingDataSource();
        System.err.println(Thread.currentThread().getName() + " determineCurrentLookupKey : " + lookupKey);
        return lookupKey;
    }
}
