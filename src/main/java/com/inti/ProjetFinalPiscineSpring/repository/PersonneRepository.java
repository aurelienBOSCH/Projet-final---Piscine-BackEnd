package com.inti.ProjetFinalPiscineSpring.repository;

import com.inti.ProjetFinalPiscineSpring.model.Personne;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Integer>
{

}
