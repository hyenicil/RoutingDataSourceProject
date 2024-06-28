package org.yenicilh.routingdatasourceproject.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class ClientDataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ClientDatabaseContextHolder.getClientDatabase();
    }


    public void initDataSource(DataSource dataSource1, DataSource dataSource2) {

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(ClientDatabase.KILIS, dataSource1);
        targetDataSources.put(ClientDatabase.ANTEP,dataSource2);
        this.setTargetDataSources(targetDataSources);
        this.setDefaultTargetDataSource(dataSource1);
    }
}
