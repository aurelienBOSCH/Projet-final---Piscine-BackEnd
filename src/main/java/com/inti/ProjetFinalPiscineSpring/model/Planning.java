package com.inti.ProjetFinalPiscineSpring.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;


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

@OneToMany(mappedBy="planning", targetEntity = Activite.class, cascade = CascadeType.ALL)
private List<Activite> activite;
}
