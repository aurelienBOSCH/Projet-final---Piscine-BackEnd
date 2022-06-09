package com.inti.ProjetFinalPiscineSpring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.inti.ProjetFinalPiscineSpring.model.Personne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest //recupère le contexte JPA Spring (les annotations surtout), inférieur au SpringBootTest en terme de fonctionnalités
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // ON LUI DIT :"NE PREND PAS EN COMPTE LA BDD INTEGREE"
public class PersonneRepositoryTests
{
	@Autowired
	PersonneRepository personneRepository;
	
	Personne personne, personne2 , personne1;
	
	@BeforeEach
	public void setUp()
	{
		
		personne2 = new Personne("Flantier", "Noel", "oss117","astucehabile", Date.valueOf("1960-01-17"), "117 rue du pays de la liberté, Paris 75016","01.17.11.71.17","sagiraitdegrandir@pasteque.fr","client","annuel");
		personne1 = personneRepository.save(personne2);
	
	}
	
	@Test
	public void testSavePersonne()
	{
		//Given
		
		//When
		Personne savedPersonne = personneRepository.save(personne2);
		
		//Then
		
		assertThat(savedPersonne).isNotNull();
		assertThat(savedPersonne.getId()).isGreaterThan(1);
	}
	
	@Test
	public void testGetPersonne()
	{
		//Given
		
		//When (recupère en base)
		
		Personne toGetPersonne = personneRepository.getReferenceById(personne1.getId());
		
		//Then
		assertThat(toGetPersonne).isNotNull();
		assertThat(toGetPersonne.getId()).isEqualTo(personne1.getId());
		assertThat(toGetPersonne.getNom()).isEqualTo("Flantier");
		assertThat(toGetPersonne.getPrenom()).isEqualTo("Noel");
		assertThat(toGetPersonne.getEmail()).isEqualTo("sagiraitdegrandir@pasteque.fr");		
	}
	
	@Test
	@Transactional(value = TxType.NEVER)
	public void TestDeletePersonne()
	{
		try {
		// Given		
		
		int id = personne1.getId();
		System.out.println("personne : " + personne1);
		
		Personne s1 = personneRepository.getReferenceById(id);
		assertThat(s1).isNotNull();
		
		// When		
		personneRepository.delete(s1);
		personne1 = personneRepository.getReferenceById(id);
		System.out.println("personne : " + personne1);
		
		// Then
		assertThat(personne1).isNull();
		}
		catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}
	@Test
	public void testUpdatePersonne()
	{
		//Given
		Personne s1 = personneRepository.save(personne2);
		//When
		s1.setNom("Ronaldo");
		s1.setPrenom("Cristiano");
		Personne s2 = personneRepository.save(s1);
	
		//Then
		assertThat(s2).isNotNull();
		assertThat(s2.getNom()).isEqualTo("Ronaldo");

	}
	
	@Test
	public void testGetAllPersonne() 
	{
		//Given 
		//MIEUX VAUT FAIRE DES GETS CAR SINON CA NOUS AJOUTE DES ENTITES QUI NE VONT PAS DANS LA BASE ET CELA FAIT GENERER DES ID PHANTOMES
//			Personne s1 = personneRepository.save(new Personne("Jean", "Claude", "jc@gmail.com"));
//			Personne s2 = personneRepository.save(new Personne("Louis", "Claude", "lc@gmail.com"));
		Personne p1= personneRepository.getReferenceById(1);
		//When
		List<Personne> listePersonnes = personneRepository.findAll();
	
		//Then
		assertThat(listePersonnes).isNotEmpty();
		//assertThat(listePersonnes).hasSize(6);
		assertThat(listePersonnes.get(0).getClass()).hasSameClassAs(Personne.class);
		//permet de vérifier le type des attribut en vérifiant si les objets sont de la MEME CLASSE
		assertThat(listePersonnes.get(0).toString()).hasToString(p1.toString()); 
		// fais un toString sur notre Objet et le compare au toString de son emplacement dans al liste, permet de comparé le contenu de celui-ci
	}
	
	//PAS ENCORE LA NECESSITE DE CETTE FONCTION
	
//	@Test
//	public void testFindByNom()
//	{
//		//Given
//		Personne s1= personneRepository.getReferenceById(7);
//		//When
//		Personne personneParNom = personneRepository.findByNom("Zidane");
//		
//		//Then
//		assertThat(personneParNom).isNotNull();
//		
//	}
}
