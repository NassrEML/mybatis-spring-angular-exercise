package com.nassreml.springchallenge;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.nassreml.springchallenge.repository")
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource sdds = new SimpleDriverDataSource();
        sdds.setDriverClass(org.mariadb.jdbc.Driver.class);
        sdds.setUrl("jdbc:mariadb://localhost:3306/autentia_challenge");
        sdds.setUsername("root");
        sdds.setPassword("root");
        return sdds;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }
}
