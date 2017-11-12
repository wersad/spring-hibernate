package pl.coderslab.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "myTitle", length = 80, nullable = false)
	private String title;

	private String author;
	
	@Column(scale = 2, precision = 4)
	private BigDecimal rating;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Publisher publisher;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	public Book() {}
	
	public Book(long id, String title, String author, BigDecimal rating, Publisher publisher, String description) {
		this(title, author, rating, publisher, description);
		this.id = id;
	}
	
	public Book(String title, String author, BigDecimal rating, Publisher publisher, String description) {
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
	
	public Publisher getPublisher() {
		return this.publisher;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}