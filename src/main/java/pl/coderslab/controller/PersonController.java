package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

@Controller
public class PersonController {

	private final PersonDao personDao;
	
	public PersonController(@Autowired PersonDao personDao) {
		this.personDao = personDao;
	}
	
	@GetMapping(path = "/person/register")
	public String showRegistrationForm() {
		return "person/registration";
	}

	@PostMapping(path = "/person/register")
	public String registerPerson(@RequestParam(name = "login") String login, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password, Model model) {
		
		if(login != null && !login.isEmpty() && email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
			
			Person person = new Person(login, password, email);
			
			personDao.save(person);
			
			model.addAttribute("person", person);
			
			return "person/success";
		}
		
		return "person/failure";
	}
}