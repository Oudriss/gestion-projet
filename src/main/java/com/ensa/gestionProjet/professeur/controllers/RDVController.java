package com.ensa.gestionProjet.professeur.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.gestionProjet.entities.Rendezvous;
import com.ensa.gestionProjet.services.ProfesseurService;

@CrossOrigin("*")
@RestController
public class RDVController {
	
	@Autowired
	private ProfesseurService professeurService;
	
	
	@RequestMapping(value="/rdvs/add/{idUser}/content", method=RequestMethod.GET)
	public boolean preciseRendezVous(@PathVariable Long idUser,@RequestParam("description") String description,
			@DateTimeFormat(pattern="dd-MM-yyyy hh mm") Date dateRendezVous){
		return professeurService.preciseRendezVous(idUser, dateRendezVous, description);
	}
	
	
	@RequestMapping(value="/rdvs", method=RequestMethod.GET)
	public List<Rendezvous> getAllRdvs(){
		return professeurService.getAllRdvs();
	}
	
	@RequestMapping(value="/rdvs/remove/{id}", method= RequestMethod.GET)
	public void removeRdv(@PathVariable int id){
		professeurService.removeRdv(id);
	}



}
