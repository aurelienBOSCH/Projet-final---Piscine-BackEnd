package com.inti.ProjetFinalPiscineSpring.controller;

import java.util.List;

import com.inti.ProjetFinalPiscineSpring.model.Personne;
import com.inti.ProjetFinalPiscineSpring.repository.PersonneRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
public class PersonneController
{

	@Autowired
	PersonneRepository personneRepository;
	
	@GetMapping("/listPersons") // dans une application REST on a tout intéret à utiliser cette méthode
	public ResponseEntity<List<Personne>> getAllPersons()
	{
		return new ResponseEntity<List<Personne>>(personneRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping ("/savePerson")
	public ResponseEntity<Personne> savePerson(@RequestBody Personne personne)
	{
		return new ResponseEntity<Personne>(personneRepository.save(personne), HttpStatus.CREATED);
	}
	
	

	@DeleteMapping ("/deletePerson/{id}")
	public void deletePerson(@PathVariable int id) 
	{
		 personneRepository.deleteById(id);
	
	}
	
	@GetMapping("/getPerson/{id}") 
	public Personne getPersonne(@PathVariable int id)
	{
		return personneRepository.getReferenceById(id);
	}
	
	@PutMapping("/updatePerson/{id}")
	public void updatePersonne(@RequestBody Personne personne, @PathVariable int id)
	{
		Personne p1 = personneRepository.getReferenceById(id);
	
		personneRepository.save(p1);
	}
}
