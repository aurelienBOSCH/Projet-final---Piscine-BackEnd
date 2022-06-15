package com.inti.ProjetFinalPiscineSpring.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
@Table
@AllArgsConstructor @NoArgsConstructor
public class Activite
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idActivite;
private String nomActivite;
private int nbrPlaces;
private LocalDateTime horaireDebut;
private LocalDateTime horaireFin;
private float prix;

@JsonIgnore
@ManyToMany
@JoinTable(name= "Personne_Activite",
			joinColumns = @JoinColumn(name="idActivite"),
			inverseJoinColumns = @JoinColumn(name="idPersonne"))
private List<Personne> listePersonnes;


@OneToMany(mappedBy="activite", targetEntity = Materiel.class, cascade = CascadeType.ALL)
private List<Materiel> listeMateriels;

@ManyToOne
@JoinColumn(name = "idPlanning")
private Planning planning;

@Override
public String toString()
{
	return "Activite [idActivite=" + idActivite + ", nomActivite=" + nomActivite + ", nbrPlaces=" + nbrPlaces
			+ ", horaireDebut=" + horaireDebut + ", horaireFin=" + horaireFin + ", prix=" + prix + ", listeMateriels="
			+ listeMateriels + ", planning=" + planning + "]";
}

//on retire la liste de personnes pour ne pas avoir un JSON infini
}
