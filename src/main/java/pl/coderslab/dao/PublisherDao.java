package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.Publisher;

public interface PublisherDao {

	List<Publisher> findAll();
	Publisher findById(long id);
	void save(Publisher entity);
	
}
