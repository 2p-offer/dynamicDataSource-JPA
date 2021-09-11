package com.erp.dynamicdatasource.config;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 2p
 * @date 2021/9/8 17:32
 * @desc DynamicRoutingDataSourceContext
 */
public class DynamicRoutingDataSourceContext {

    @Autowired
    DynamicConfig config;

    private static final ThreadLocal<Object> threadLocalDataSource = new ThreadLocal<>();


    public static void setRoutingDataSource(Object dataSource) {
        if (dataSource == null) {
            throw new NullPointerException();
        }
        threadLocalDataSource.set(dataSource);
    }

    public static Object getRoutingDataSource() {
        Object dataSourceType = threadLocalDataSource.get();
        return dataSourceType;
    }

    public static void removeRoutingDataSource() {
        threadLocalDataSource.remove();
    }
}
