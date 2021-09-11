package com.erp.dynamicdatasource.config;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 2p
 * @date 2021/9/8 17:32
 * @desc DynamicRoutingDataSourceContext
 */
public class GameRoutingDataSourceContext {

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
        //TODO  应该要有一个默认的,但是determineTargetDataSource离会有空转默认的判断
//        if (dataSourceType == null) {
//            threadLocalDataSource.set("abc");
//            return getRoutingDataSource();
//        }
        // System.err.println(Thread.currentThread().getName()+" get RoutingDataSource : " + dataSourceType);
        return dataSourceType;
    }

    public static void removeRoutingDataSource() {
        threadLocalDataSource.remove();
    }
}
