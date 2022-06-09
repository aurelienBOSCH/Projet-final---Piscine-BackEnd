package com.inti.ProjetFinalPiscineSpring.controller;

import java.util.List;

import com.inti.ProjetFinalPiscineSpring.model.Planning;
import com.inti.ProjetFinalPiscineSpring.repository.PlanningRepository;

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
public class PlanningController
{

	@Autowired
	PlanningRepository planningRepository;
	
	@GetMapping("/listSchedules") // dans une application REST on a tout intéret à utiliser cette méthode
	public ResponseEntity<List<Planning>> getAllSchedules()
	{
		return new ResponseEntity<List<Planning>>(planningRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping ("/saveSchedule")
	public ResponseEntity<Planning> saveSchedule(@RequestBody Planning planning)
	{
		return new ResponseEntity<Planning>(planningRepository.save(planning), HttpStatus.CREATED);
	}
	
	

	@DeleteMapping ("/deleteSchedule/{id}")
	public void deleteSchedule(@PathVariable int id) 
	{
		 planningRepository.deleteById(id);
	
	}
	
	@GetMapping("/getSchedule/{id}") 
	public Planning getPlanning(@PathVariable int id)
	{
		return planningRepository.getReferenceById(id);
	}
	
	@PutMapping("/updateSchedule/{id}")
	public void updatePlanning(@RequestBody Planning planning, @PathVariable int id)
	{
		Planning p1 = planningRepository.getReferenceById(id);
	
		planningRepository.save(p1);
	}
}