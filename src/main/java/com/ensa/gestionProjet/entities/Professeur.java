package com.ensa.gestionProjet.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("PROF")
public class Professeur extends Utilisateur {
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="professeur")
	@JsonIgnore
	List<Projet> projets;
	@OneToMany(mappedBy="professeur")
	@JsonIgnore
	List<Rendezvous> rendezVous;
	
	@OneToMany(mappedBy="professeur")
	@JsonIgnore
	private List<Etudiant> etudiant;
	
	
	public List<Etudiant> getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(List<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}
	public List<Projet> getProjets() {
		return projets;
	}
	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	public List<Rendezvous> getRendezVous() {
		return rendezVous;
	}
	public void setRendezVous(List<Rendezvous> rendezVous) {
		this.rendezVous = rendezVous;
	}
	
	

}