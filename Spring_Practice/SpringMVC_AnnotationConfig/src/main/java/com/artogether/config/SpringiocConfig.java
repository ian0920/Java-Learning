package com.artogether.config;


import com.artogether.util.DataBaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com")
//告訴Spring 需要創建Bean類的物件在哪，與springmvcConfig內的@ComponentScan作用相同
@EnableAspectJAutoProxy   //Spring AOP
@EnableTransactionManagement   //交易控制
public class SpringiocConfig {



/****************************************************************
        - 設定DataSource
            · 設定Driver class
            · 設定連線的url
            · 設定帳號密碼
 ****************************************************************/

//    @Bean
//    public DriverManagerDataSource datasource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(DataBaseUtil.databaseDriver);
//        dataSource.setUrl(DataBaseUtil.getFullUrl());
//        dataSource.setUsername(DataBaseUtil.username);
//        dataSource.setPassword(DataBaseUtil.password);
//        return dataSource;
//    }


/****************************************************************
            - 設定DataSource 用 Hikari connection pool
                · 先確定pom檔是否有加入hikari cp的依賴
                · 設定連線的url
                · 設定帳號密碼
 ****************************************************************/

    @Bean
    public DataSource datasource() {

        //使用前確認帳號、密碼及url等各項設定
        //DataBaseUtil中可設定所需的資料

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(DataBaseUtil.databaseDriver);
        dataSource.setJdbcUrl(DataBaseUtil.getFullUrl());
        dataSource.setUsername(DataBaseUtil.username);
        dataSource.setPassword(DataBaseUtil.password);
        dataSource.setMaximumPoolSize(10);
        dataSource.setMinimumIdle(5);
        dataSource.setIdleTimeout(30000);

        //HikariCP推薦的mysql設定 https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration
        dataSource.addDataSourceProperty("cachePrepStmts", "true");
        dataSource.addDataSourceProperty("prepStmtCacheSize", "250");
        dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource.addDataSourceProperty("useServerPrepStmts", "true");
        dataSource.addDataSourceProperty("useLocalSessionState", "true");
        dataSource.addDataSourceProperty("rewriteBatchedStatements", "true");
        dataSource.addDataSourceProperty("cacheResultSetMetadata", "true");
        dataSource.addDataSourceProperty("cacheServerConfiguration", "true");
        dataSource.addDataSourceProperty("elideSetAutoCommits", "true");
        dataSource.addDataSourceProperty("maintainTimeStats", "false");





        return dataSource;
    }



/****************************************************************
        - 設定SessionFactory
            · 設定Session factory所使用的dataSource
            · 設定要交易管理的package (dao所在的package)
 ****************************************************************/

    @Bean
    public LocalSessionFactoryBean localSessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(datasource());
        localSessionFactoryBean.setPackagesToScan("com.artogether");//VO所在的package
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        return localSessionFactoryBean;
    }

/****************************************************************
        - 使用Hibernate的交易管理
            · 確定是否有使用@EnableTransactionManagement
            · 設定Hibernate交易時要使用的Session factory
 ****************************************************************/

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactory().getObject());
        return hibernateTransactionManager;
    }

/****************************************************************
        - 使用JDBC的交易管理
            · 確定是否有使用@EnableTransactionManagement
            · 將datasource交給transaction manager 管理
 ****************************************************************/


    @Bean
    public PlatformTransactionManager jdbcTransactionManager() {
       PlatformTransactionManager jdbcTransactionManager
               = new DataSourceTransactionManager(datasource());
        return jdbcTransactionManager;
    }


/****************************************************************
        - Hibernate的設定
            · 設定Hibernate方言
            · 設定Hibernate執行時會顯示sql查詢語句
 ****************************************************************/

    private final Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }




}
