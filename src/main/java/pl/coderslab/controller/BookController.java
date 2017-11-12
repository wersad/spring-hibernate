package pl.coderslab.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

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
	
	@PostMapping(path = "/book/save")
	@ResponseBody
	public String save() {
		
		Book entity = 
				new Book("Testowy tytul", "Testowy autor", new BigDecimal(0), "Testowy publisher", "Testowy opis");
		
		try {
			
			bookDao.save(entity);
			System.out.println("Saved book has id: " + entity.getId());
			
			
			return "{\"status\" : true, \"id\" : " + entity.getId() + "}";
		} catch(Exception e) {	
			e.printStackTrace();
			return "{\"status\" : false}";
		}
	}
}