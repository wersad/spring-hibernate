package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.coderslab.conf.AppConfiguration;

public class SpringDiApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext();
		
		context.register(AppConfiguration.class);
		context.refresh();
		
		context.close();
	}

}
