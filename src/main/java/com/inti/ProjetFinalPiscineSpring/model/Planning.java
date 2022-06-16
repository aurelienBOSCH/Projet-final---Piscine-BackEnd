package com.inti.ProjetFinalPiscineSpring.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
@Table
@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Planning
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idPlanning;
private @NonNull LocalDateTime horaireDebutJournee;
private @NonNull LocalDateTime horaireFinJournee;

@JsonIgnore
@OneToMany(mappedBy="planning", targetEntity = Activite.class, cascade = CascadeType.ALL)
private List<Activite> listeActivites;


@Override
public String toString()
{
	return "Planning [idPlanning=" + idPlanning + ", horaireDebutJournee=" + horaireDebutJournee
			+ ", horaireFinJournee=" + horaireFinJournee + "]";
}

//on retire la liste d'activite du toString pour ne pas avoir un json infin, en plus du @JsonIgnore
}
