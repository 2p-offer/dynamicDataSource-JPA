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

/**
 * @author 2p
 * @date 2021/9/8 18:19
 * @desc  jpa多数据源配置， 游戏数据库数据源 entityManagerFactory生成类
 */
@Component
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryGame",
        basePackages = "com.erp.dynamicdatasource.dao.game")
public class GameEntityManagerConfig {

    @Autowired
    @Qualifier(value = "gameDataSource")
    public DataSource gameDataSource;

    @Bean(name = "entityManagerFactoryGame")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = builder
                .dataSource(gameDataSource)
                .properties(new HashMap<String, String>())
                .packages("com.erp.dynamicdatasource.entity.game") //设置实体类所在位置
                .persistenceUnit("PersistenceUnit")
                .build();
        return entityManagerFactory;
    }

}
