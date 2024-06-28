package org.yenicilh.routingdatasourceproject.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfig {

    private final Environment env;

    public DataSource dataSourceRouter() {
        Map<Object, Object> targetDataSource = new LinkedHashMap<>();
        DataSource dataSource1 = DataSourceBuilder.create()
                .url(env.getProperty("spring.datasource1.url"))
                .username(env.getProperty("spring.datasource1.username"))
                .password(env.getProperty("spring.datasource1.password"))
                .build();

        DataSource dataSource2 = DataSourceBuilder.create()
                .url(env.getProperty("spring.datasource2.url"))
                .username(env.getProperty("spring.datasource2.username"))
                .password(env.getProperty("spring.datasource2.password"))
                .build();

        targetDataSource.put(ClientDatabase.DB_1, dataSource1);
        targetDataSource.put(ClientDatabase.DB_2, dataSource2);

        ClientDataSourceRouter router = new ClientDataSourceRouter();
        router.setTargetDataSources(targetDataSource);
        router.setDefaultTargetDataSource(dataSource1);
        return router;


    }


}
