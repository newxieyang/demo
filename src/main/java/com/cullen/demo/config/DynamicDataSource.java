package com.cullen.demo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

import javax.sql.DataSource;

/**
 * 动态数据源
 *
 * @Author: 谢洋   newxieyang@msn.cn
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDateSoureType();
    }
}