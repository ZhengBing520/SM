package incarcloud.rvm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.phoenix.query.QueryServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by bzheng on 2019/6/6.
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "primaryDataSourceProperties")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.primary.druid")
    public DataSource dataSource(@Qualifier("primaryDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return DruidDataSourceBuilder.create().build();
//        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


    @Bean(name = "phoenixDataSourceProperties")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSourceProperties rvmDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "phoenixDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary.druid")
    public DataSource rvmDataSource(@Qualifier("phoenixDataSourceProperties") DataSourceProperties dataSourceProperties) {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        Properties props = druidDataSource.getConnectProperties();
        props.setProperty(QueryServices.IS_NAMESPACE_MAPPING_ENABLED, Boolean.toString(true));
        props.setProperty(QueryServices.IS_SYSTEM_TABLE_MAPPED_TO_NAMESPACE, Boolean.toString(true));
        druidDataSource.setConnectProperties(props);
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        return druidDataSource;
//        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


//    @Bean(name = "phoenixDataSourceTransactionManager")
//    public DataSourceTransactionManager phoenixDataSourceTransactionManager(@Qualifier("phoenixDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

}
