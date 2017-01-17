package com.ensa.gestionProjet.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Etudiant")
public class Etudiant extends Utilisateur {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	private String filiere;
	private String niveau;
	
	@ManyToOne
	@JoinColumn(name="ID_PROF")
	private Professeur professeur;

	@ManyToMany(mappedBy="etudiants", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Projet> projets;
	

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

}