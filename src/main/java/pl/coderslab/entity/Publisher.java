package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	public Publisher() {}
	
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
}
