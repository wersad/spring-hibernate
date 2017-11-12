package pl.coderslab.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.dto.PersonDetailsDTO;

@Controller
public class PersonDetailController {

	@GetMapping(path = "/personDetails/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("person", new PersonDetailsDTO());
		return "personDetails/registration";
	}

	@PostMapping(path = "/personDetails/register")
	public String registerPerson(@ModelAttribute("person") PersonDetailsDTO personDetailsDTO, Model model) {
		
		String message = personDetailsDTO.toString();
		model.addAttribute("message", message);
		
		return "personDetails/success";
	}
	
	@ModelAttribute("languages")
	public List<String> languages() {
		return Arrays.asList("java", "php", "ruby", "python");
	}
	
	@ModelAttribute("countryItems")
	public List<String> countryItems() {
		return Arrays.asList("Polska", "Niemcy", "Czechy", "USA");
	}
	
	@ModelAttribute("hobbies")
	public List<Hobby> hobbies() {
		return Arrays.asList(new Hobby(1, "programowanie"), new Hobby(2, "sport"), new Hobby(3, "turystyka"));
	}
	
	static class Hobby {
		
		private int id;
		private String name;
		
		public Hobby(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return this.id;
		}

		public String getName() {
			return this.name;
		}
	}
}
