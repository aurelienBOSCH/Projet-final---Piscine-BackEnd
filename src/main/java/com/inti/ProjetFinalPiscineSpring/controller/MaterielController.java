package com.inti.ProjetFinalPiscineSpring.controller;

import java.util.List;

import com.inti.ProjetFinalPiscineSpring.model.Materiel;
import com.inti.ProjetFinalPiscineSpring.repository.MaterielRepository;

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
public class MaterielController
{

	@Autowired
	MaterielRepository materielRepository;
	
	@GetMapping("/listEquipments") // dans une application REST on a tout intéret à utiliser cette méthode
	public ResponseEntity<List<Materiel>> getAllEquipments()
	{
		return new ResponseEntity<List<Materiel>>(materielRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping ("/saveEquipment")
	public ResponseEntity<Materiel> saveEquipment(@RequestBody Materiel materiel)
	{
		return new ResponseEntity<Materiel>(materielRepository.save(materiel), HttpStatus.CREATED);
	}
	
	

	@DeleteMapping ("/deleteEquipment/{id}")
	public void deleteEquipment(@PathVariable int id) 
	{
		 materielRepository.deleteById(id);
	
	}
	
	@GetMapping("/getEquipment/{id}") 
	public Materiel getMateriel(@PathVariable int id)
	{
		return materielRepository.getReferenceById(id);
	}
	
	@PutMapping("/updateEquipment/{id}")
	public void updateMateriel(@RequestBody Materiel materiel, @PathVariable int id)
	{
		Materiel m1 = materielRepository.getReferenceById(id);
	
		materielRepository.save(m1);
	}
}