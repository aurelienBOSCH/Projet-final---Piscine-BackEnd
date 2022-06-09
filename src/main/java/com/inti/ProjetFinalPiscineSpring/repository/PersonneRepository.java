package com.inti.ProjetFinalPiscineSpring.repository;

import java.util.List;

import com.inti.ProjetFinalPiscineSpring.model.Activite;
import com.inti.ProjetFinalPiscineSpring.model.Personne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonneRepository extends JpaRepository<Personne, Integer>
{
	@Query(value="Select p.* from activite a, personne p, personne_activite pa where a.id_activite = pa.id_activite and p.id=pa.id_personne and p.role='client' and a.id_activite=:id_activite", nativeQuery = true)
	List<Personne> GetListClientsPerActivity(@Param("id_activite") int idActivite);
}
