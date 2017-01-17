package com.ensa.gestionProjet.professeur.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.gestionProjet.entities.Livrable;
import com.ensa.gestionProjet.entities.Projet;
import com.ensa.gestionProjet.entities.Utilisateur;
import com.ensa.gestionProjet.services.ProfesseurService;


@CrossOrigin("*")
@RestController
public class GestionProjetController {
	
	
	@Autowired
	private ProfesseurService professeurService;
	
	
	@RequestMapping(value="/projets/{idProjet}/{idUser}", method = RequestMethod.GET)
	public boolean affectProjetToUser(@PathVariable int idProjet,@PathVariable Long idUser){
		return professeurService.affectProjetToUser(idProjet, idUser);
	}
	
	
	@RequestMapping(value="/projets/add", method = RequestMethod.GET)
	public boolean addProjet(String nomProjet, Long idEtudiant, String typeProjet,
			@DateTimeFormat(pattern="dd-MM-yyyy") Date dateDebut,@DateTimeFormat(pattern="dd-MM-yyyy")Date dateFin){
		Projet projet = new Projet();
		projet.setNomProjet(nomProjet);
		projet.setTypeProjet(typeProjet);
		projet.setDateDebutProjet(dateDebut);
		projet.setDateFinProjet(dateFin);
		return professeurService.addProjet(projet,idEtudiant);
	}
	
	@RequestMapping(value="/projets/update", method = RequestMethod.POST)
	public Projet updateProjet(@RequestBody Projet projet){
		return professeurService.updateProjet(projet);
	}
	
	@RequestMapping(value="/projets/remove/{id}", method = RequestMethod.GET)
	public boolean removeProjet(@PathVariable int id){
		return professeurService.removeProjet(id);
	}
	
	@RequestMapping(value="/projets", method = RequestMethod.GET)
	public List<Projet> getAllProjet(){
		return professeurService.getAllProjet();
	}
	
	
	@RequestMapping(value="/projets/livarbles/{idProjet}", method = RequestMethod.POST)
	public boolean addLivrablesToProjet(@PathVariable int idProjet,@RequestBody List<Livrable> livrables){
		return professeurService.diviserLivarbles(idProjet, livrables);
	}
	

}
