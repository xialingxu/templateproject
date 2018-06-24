package com.jeffrey.templateproject.dal.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class dataSourceConfig {

    @Bean(name = "dataSource")
    //@Profile("defaultDataSource")
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://jeffreydb.mysql.rds.aliyuncs.com:3306/sys?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("jeffrey1018321!Z");
        ds.setInitialSize(5);
        ds.setMaxTotal(100);
        return ds;
    }

    @Bean(name = "springMVCdataSource")
    //@Profile("springMVC")
    public DataSource springMVCdataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://jeffreydb.mysql.rds.aliyuncs.com:3306/springmvcdb?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("jeffrey1018321!Z");
        ds.setInitialSize(5);
        ds.setMaxTotal(100);
        return ds;
    }

}
