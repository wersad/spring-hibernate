package pl.coderslab.dao;

import pl.coderslab.entity.Book;

public interface BookDao {

	public void save(Book entity);
	public Book update(Book entity);
	public Book findById(long id);
	public void removeById(long id);
}
