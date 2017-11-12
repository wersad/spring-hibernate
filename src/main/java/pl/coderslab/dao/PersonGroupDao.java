package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.PersonGroup;

public interface PersonGroupDao {

	List<PersonGroup> findAll();
	void save(PersonGroup entity);
	
}
