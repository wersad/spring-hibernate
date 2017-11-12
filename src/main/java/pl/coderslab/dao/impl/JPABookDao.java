package pl.coderslab.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

@Component
@Transactional
public class JPABookDao implements BookDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Book save(Book entity) {
		return entityManager.merge(entity);
	}

	@Override
	public Book update(Book entity) {
		Book book = entityManager.merge(entity);
		return book;
	}

	@Override
	public Book findById(long id) {
		Book book = entityManager.find(Book.class, id);
		return book;
	}

	@Override
	public void removeById(long id) {
		Book entity = entityManager.find(Book.class, id);
		entityManager.remove(entity);
	}

	@Override
	public List<Book> findAll() {
		Query query = entityManager.createQuery("Select b from Book b");
		return query.getResultList();
	}
}