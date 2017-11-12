package pl.coderslab.conf;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "pl.coderslab.dao")
@ComponentScan(basePackages = "pl.coderslab.controller")
@EnableTransactionManagement
@EnableWebMvc
@Configuration
public class AppConfiguration {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
	    LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
	    emfb.setPersistenceUnitName("bookstorePersistenceUnit");
	    return emfb;
	}
	 
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	    JpaTransactionManager tm = new JpaTransactionManager(emf);
	    return tm;
	}
}