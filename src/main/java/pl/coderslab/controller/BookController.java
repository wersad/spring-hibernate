package pl.coderslab.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@RestController
public class BookController {
	
	private final BookDao bookDao;
	
	public BookController(@Autowired BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@GetMapping(path = "/book")
	public String index() {
		return "book/index";
	}
	
	@GetMapping(path = "/book/find/{id:\\d+}")
	@ResponseBody
	public String findById(@PathVariable(name = "id", required = true) long id) {
		
		Book book = bookDao.findById(id);
		
		return "{\"id\" : " + book.getId() + ", \"title\" : \"" + book.getTitle() + "\", \"publisher\" : \"" + book.getPublisher().getName() + "\"}";
	}
	
	@PostMapping(path = "/book/save")
	@ResponseBody
	public String save() {
		
		Book entity = 
				new Book("Testowy tytul", "Testowy autor", new BigDecimal(0), new Publisher(1, "Testowy publisher"), "Testowy opis");
		
		try {
			
			bookDao.save(entity);
			System.out.println("Saved book has id: " + entity.getId());
			
			
			return "{\"status\" : true, \"id\" : " + entity.getId() + "}";
		} catch(Exception e) {	
			e.printStackTrace();
			return "{\"status\" : false}";
		}
	}
	
	@PutMapping(path = "/book/update")
	@ResponseBody
	public String update() {
		
		Book entity = 
				new Book(1l, "Zmieniony tytul", "Zmieniony autor", new BigDecimal(0), new Publisher(1, "Zmieniony publisher"), "Zmieniony opis");
		
		try {
		
			Book book = bookDao.update(entity);
			return "{\"status\" : true, \"id\" : " + book.getId() + "}";
		} catch(Exception e) {
			e.printStackTrace();
			return "{\"status\" : false}";
		}
	}
	
	@DeleteMapping(path = "/book/remove")
	@ResponseBody
	public String removeById() {
			
		try {
		
			bookDao.removeById(1l);
			return "{\"status\" : true, \"id\" : " + 1l + "}";
		} catch(Exception e) {
			e.printStackTrace();
			return "{\"status\" : false}";
		}
	}
}