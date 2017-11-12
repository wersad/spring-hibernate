package pl.coderslab.conf;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import pl.coderslab.covnerter.PersonGroupConverter;
import pl.coderslab.covnerter.PublisherConverter;

@ComponentScan(basePackages = {"pl.coderslab.dao", "pl.coderslab.controller"})
@EnableTransactionManagement
@EnableWebMvc
@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

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
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(personGroupConverter());
		registry.addConverter(publisherConverter());
	}
	
	@Bean
	public PersonGroupConverter personGroupConverter() {
		return new PersonGroupConverter();
	}
	
	@Bean
	public PublisherConverter publisherConverter() {
		return new PublisherConverter();
	}
}