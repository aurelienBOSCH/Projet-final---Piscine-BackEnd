package com.inti.ProjetFinalPiscineSpring.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table
@AllArgsConstructor @NoArgsConstructor //@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Personne
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(length = 50, nullable = false)
@NotBlank(message = "Veuillez saisir un Nom non vide !")
@Size(min = 3, max = 100, message = "Saisir au moins 3 caractères")
private String nom;

@NotBlank(message = "Veuillez saisir un Prenom non vide !")
@Size(min = 3, max = 100, message = "Saisir au moins 3 caractères")
@Column(length = 50, nullable = false)
private String prenom;

@Column(length = 100, nullable = false, unique = true)
@NotBlank(message = "Veuillez saisir un Nom d'Utilisateur non vide !")
@Size(min = 3, max = 100, message = "Saisir au moins 3 caractères")
//@UniqueElements(message = "Le nom d'utilisateur est déjà utilisé") POSE PROBLEME POUR LES TESTS
private String username;

@Column(length = 50, nullable = false)
private String password;

//@NotBlank(message = "Veuillez saisir une date valide !")
@Column(nullable = false)
private Date dateNaissance;

@NotBlank(message = "Veuillez saisir une Adresse valide !")
@Size(min = 20, max = 150, message = "Saisir au moins 3 caractères")
@Column(length = 50, nullable = false)
private String adresse;

@Column(length = 15, nullable = false)
//@Pattern(regexp = "^0[1-9]{1}[\\.[0-9]{2}\\.[0-9]{2}]{2}$", 
//message = "Saisir un téléphone au format xx.xx.xx.xx.xx")
private String telephone;

@NotBlank(message = "Veuillez saisir un Email valide !")
@Size(min = 20, max = 150, message = "Saisir au moins 3 caractères")
@Column(length = 50, nullable = false)
private String email;

private String role;
private String typeAbonnement;

@ManyToMany
@JoinTable(name= "Personne_Activite",
			joinColumns = @JoinColumn(name="idPersonne"),
			inverseJoinColumns = @JoinColumn(name="idActivite"))
private List<Activite> listeActivites;


public Personne(
		@NotBlank(message = "Veuillez saisir un Nom non vide !") @Size(min = 3, max = 100, message = "Saisir au moins 3 caractères") String nom,
		@NotBlank(message = "Veuillez saisir un Prenom non vide !") @Size(min = 3, max = 100, message = "Saisir au moins 3 caractères") String prenom,
		@NotBlank(message = "Veuillez saisir un Nom d'Utilisateur non vide !") @Size(min = 3, max = 100, message = "Saisir au moins 3 caractères") @UniqueElements(message = "Le nom d'utilisateur est déjà utilisé") String username,
		String password, @NotBlank(message = "Veuillez saisir une date valide !") Date dateNaissance,
		@NotBlank(message = "Veuillez saisir une Adresse valide !") @Size(min = 20, max = 150, message = "Saisir au moins 3 caractères") String adresse,
		@Pattern(regexp = "^0[1-9]{1}[\\.[0-9]{2}\\.[0-9]{2}]{2}$", message = "Saisir un téléphone au format xx.xx.xx.xx.xx") String telephone,
		@NotBlank(message = "Veuillez saisir un Email valide !") @Size(min = 20, max = 150, message = "Saisir au moins 3 caractères") String email,
		String role, String typeAbonnement)
{
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.username = username;
	this.password = password;
	this.dateNaissance = dateNaissance;
	this.adresse = adresse;
	this.telephone = telephone;
	this.email = email;
	this.role = role;
	this.typeAbonnement = typeAbonnement;
}



}
