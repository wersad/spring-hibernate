package pl.coderslab.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookstorePersistenceUnit");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("\n\nEntityManager was successfully created " + entityManager + "\n\n");
		
		entityManager.close();
		entityManagerFactory.close();
	}
}