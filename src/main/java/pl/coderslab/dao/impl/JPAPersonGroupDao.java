package pl.coderslab.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.dao.PersonGroupDao;
import pl.coderslab.entity.PersonGroup;

@Component
@Transactional
public class JPAPersonGroupDao implements PersonGroupDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<PersonGroup> findAll() {
		Query query = entityManager.createQuery("SELECT pg from PersonGroup pg");
		List<PersonGroup> result = query.getResultList();
		return result;
	}

	@Override
	public void save(PersonGroup entity) {
		entityManager.persist(entity);
	}
}
