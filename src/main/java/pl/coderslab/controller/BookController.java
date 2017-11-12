package pl.coderslab.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
public class BookController {
	
	private final BookDao bookDao;
	
	private final PublisherDao publisherDao;
	
	public BookController(@Autowired BookDao bookDao, @Autowired PublisherDao publisherDao) {
		this.bookDao = bookDao;
		this.publisherDao = publisherDao;
	}
	
	@GetMapping(path = "/book")
	public String index(Model model) {
		model.addAttribute(new Book());
		return "book/index";
	}
	
	@GetMapping(path = "/book/list")
	public String list(Model model) {
		
		List<Book> books = bookDao.findAll();
		
		model.addAttribute("books", books);
		return "book/list";
	}
	
	@GetMapping(path = "/book/find/{id:\\d+}")
	@ResponseBody
	public String findById(@PathVariable(name = "id", required = true) long id) {
		
		Book book = bookDao.findById(id);
		
		return "{\"id\" : " + book.getId() + ", \"title\" : \"" + book.getTitle() + "\", \"publisher\" : \"" + book.getPublisher().getName() + "\"}";
	}
	
	@PostMapping(path = "/book/save")
	public String save(@ModelAttribute("book") Book book, Model model) {
		
		try {
			
			Book result = bookDao.save(book);
			model.addAttribute("book", result);
			
			return "redirect:list";
		} catch(Exception e) {	
			e.printStackTrace();
			return "book/failure";
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
	
	@ModelAttribute("publishers")
	public List<Publisher> publishers() {
		return publisherDao.findAll();
	}
	
	@PostConstruct
	public void init() throws Exception {
		
		publisherDao.save(new Publisher("wydawca 1"));
		publisherDao.save(new Publisher("wydawca 2"));
		publisherDao.save(new Publisher("wydawca 3"));
		publisherDao.save(new Publisher("wydawca 4"));
	}
}