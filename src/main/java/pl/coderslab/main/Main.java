package pl.coderslab.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.coderslab.entity.Book;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookstorePersistenceUnit");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("\n\nEntityManager was successfully created " + entityManager + "\n\n");
		
		EntityTransaction transaction = null;
		
		try {
			
			transaction = entityManager.getTransaction();
		
			transaction.begin();
			
			Query query = entityManager.createQuery("SELECT b from Book b where b.id between :startId and :endId");
			query.setParameter("startId", 2l);
			query.setParameter("endId", 4l);
			
			List<Book> books = query.getResultList();
			
			System.out.println("Books: " + books);
			
			/*Publisher publisher = entityManager.merge(new Publisher(1, "Publisher nie zaladowany ze skryptu"));
			
			for(int i = 0; i < 10; i++) {
				Book book = new Book("Tytul nie zaladowany ze skryptu", "Autor nie zaladowany ze skryptu", new BigDecimal(0), publisher, "Opis nie zaladowany ze skryptu");
				entityManager.persist(book);
			}
			
			entityManager.flush();*/
			
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