package pl.coderslab.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;

	private String author;
	
	private BigDecimal rating;
	
	private String publisher;
	
	private String description;
	
	public Book() {}
	
	public Book(String title, String author, BigDecimal rating, String publisher, String description) {
		this.title = title;
		this.author = author;
		this.rating = rating;
		this.publisher = publisher;
		this.description = description;
	}

	public Long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}
	
	public BigDecimal getRating() {
		return this.rating;
	}
	
	public String getPublisher() {
		return this.publisher;
	}
	
	public String getDescription() {
		return this.description;
	}
}