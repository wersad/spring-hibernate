package pl.coderslab.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pl.coderslab.entity.Book;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookstorePersistenceUnit");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("\n\nEntityManager was successfully created " + entityManager + "\n\n");
		
		Book book = new Book("Tytul nie zaladowany ze skryptu", "Autor nie zaladowany ze skryptu", "Opis nie zaladowany ze skryptu");
		
		EntityTransaction transaction = null;
		
		try {
			
			transaction = entityManager.getTransaction();
		
			transaction.begin();
		
			entityManager.persist(book);
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