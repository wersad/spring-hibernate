package pl.coderslab.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonGroupDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonGroup;

@Controller
public class PersonController {

	private final PersonDao personDao;
	
	private final PersonGroupDao personGroupDao;
	
	public PersonController(@Autowired PersonDao personDao, @Autowired PersonGroupDao personGroupDao) {
		this.personDao = personDao;
		this.personGroupDao = personGroupDao;
	}
	
	@GetMapping(path = "/person/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("person", new Person());
		return "person/registration";
	}

	@PostMapping(path = "/person/register")
	public String registerPerson(@ModelAttribute("person") Person person) {
		
		String login = person.getLogin();
		String email = person.getEmail();
		String password = person.getPassword();
		PersonGroup group = person.getPersonGroup();
		
		
		System.out.println("Login: " + login + "group_id: "+group.getId() + ", group_name: " + group.getName());
		
		if(login != null && !login.isEmpty() && email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			
			personDao.save(person);
			
			return "person/success";
		}
		
		return "person/failure";
	}
	
	@ModelAttribute("groups")
	public List<PersonGroup> groups() {
		return personGroupDao.findAll();
	}
	
	@PostConstruct
	public void init() throws Exception {
		
		personGroupDao.save(new PersonGroup("grupa 1"));
		personGroupDao.save(new PersonGroup("grupa 2"));
		personGroupDao.save(new PersonGroup("grupa 3"));
		personGroupDao.save(new PersonGroup("grupa 4"));
	}
}