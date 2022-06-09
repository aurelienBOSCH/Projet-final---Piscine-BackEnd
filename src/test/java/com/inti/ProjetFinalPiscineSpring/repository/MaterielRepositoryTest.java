package com.inti.ProjetFinalPiscineSpring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.inti.ProjetFinalPiscineSpring.model.Activite;
import com.inti.ProjetFinalPiscineSpring.model.Materiel;

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
public class MaterielRepositoryTest
{
	@Autowired
	MaterielRepository mr;
	Materiel m1, m2;
	Activite activite = new Activite();	
	
	@BeforeEach
	public void setUp() 
	{
		m1 = new Materiel();
		m2 = new Materiel( 1425, "Velo", 15, activite);
	}
	
	@Test
	public void testGetMaterielTrue()
	{
		Materiel toGetMaterielTrue = mr.getReferenceById(48516);
		assertThat(toGetMaterielTrue).isNotNull();
		assertThat(toGetMaterielTrue.getIdMateriel()).isEqualTo(48516);
	}
	
	@Test
	public void testGetMaterielFalse()
	{
		Materiel toGetMaterielTrue = mr.getReferenceById(12);
		assertThat(toGetMaterielTrue).isNotNull();
		assertThat(toGetMaterielTrue.getIdMateriel()).isNotEqualTo(48516);
	}
	
	@Test
	public void testGetM2Full()
	{
		Materiel testGetM2Full = m2;
		assertThat(testGetM2Full.getIdMateriel()).isNotNull();
		assertThat(testGetM2Full.getNomMateriel()).isNotNull();
		assertThat(testGetM2Full.getQtMateriel()).isNotNull();
		assertThat(testGetM2Full.getActivite()).isNotNull();
	}
	
	@Test
	public void testGetM1Empty()
	{
		Materiel testGetM1Empty = m1;
		assertThat(testGetM1Empty.getIdMateriel()).isEqualTo(0);
		assertThat(testGetM1Empty.getNomMateriel()).isEqualTo(null);
		assertThat(testGetM1Empty.getQtMateriel()).isEqualTo(0);
		assertThat(testGetM1Empty.getActivite()).isEqualTo(null);
	}
}
