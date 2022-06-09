package com.inti.ProjetFinalPiscineSpring.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;



import lombok.*;

@Entity
@Data
@Table
@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Activite
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idActivite;
private String nomActivite;
private int nbrPlaces;
private @NonNull LocalDateTime horaireDebut;
private @NonNull LocalDateTime horaireFin;

@ManyToMany
@JoinTable(name= "Personne_Activite",
			joinColumns = @JoinColumn(name="idActivite"),
			inverseJoinColumns = @JoinColumn(name="idPersonne"))
private List<Personne> listePersonnes;

@OneToMany(mappedBy="activite", targetEntity = Materiel.class, cascade = CascadeType.ALL)
private List<Materiel> listeMateriel;

@ManyToOne
@JoinColumn(name = "idPlanning")
private Planning planning;
}
