package pl.coderslab.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}