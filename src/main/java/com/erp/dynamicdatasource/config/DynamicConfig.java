package com.erp.dynamicdatasource.config;

import com.erp.dynamicdatasource.entity.ConfigDbInfo;
import com.erp.dynamicdatasource.entity.ConfigDbInfo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 2p
 * @date 2021/9/8 17:17
 * @desc DynamicConfig
 */

@Data
@Component
@ConfigurationProperties(prefix = "datasource")
public class DynamicConfig {

    private  Map<String, ConfigDbInfo> dbInfos;

    private ConfigDbInfo maiDbInfo;

    private String defaultdb;


}
