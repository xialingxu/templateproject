package config;

import data.JdbcSpitterRepository;
import data.SpitterRepository;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan
//@Import({ OrderConfig.class, MemberConfig.class })
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

}
