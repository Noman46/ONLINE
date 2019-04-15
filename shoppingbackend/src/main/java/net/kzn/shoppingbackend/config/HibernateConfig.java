package net.kzn.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "net.kzn.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping1";
	private static final String DATABASE_DRIVER = "org.h2.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private static final String DATABASE_USERNAME = "sa";
	private static final String DATABASE_PASSWORD = "";
	
	@Bean
	public DataSource getDatasource(){
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("DATABASE_DRIVER");
		dataSource.setUrl("DATABASE_URL");
		dataSource.setUsername("DATABASE_USERNAME");
		dataSource.setPassword("DATABASE_PASSWORD");
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.kzn.shoppingbackend.dto");
		
		return builder.buildSessionFactory(); 
		
	}

	private Properties getHibernateProperties() {
		Properties  properties = new Properties();
		properties .put("hibernate.dialect", DATABASE_DIALECT);
		properties .put("hibernate.show_sql", "true");
		properties .put("hibernate.format.sql", "true");
		
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	
	

}
