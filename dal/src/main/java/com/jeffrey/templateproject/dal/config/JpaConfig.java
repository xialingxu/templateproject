package com.jeffrey.templateproject.dal.config;

import com.jeffrey.templateproject.dal.dbbiz.TransactionBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages={"com.jeffrey.templateproject.dal.data"})
//@Import({ CustomerConfig.class, SchedulerConfig.class })
@Import({ dataSourceConfig.class})
//@ComponentScan(basePackages = {"data"})
public class JpaConfig {

/*
    以下配置，异常后没有回滚
    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(); // does this need an emf???
    }*/

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        //emf.setPersistenceUnitName("data");
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("com.jeffrey.templateproject.dal.entity");
        return emf;
    }

    @Bean
    public TransactionBiz transactionBiz(){return new TransactionBiz();}

    /*以下是事务起作用的核心配置*/
    @Configuration
    @EnableTransactionManagement //启动事务，必须要添加。
    public static class TransactionConfig {

        @Autowired
        private EntityManagerFactory emf;

        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        }
    }



}
