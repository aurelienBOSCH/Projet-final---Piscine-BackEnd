package com.inti.ProjetFinalPiscineSpring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.inti.ProjetFinalPiscineSpring.model.Activite;
import com.inti.ProjetFinalPiscineSpring.model.Planning;

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
public class PlanningRepositoryTest
{
	@Autowired
	PlanningRepository pr;
	Planning p1, p2;
	List<Activite> listeActivites = new ArrayList<Activite>();
	
	@BeforeEach
	public void setUp()
	{
		p1 = new Planning();
		p2 = new Planning(1, LocalDateTime.of(2022, 06, 9, 9, 30), LocalDateTime.of(2022, 06, 9, 11, 30), listeActivites);
	}
	
	@Test
	public void testGetPlanningTrue()
	{
		Planning testGetPlanningTrue = pr.getReferenceById(2);
		assertThat(testGetPlanningTrue).isNotNull();
		assertThat(testGetPlanningTrue.getIdPlanning()).isEqualTo(2);
	}

	@Test
	public void testGetPlanningFalse()
	{
		Planning testGetPlanningFalse = pr.getReferenceById(12);
		assertThat(testGetPlanningFalse).isNotNull();
		assertThat(testGetPlanningFalse.getIdPlanning()).isNotEqualTo(48516);
	}
	
	@Test
	public void testGetP2Full()
	{
		Planning testGetP2Full = p2;
		assertThat(testGetP2Full.getIdPlanning()).isNotNull();
		assertThat(testGetP2Full.getHoraireDebutJournee()).isNotNull();
		assertThat(testGetP2Full.getHoraireFinJournee()).isNotNull();
		assertThat(testGetP2Full.getListeActivites()).isNotNull();
	}
	
	@Test
	public void testGetP1Empty()
	{
		Planning testGetP1Empty = p1;
		assertThat(testGetP1Empty.getIdPlanning()).isEqualTo(0);
		assertThat(testGetP1Empty.getListeActivites()).isEqualTo(null);
	}

}
