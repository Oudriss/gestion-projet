package com.ensa.gestionProjet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Livrable implements Serializable {
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dateLivrable;
	
	@OneToMany(mappedBy="livrable")
	private List<Document> documents;
	
	
	@ManyToOne
	private Projet projet;

	
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateLivrable() {
		return dateLivrable;
	}

	public void setDateLivrable(Date dateLivrable) {
		this.dateLivrable = dateLivrable;
	}

}