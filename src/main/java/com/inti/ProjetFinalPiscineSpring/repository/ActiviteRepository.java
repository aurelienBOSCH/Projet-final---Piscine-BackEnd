package com.inti.ProjetFinalPiscineSpring.repository;

import java.util.List;

import com.inti.ProjetFinalPiscineSpring.model.Activite;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActiviteRepository extends JpaRepository<Activite, Integer>
{
	@Query(value="Select a.* from activite a, personne p, personne_activite pa where a.id_activite = pa.id_activite and p.id=pa.id_personne and p.role='client' and p.id=:id", nativeQuery = true)
	List<Activite> GetListActivitiesPerClient(@Param("id") int id);
	
	@Query(value="Select a.* from activite a, personne p, personne_activite pa where a.id_activite = pa.id_activite and p.id=pa.id_personne and p.role='prof'and p.id=:id", nativeQuery = true)
	List<Activite> GetListActivitiesPerProf(@Param("id") int id);
	
}
