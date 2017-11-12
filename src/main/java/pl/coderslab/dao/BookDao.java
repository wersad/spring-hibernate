package pl.coderslab.dao;

import java.util.List;

import pl.coderslab.entity.Book;

public interface BookDao {

	public Book save(Book entity);
	public Book update(Book entity);
	public Book findById(long id);
	public void removeById(long id);
	public List<Book> findAll();
}
