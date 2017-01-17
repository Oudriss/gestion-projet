package com.ensa.gestionProjet.etudiant.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ensa.gestionProjet.entities.Livrable;
import com.ensa.gestionProjet.entities.Rendezvous;
import com.ensa.gestionProjet.entities.Utilisateur;
import com.ensa.gestionProjet.services.EtudiantService;

@RestController
public class EtudiantController {
	
	
	@Autowired
	private EtudiantService etudiantService;
	
	
	
//	@RequestMapping(value="/test")
//	public @ResponseBody String test(){
//		
//
//		return "ok";
//	}
//	
	
	@RequestMapping(value="/user/{id}/profile", method = RequestMethod.GET)
	public @ResponseBody Utilisateur getMyProfile(@PathVariable Long id){
		return etudiantService.getUser(id);
	}
	
	
	
	@RequestMapping(value="/user/{id}/update", method = RequestMethod.PUT)
	public Utilisateur updateProfile(@PathVariable Long id){
		Utilisateur user=etudiantService.getUser(id);
		return etudiantService.updateUser(user);
	}
	
	
	/*@RequestMapping(value="/user/{id}/projets", method = RequestMethod.GET)
	public List<Projet> getMyProjects(@PathVariable int id){
		return etudiantService.getAllMyprojet(id);
	}
	*/
	
	@RequestMapping(value="/user/{id}/projets", method = RequestMethod.GET)
	public List<Rendezvous> getMyRDVs(@PathVariable int id){
		return etudiantService.getAllMyRendezVous(id);
	}
	
	@RequestMapping(value="/user/livrables", method = RequestMethod.PUT)
	public String uploadLivrable(Livrable livrable,MultipartFile file){
		etudiantService.uploadLivrable(livrable);
		return "uploaded!!";
	}
	
	
	
	
	
	
	

}
