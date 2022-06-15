package com.inti.ProjetFinalPiscineSpring.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Data
@Table
@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor
public class Materiel
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idMateriel;
private @NonNull String nomMateriel;
private int qtMateriel;

@JsonIgnore
@ManyToOne 
@JoinColumn(name="idActivite")
private Activite activite;
}
