package com.erp.dynamicdatasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author 2p
 * @date 2021/9/8 19:00
 * @desc MaiEntityManagerConfig
 */
@Component
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryMai",
        basePackages = "com.erp.dynamicdatasource.dao.mai")
public class MaiEntityManagerConfig {


    @Autowired
    @Qualifier(value = "maiDataSource")
    public DataSource maiDataSource;



    @Primary
    @Bean(name = "entityManagerFactoryMai")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMain(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = builder
                .dataSource(maiDataSource)
                .properties(new HashMap<String, String>())
                .packages("com.erp.dynamicdatasource.entity.mai") //设置实体类所在位置
                .persistenceUnit("PersistenceUnit")
                .build();
        return entityManagerFactory;
    }
}
