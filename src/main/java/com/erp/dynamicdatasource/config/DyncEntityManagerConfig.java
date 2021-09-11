package com.erp.dynamicdatasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 2p
 * @date 2021/9/8 18:19
 * @desc EntityManagerConfig
 */
@Component
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryDync",
        basePackages = "com.erp.dynamicdatasource.dao.dync")
public class DyncEntityManagerConfig {

    @Autowired
    @Qualifier(value = "dynamicDataSource")
    public DataSource dynamicDataSource;

    @Bean(name = "entityManagerFactoryDync")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = builder
                .dataSource(dynamicDataSource)
                .properties(new HashMap<String, String>())
                .packages("com.erp.dynamicdatasource.entity.dync") //设置实体类所在位置
                .persistenceUnit("PersistenceUnit")
                .build();
        return entityManagerFactory;
    }

}
