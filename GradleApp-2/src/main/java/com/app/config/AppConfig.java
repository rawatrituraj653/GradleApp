package com.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.app.model.Item;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.app")
@EnableTransactionManagement
public class AppConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource source() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.driver"));
		System.out.println(environment.getProperty("db.driver"));
		dataSource.setUrl(environment.getProperty("db.url"));
		System.out.println(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.user"));
		System.out.println(environment.getProperty("db.user"));
		dataSource.setPassword(environment.getProperty("db.password"));
		System.out.println(environment.getProperty("db.password"));
		System.out.println(dataSource);
		return dataSource;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setDataSource(source());
		factoryBean.setAnnotatedClasses(Item.class);
		factoryBean.setHibernateProperties(properties());
		return factoryBean;
	}
	@Bean
	public  Properties properties() {
		Properties  prop=new Properties();
		prop.setProperty("hibernate.dialect", environment.getProperty("orm.dialect"));
		prop.setProperty("hibernate.show_sql",environment.getProperty("orm.show"));
		prop.setProperty("hibernate.format_sql",environment.getProperty("orm.fmt"));
		prop.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("orm.ddl"));
		return prop;
	}
	
	@Bean
	public HibernateTemplate htm() {
		
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		System.out.println(sessionFactoryBean().getObject());
		hibernateTemplate.setSessionFactory(sessionFactoryBean().getObject());
		return hibernateTemplate;
	}
	
	@Bean("transactionManager")
	public HibernateTransactionManager manager() {
		HibernateTransactionManager manager=new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactoryBean().getObject());
		return manager;
	}
	
}
