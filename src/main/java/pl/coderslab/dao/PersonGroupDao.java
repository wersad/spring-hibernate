package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.PersonGroup;

public interface PersonGroupDao {

	List<PersonGroup> findAll();
	PersonGroup findById(long id);
	void save(PersonGroup entity);
	
}
