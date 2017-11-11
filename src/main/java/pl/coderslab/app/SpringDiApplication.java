package pl.coderslab.app;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.coderslab.conf.AppConfiguration;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

public class SpringDiApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext();
		
		context.register(AppConfiguration.class);
		context.refresh();
		
		BookDao bookDao = context.getBean(BookDao.class);
		
		Book entity = new Book("Testowy tytul", "Testowy autor", new BigDecimal(0), "Testowy publisher", "Testowy opis");
		
		try {
			bookDao.save(entity);
			System.out.println("Saved book has id: " + entity.getId());
			
		} catch(Exception e) {	
			e.printStackTrace();
		}
		
		context.close();
	}

}
