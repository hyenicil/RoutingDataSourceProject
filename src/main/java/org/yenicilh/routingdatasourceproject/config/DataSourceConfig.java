package org.yenicilh.routingdatasourceproject.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.yenicilh.routingdatasourceproject.entity.UserEntity;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(basePackages = "org.yenicilh.routingdatasourceproject.repository",
    transactionManagerRef = "transactionManager", entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource dataSource() {
        ClientDataSourceRouter dataSourceRouter = new ClientDataSourceRouter();
        dataSourceRouter.initDataSource(kilisDataSource(), antepDataSource());
        return dataSourceRouter;
    }


    @Bean(name = "datasource2")
    @ConfigurationProperties(prefix = "datasource2")
    public DataSource antepDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("datasource2.url"));
        dataSource.setUsername(env.getProperty("datasource2.username"));
        dataSource.setPassword(env.getProperty("datasource2.password"));
        return dataSource;
    }

    @Bean(name = "datasource1")
    @ConfigurationProperties(prefix = "datasource1")
    public DataSource kilisDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("datasource1.url"));
        dataSource.setUsername(env.getProperty("datasource1.username"));
        dataSource.setPassword(env.getProperty("datasource1.password"));
        return dataSource;
    }


    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource()).packages(UserEntity.class).build();
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(
    @Autowired @Qualifier("entityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            ) {
         return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean.getObject()));
    }

}
