package com.inti.ProjetFinalPiscineSpring.controller;

import java.util.List;

import com.inti.ProjetFinalPiscineSpring.model.Activite;
import com.inti.ProjetFinalPiscineSpring.repository.ActiviteRepository;

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
public class ActiviteController
{

	@Autowired
	ActiviteRepository activiteRepository;
	
	@GetMapping("/listActivitys") // dans une application REST on a tout intéret à utiliser cette méthode
	public ResponseEntity<List<Activite>> getAllActivitys()
	{
		return new ResponseEntity<List<Activite>>(activiteRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping ("/saveActivity")
	public ResponseEntity<Activite> saveActivity(@RequestBody Activite activite)
	{
		return new ResponseEntity<Activite>(activiteRepository.save(activite), HttpStatus.CREATED);
	}
	
	

	@DeleteMapping ("/deleteActivity/{idActivite}")
	public void deleteActivity(@PathVariable int idActivite) 
	{
		 activiteRepository.deleteById(idActivite);
	
	}
	
	@GetMapping("/getActivity/{idActivite}") 
	public Activite getActivite(@PathVariable int id)
	{
		return activiteRepository.getReferenceById(id);
	}
	
	@PutMapping("/updateActivity/{idActivite}")
	public void updateActivite(@RequestBody Activite activite, @PathVariable int idActivite)
	{
		Activite a1 = activiteRepository.getReferenceById(idActivite);
	
		activiteRepository.save(a1);
	}
	
	@PutMapping("/setPlanningToActivity/{idActivite}/{idPlanning}")
	public void setPlanningToActivity(@RequestBody Activite activite, @PathVariable int idActivite, @PathVariable int idPlanning)
	{
		Activite a1 = activiteRepository.getReferenceById(idActivite);
		activiteRepository.SetPlanningToActivity(idActivite, idPlanning);
	}
	
	
}