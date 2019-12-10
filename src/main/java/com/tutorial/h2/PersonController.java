package com.tutorial.h2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/persons")
	private List<Person> getAllPersons() {
		
		return personService.getAllPersons();
	}
	
	@GetMapping("/persons/{id}")
	private Person getPerson(@PathVariable("id") int id) {
		
		return personService.getPersonById(id);
	}
	
	@DeleteMapping("/persons/{id}")
	private String deletePerson(@PathVariable("id") int id) {
		personService.delete(id);
		return "Delete Successful";
	}
	
	@PostMapping("/persons")
	private String savePerson(@RequestBody Person person) {
		personService.saveOrUpdate(person);
		int id = person.getId(); 
		return "The record is successfully saved with ID:" +id;
	}

}
