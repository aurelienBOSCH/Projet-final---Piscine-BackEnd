package com.inti.ProjetFinalPiscineSpring.model;

import javax.persistence.*;
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

@ManyToOne 
@JoinColumn(name="idActivite")
private Activite activite;
}
