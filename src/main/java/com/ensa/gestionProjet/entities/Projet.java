package com.ensa.gestionProjet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projet implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	private String nomProjet;
	private String typeProjet;
	@Temporal(TemporalType.DATE)
	private Date dateDebutProjet;
	@Temporal(TemporalType.DATE)
	private Date dateFinProjet;
	
	@ManyToOne
	@JoinColumn(name="ID_PROF")
	private Professeur professeur;
	
	@ManyToMany
	@JoinTable(name="ETUDIANT_PROJET")
	private List<Utilisateur> etudiants;
	
	@OneToMany(mappedBy="projet")
	@JsonIgnore
	private List<Livrable> livrables;
	
	 
	
	public List<Utilisateur> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Utilisateur> etudiants) {
		this.etudiants = etudiants;
	}

	public List<Livrable> getLivrables() {
		return livrables;
	}

	public void setLivrables(List<Livrable> livrables) {
		this.livrables = livrables;
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

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getTypeProjet() {
		return typeProjet;
	}

	public void setTypeProjet(String typeProjet) {
		this.typeProjet = typeProjet;
	}

	public Date getDateDebutProjet() {
		return dateDebutProjet;
	}

	public void setDateDebutProjet(Date dateDebutProjet) {
		this.dateDebutProjet = dateDebutProjet;
	}

	public Date getDateFinProjet() {
		return dateFinProjet;
	}

	public void setDateFinProjet(Date dateFinProjet) {
		this.dateFinProjet = dateFinProjet;
	}

}