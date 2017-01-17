package com.ensa.gestionProjet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Rendezvous implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	private Date dateRendezVous;
	private String description;

	@ManyToOne
	@JoinColumn(name="ID_PROF")
	private Professeur professeur;
	
	@ManyToOne
	@JoinColumn(name="ID_ETUDIANT")
	private Utilisateur etudiant;
	
	
	public Utilisateur getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Utilisateur etudiant) {
		this.etudiant = etudiant;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateRendezVous() {
		return dateRendezVous;
	}

	public void setDateRendezVous(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}