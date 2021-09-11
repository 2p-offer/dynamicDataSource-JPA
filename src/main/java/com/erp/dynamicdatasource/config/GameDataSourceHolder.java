package com.erp.dynamicdatasource.config;

import com.alibaba.fastjson.JSONObject;
import com.biligame.access.bean.DBInfo;
import com.biligame.access.property.DataSourceProperty;
import com.biligame.access.utils.DBUtil;
import com.erp.dynamicdatasource.dao.dync.GsDbInfoRepository;
import com.erp.dynamicdatasource.dao.dync.ServerInfoRepository;
import com.erp.dynamicdatasource.entity.ConfigDbInfo;
import com.erp.dynamicdatasource.entity.dync.DbInfo;
import com.erp.dynamicdatasource.entity.dync.ServerInfo;
import org.codehaus.groovy.util.HashCodeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 2p
 * @date 2021/9/10 17:28
 * @desc GameDataSourceHolder
 */
@Component
public class GameDataSourceHolder {


    @Autowired
    DynamicConfig config;

    @Autowired
    private GsDbInfoRepository dbInfoRepository;

    @Bean(name = "gameDataSource")
    public DynamicRoutingDataSource gameDataSource() {

        //所有的server库信息
        Map<String, ConfigDbInfo> dbInfos = config.getDbInfos();
        Map<Object, Object> targetDataSources = new HashMap<>(dbInfos.size());
        final String[] gameDefault = {""};
        dbInfos.forEach((key, value) -> {
            //查出所有可能的game数据连接信息
            DynamicRoutingDataSourceContext.setRoutingDataSource(key);
            List<DbInfo> all = dbInfoRepository.findAll();

            //那些表需要分库分表
            List<String> configTables = new ArrayList<>();
            configTables.add("name");
            //把所有的game连接信息，根据EntryId分类：
            Map<String, List<DbInfo>> entryDbInfo = dealDbInfosAll(all);

            //为每个entry创建一个sharding数据源
            entryDbInfo.forEach((entryName, dbInfoList) -> {

                HashMap<String, DBInfo> dbInfoMap = new HashMap<>();
                //处理server - dbinfo 存放的所有连接（一个服，所有的game机器）
                dbInfoList.forEach(dbInfo -> {
                    DBInfo db = new DBInfo("jdbc:mysql://" + dbInfo.getReadHost() + ":3306/" + dbInfo.getGameDbName() + "?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&failOverReadOnly=false&serverTimezone=GMT%2B8&useSSL=false"
                            , dbInfo.getReadUserName(), dbInfo.getReadUserPwd());
                    dbInfoMap.put(dbInfo.getGameDbName(), db);
                    System.out.println("append gameDBName:     " + dbInfo.getGameDbName() + ",dbINfo:" + JSONObject.toJSONString(db));
                });

                DataSourceProperty dataSourceProperty = new DataSourceProperty(dbInfoMap, configTables/*, configTables*/);
                DBUtil dbUtil = DBUtil.getInstance();
                DataSource dataSource = dbUtil.buildShardDataSource(dataSourceProperty);
                //把数据源放到整体的 targetDataSources 离， 数据源key 为 server库dbName_entryName
                gameDefault[0] = key + "_" + entryName;
                targetDataSources.put(gameDefault[0], dataSource);
            });

        });
        System.out.println("TargetDataSources : +++++++++++++++++++++++++++++++" + targetDataSources.keySet());

        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        //设置数据源
        dynamicRoutingDataSource.setTargetDataSources(targetDataSources);
        //设置默认选择的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(targetDataSources.get(gameDefault[0]));
        dynamicRoutingDataSource.afterPropertiesSet();
        return dynamicRoutingDataSource;
    }

    /**
     * 通过entryId 把所有DbInfo 分类
     *
     * @param all
     * @return
     */
    private Map<String, List<DbInfo>> dealDbInfosAll(List<DbInfo> all) {
        Map<String, List<DbInfo>> res = new HashMap<>();
        all.forEach(dbInfo -> {
            List<DbInfo> dbInfoList = res.get(String.valueOf(dbInfo.getEntryId()));
            if (dbInfoList == null) {
                dbInfoList = new ArrayList<>();
                dbInfoList.add(dbInfo);
                res.put(String.valueOf(dbInfo.getEntryId()), dbInfoList);
            } else {
                dbInfoList.add(dbInfo);
            }
        });
        return res;
    }

}
