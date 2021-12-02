package com.zaurtregulov.spring.rest.configuration;


import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.firebirdsql.ds.FBSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.zaurtregulov.spring.rest")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

  @Bean
  public DataSource dataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass("org.firebirdsql.jdbc.FBDriver");
    dataSource.setJdbcUrl("jdbc:firebirdsql://localhost:3050/W:/Work_2021/Spring/Spring for beginners (Zaur Tregulov)/spring_course_rest/db/test3.fdb?useSSL=false&amp;serverTimezone=UTC&amp;charSet=utf8");
    dataSource.setUser("user");
    dataSource.setPassword("user");

//    HikariDataSource dataSource = new HikariDataSource();
//    dataSource.setDriverClassName("org.firebirdsql.jdbc.FBDriver");
//    dataSource.setJdbcUrl("jdbc:firebirdsql://localhost:3050/W:/Work_2021/Spring/Spring for beginners (Zaur Tregulov)/spring_course_rest/db/test3.fdb?useSSL=false&amp;serverTimezone=UTC&amp;charSet=utf8");
//    dataSource.setUsername("user");
//    dataSource.setPassword("user");

//    FBSimpleDataSource dataSource = new FBSimpleDataSource();
//    dataSource.setDatabase("jdbc:firebirdsql://localhost:3050/W:/Work_2021/Spring/Spring for beginners (Zaur Tregulov)/spring_course_rest/db/test3.fdb");
//    dataSource.setUserName("user");
//    dataSource.setPassword("user");

    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setPackagesToScan("com.zaurtregulov.spring.rest.entity");

    Properties hibernateProps = new Properties();
    hibernateProps.setProperty("hibernate.dialect", "org.hibernate.dialect.FirebirdDialect");
    hibernateProps.setProperty("hibernate.show_sql", "true");

    sessionFactory.setHibernateProperties(hibernateProps);

    return sessionFactory;
  }

  @Bean
  public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {

    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory.getObject());

    return transactionManager;
  }


}
