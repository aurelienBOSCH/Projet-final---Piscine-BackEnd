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
	
	@Query(value="update activite a, planning p set a.id_planning=:id_planning where a.id_activite=:id_activite and a.horaire_debut >= p.horaire_debut_journee and a.horaire_fin <= p.horaire_fin_journee"
		, nativeQuery = true)
	void SetPlanningToActivity(@Param("id_activite") int idActivite, @Param("id_planning") int idPlanning);

	@Query(value="Select * from activite where id_planning is not null and nom_activite=:nom_activite and horaire_debut > NOW() order by horaire_debut", nativeQuery = true)
	List<Activite> findAllActivitiesSameName(@Param("nom_activite") String nomActivite);
	
	@Query(value="Select distinct nom_activite from activite ", nativeQuery = true)
	List<String> findListeEachActivityType();
	
	
}
