package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

@Controller
public class PersonController {

	private final PersonDao personDao;
	
	public PersonController(@Autowired PersonDao personDao) {
		this.personDao = personDao;
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
		
		System.out.println("Login: " + login);
		
		if(login != null && !login.isEmpty() && email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			
			personDao.save(person);
			
			return "person/success";
		}
		
		return "person/failure";
	}
}