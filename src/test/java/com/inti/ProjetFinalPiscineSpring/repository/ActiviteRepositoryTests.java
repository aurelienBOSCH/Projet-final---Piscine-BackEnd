package com.inti.ProjetFinalPiscineSpring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.inti.ProjetFinalPiscineSpring.model.Activite;
import com.inti.ProjetFinalPiscineSpring.model.Materiel;
import com.inti.ProjetFinalPiscineSpring.model.Personne;
import com.inti.ProjetFinalPiscineSpring.model.Planning;
import com.inti.ProjetFinalPiscineSpring.repository.ActiviteRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ActiviteRepositoryTests
{
	@Autowired
	ActiviteRepository ar;
	Activite a1, a2;
	List<Materiel> listeMateriels = new ArrayList<Materiel>();
	List<Personne> listePersonnes = new ArrayList<Personne>();
	Planning planning = new Planning();
	
	@BeforeEach
	public void setUp()
	{
		
		
		a1 = new Activite();
		a2 = new Activite(48516, "Aquabike", 20, LocalDateTime.of(2022, 06, 9, 9, 30), LocalDateTime.of(2022, 06, 9, 11, 30), 0.00f ,listePersonnes, listeMateriels, planning);
	}

	@Test
	public void testGetActiviteTrue()
	{
		Activite toGetActiviteFalse = ar.getReferenceById(48516);
		assertThat(toGetActiviteFalse).isNotNull();
		assertThat(toGetActiviteFalse.getIdActivite()).isEqualTo(48516);
	}

	@Test
	public void testGetActiviteFalse()
	{
		Activite toGetActiviteFalse = ar.getReferenceById(12);
		assertThat(toGetActiviteFalse).isNotNull();
		assertThat(toGetActiviteFalse.getIdActivite()).isNotEqualTo(48516);
	}
	
	@Test
	public void testGetA2Full()
	{
		Activite testGetA2Full = a2;
		assertThat(testGetA2Full.getIdActivite()).isNotNull();
		assertThat(testGetA2Full.getNomActivite()).isNotNull();
		assertThat(testGetA2Full.getNbrPlaces()).isNotNull();
		assertThat(testGetA2Full.getHoraireDebut()).isNotNull();
		assertThat(testGetA2Full.getHoraireFin()).isNotNull();
		assertThat(testGetA2Full.getListePersonnes()).isNotNull();
		assertThat(testGetA2Full.getListeMateriels()).isNotNull();
		assertThat(testGetA2Full.getPlanning()).isNotNull();
	}
	
	@Test
	public void testGetA1Empty()
	{
		Activite testGetA1Empty = a1;
		assertThat(testGetA1Empty.getIdActivite()).isEqualTo(0);
		assertThat(testGetA1Empty.getNomActivite()).isEqualTo(null);
		assertThat(testGetA1Empty.getNbrPlaces()).isEqualTo(0);
		assertThat(testGetA1Empty.getListePersonnes()).isEqualTo(null);
		assertThat(testGetA1Empty.getListeMateriels()).isEqualTo(null);
		assertThat(testGetA1Empty.getPlanning()).isEqualTo(null);
	}
}
