package br.com.fornax.sustentacao.dao.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySources({ @PropertySource("classpath:/br/com/fornax/sustentacao/database.properties") })
@EnableTransactionManagement
public class ConfigDAO {

	@Inject
	private Environment env;

	@Bean(name = "entityManagerFactory")
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "br.com.fornax.sustentacao.dao.entity" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getProperty("br.com.fornax.sustentacao.database.driver"));
		dataSource.setUrl(env.getProperty("br.com.fornax.sustentacao.database"));
		dataSource.setUsername(env.getProperty("br.com.fornax.sustentacao.database.user"));
		dataSource.setPassword(env.getProperty("br.com.fornax.sustentacao.database.password"));

		return dataSource;
	}

	@Bean
	PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	@Bean
	PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer proConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();

		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("br.com.fornax.sustentacao.database.hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", env.getProperty("br.com.fornax.sustentacao.database.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("br.com.fornax.sustentacao.database.hibernate.show_sql"));

		return properties;
	}
}