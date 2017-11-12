package pl.coderslab.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookstorePersistenceUnit");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("\n\nEntityManager was successfully created " + entityManager + "\n\n");
		
		EntityTransaction transaction = null;
		
		try {
			
			transaction = entityManager.getTransaction();
		
			transaction.begin();
			Publisher publisher = entityManager.merge(new Publisher(1, "Publisher nie zaladowany ze skryptu"));
			
			for(int i = 0; i < 10; i++) {
				Book book = new Book("Tytul nie zaladowany ze skryptu", "Autor nie zaladowany ze skryptu", new BigDecimal(0), publisher, "Opis nie zaladowany ze skryptu");
				entityManager.persist(book);
			}
			
			entityManager.flush();
			
			transaction.commit();
			
		} catch(Exception e) {
			
			transaction.rollback();
			e.printStackTrace();
		} finally {
			
			entityManager.close();
			entityManagerFactory.close();
		}
	}
}