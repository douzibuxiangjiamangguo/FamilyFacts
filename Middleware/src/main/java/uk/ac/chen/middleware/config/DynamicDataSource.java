package uk.ac.chen.middleware.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Qiuyu
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private volatile static DynamicDataSource dynamicDataSource;

    private  final Map<Object,Object> dataSourceMap = new ConcurrentHashMap<>();

    private final ThreadLocal<String> contextHolder = new ThreadLocal<>();


    @Override
    protected Object determineCurrentLookupKey() {
        return contextHolder.get();
    }

    public DynamicDataSource(DataSource defaultDataSource) {
        dataSourceMap.put("master",defaultDataSource);
        setTargetDataSources(dataSourceMap);
        setDefaultTargetDataSource(defaultDataSource);
        dynamicDataSource = this;

    }

    public static boolean isExistDataSource(String dataBaseKey) {
        if (dynamicDataSource != null) {
            return dynamicDataSource.getDataSourceMap().containsKey(dataBaseKey);
        } else {
            return false;
        }
    }

    public static void setDataSourceKey(String key) {
        if (dynamicDataSource != null) {
            dynamicDataSource.getContextHolder().set(key);
            dynamicDataSource.afterPropertiesSet();
        }
    }

    public static String getDataSourceKey() {
        if (dynamicDataSource != null) {
            return dynamicDataSource.getContextHolder().get();
        } else {
            return null;
        }
    }

    public static void clearDataSourceKey() {
        if (dynamicDataSource != null) {
            dynamicDataSource.getContextHolder().remove();
        }
    }

    public static void addDataSource(String database, DataSource dataSource) {
        if (dynamicDataSource == null) {
            return;
        }
        if (!isExistDataSource(database)) {
            dynamicDataSource.getDataSourceMap().put(database, dataSource);
        }
        checkoutDataSource(database);
    }

    public static void checkoutDataSource(String databaseKey) {
        if (dynamicDataSource != null) {
            // 切换数据源
            setDataSourceKey(databaseKey);
            dynamicDataSource.afterPropertiesSet();
        }
    }

    public Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    public ThreadLocal<String> getContextHolder() {
        return contextHolder;
    }
}
