package com.incarcloud.rvm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by bzheng on 2019/6/6.
 */
@Configuration
public class JdbcTemplateConfig {

    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("phoenixDataSource")
    private DataSource phoenixDataSource;


    @Bean("jdbcTemplate")
    @Primary
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean("phoenixJdbcTemplate")
    JdbcTemplate phoenixJdbcTemplate() {
        return new JdbcTemplate(phoenixDataSource);
    }
}
