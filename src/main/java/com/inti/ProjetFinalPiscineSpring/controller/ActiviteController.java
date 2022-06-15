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
	
	@GetMapping("/listActivities") // dans une application REST on a tout intéret à utiliser cette méthode
	public ResponseEntity<List<Activite>> getAllActivities()
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
	
//	@GetMapping("/getActivity/{idActivite}") 
//	public Activite getActivite(@PathVariable int idActivite)
//	{
//		return activiteRepository.getReferenceById(idActivite);
//	}
	
	@GetMapping("/getActivity/{idActivite}") 
	public Activite getActivite(@PathVariable int idActivite)
	{
		return activiteRepository.findById(idActivite).get();
	}
	//cette méthode comparée a celle d'au-dessus permet d'éviter l'erreur : 
		//No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
		//https://stackoverflow.com/questions/52656517/no-serializer-found-for-class-org-hibernate-proxy-pojo-bytebuddy-bytebuddyinterc
	
	//(en gros: avec cette méthode on accède directement à la base de donnée)
	
	@PutMapping("/updateActivity")
	public Activite updateActivite(@RequestBody Activite activite)
	{
		return activiteRepository.save(activite);
	}
	
	@PutMapping("/setPlanningToActivity/{idActivite}/{idPlanning}")
	public void setPlanningToActivity(@PathVariable int idActivite, @PathVariable int idPlanning)
	{
		Activite a1 = activiteRepository.getReferenceById(idActivite);
		activiteRepository.SetPlanningToActivity(a1.getIdActivite(), idPlanning);
	}
	
	@GetMapping("/listActivitiesSameName/{nomActivite}")
	public ResponseEntity<List<Activite>> getAllActivitiesSameName(@PathVariable String nomActivite)
	{
		return new ResponseEntity<List<Activite>>(activiteRepository.findAllActivitiesSameName(nomActivite), HttpStatus.OK);
	}
	
	@GetMapping("/listEachActivityType")
	public ResponseEntity<List<String>> getListeEachActivityType()
	{
		return new ResponseEntity<List<String>>(activiteRepository.findListeEachActivityType(), HttpStatus.OK);
	}
	
	
	
}