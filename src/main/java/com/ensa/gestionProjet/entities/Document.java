package com.ensa.gestionProjet.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Document implements Serializable{
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	private String nomDoc;
	private String desciption;
	@Temporal(TemporalType.DATE)
	private Date dateDeposition;
	private String typeDoc;
	
	@ManyToOne
	@JoinColumn(name="ID_DOC")
	private Livrable livrable;
	
	

	public Livrable getLivrable() {
		return livrable;
	}

	public void setLivrable(Livrable livrable) {
		this.livrable = livrable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomDoc() {
		return nomDoc;
	}

	public void setNomDoc(String nomDoc) {
		this.nomDoc = nomDoc;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Date getDateDeposition() {
		return dateDeposition;
	}

	public void setDateDeposition(Date dateDeposition) {
		this.dateDeposition = dateDeposition;
	}

	public String getTypeDoc() {
		return typeDoc;
	}

	public void setTypeDoc(String typeDoc) {
		this.typeDoc = typeDoc;
	}

}