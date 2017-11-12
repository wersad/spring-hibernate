package pl.coderslab.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

@Component
@Transactional
public class JPAPublisherDao implements PublisherDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Publisher> findAll() {
		Query query = entityManager.createQuery("SELECT p from Publisher p");
		List<Publisher> result = query.getResultList();
		return result;
	}

	@Override
	public void save(Publisher entity) {
		entityManager.persist(entity);
	}

	@Override
	public Publisher findById(long id) {
		return entityManager.find(Publisher.class, id);
	}
}
