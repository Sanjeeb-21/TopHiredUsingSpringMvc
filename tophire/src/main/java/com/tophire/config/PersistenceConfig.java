package com.tophire.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = {"com.tophire.repositories"})
public class PersistenceConfig {
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource  dataSource=null;
		dataSource=new DriverManagerDataSource(environment.getProperty("db.url"),environment.getProperty("db.username"), environment.getProperty("db.password"));
		dataSource.setDriverClassName (environment.getProperty("db.driverClassName"));
		return dataSource;
		
	}
	@Bean
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		
		 LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean=null;
		 HibernateJpaVendorAdapter jpaVendorAdapter=null;
		 
		 jpaVendorAdapter=new HibernateJpaVendorAdapter();
		 jpaVendorAdapter.setShowSql(true);
		 jpaVendorAdapter.setGenerateDdl(true);
		 
		 localContainerEntityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
		 localContainerEntityManagerFactoryBean.setDataSource(dataSource);
		 localContainerEntityManagerFactoryBean.setPackagesToScan("com.tophire.entities");
		 localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		 
		 return localContainerEntityManagerFactoryBean;
		 
	 }
	@Bean
	 public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		 JpaTransactionManager jpaTransactionManager=new JpaTransactionManager(entityManagerFactory);
		 
		return jpaTransactionManager;
		 
	 }
	

}
