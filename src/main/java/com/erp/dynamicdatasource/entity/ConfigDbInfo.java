package com.erp.dynamicdatasource.entity;

import com.alibaba.druid.pool.DruidDataSource;
import com.biligame.access.bean.DBInfo;
import com.erp.dynamicdatasource.entity.dync.DbInfo;
import lombok.Data;

import javax.sql.DataSource;

/**
 * @author 2p
 * @date 2021/9/8 17:18
 * @desc DbInfo
 */
@Data
public class ConfigDbInfo {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private String dbname;

    public DataSource createDataSource() {
        DruidDataSource result = new DruidDataSource();
        result.setDriverClassName(getDriverClassName());
        result.setUrl(getUrl());
        result.setUsername(getUsername());
        result.setPassword(getPassword());
        return result;
    }

}
