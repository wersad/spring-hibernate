package pl.coderslab.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	public Publisher() {}
	
	@OneToMany(mappedBy = "publisher", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Book> books;
	
	public Publisher(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Publisher(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public List<Book> getBooks() {
		return this.books;
	}
}
