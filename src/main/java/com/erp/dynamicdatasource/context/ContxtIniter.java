package com.erp.dynamicdatasource.context;

import com.erp.dynamicdatasource.config.DynamicConfig;
import com.erp.dynamicdatasource.config.DynamicRoutingDataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 2p
 * @date 2021/9/10 16:32
 * @desc ContxtIniter
 */
@Service
public class ContxtIniter implements InitializingBean, ServletContextAware {


    @Autowired
    DynamicConfig dynamicDbConfig;

    @Autowired
    @Qualifier(value = "dynamicDataSource")
    public DynamicRoutingDataSource dynamicDataSource;

    public Map<String, String> dbInfo;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        //初始化server库  dbnName - dbInfo  映射关系
        dbInfo = dealDbName();
        dealDynamicDataSource();

    }

    private void dealDynamicDataSource() {
        dynamicDataSource.setTargetDataSources(new HashMap<>());
    }

    private Map<String, String> dealDbName() {
        Map<String, String> res = new HashMap<>();
        if (dynamicDbConfig == null || dynamicDbConfig.getDbInfos() == null) {
            return res;
        }
        dynamicDbConfig.getDbInfos().forEach((key, dbInfo) -> {
            if (dbInfo != null) {
                res.put(dbInfo.getDbname(), key);
            }
        });
        return res;
    }
}
