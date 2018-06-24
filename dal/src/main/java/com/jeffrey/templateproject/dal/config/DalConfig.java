package com.jeffrey.templateproject.dal.config;

import com.jeffrey.templateproject.dal.data.JdbcSpitterRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
//@Import({ OrderConfig.class, MemberConfig.class })
@Import({ dataSourceConfig.class})
public class DalConfig {

    /**
     * 指定所有参数连接数据源
     *
     * @param connectURI
     *            数据库
     * @param username
     *            用户名
     * @param pswd
     *            密码
     * @param driverClass
     *            数据库连接驱动名
     * @param initialSize
     *            初始连接池连接个数
     * @param maxtotal
     *            最大活动连接数
     * @param maxIdle
     *            最大连接数
     * @param maxWaitMillis
     *            获得连接的最大等待毫秒数
     * @param minIdle
     *            最小连接数
     * @return
     */

    /*以下是jdbc访问内容*/
    @Bean
    public JdbcOperations jdbcTemplate(@Qualifier("springMVCdataSource") DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcSpitterRepository spitterRepository(JdbcOperations jdbc) {
        return new JdbcSpitterRepository(jdbc);
    }

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcTemplate(DataSource dataSource)
    {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    /*以下是spring data jpa访问内容*/



    /*以上是spring data jpa访问内容*/






}
