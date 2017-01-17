package com.ensa.gestionProjet.professeur.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.gestionProjet.entities.Etudiant;
import com.ensa.gestionProjet.entities.Professeur;
import com.ensa.gestionProjet.entities.Utilisateur;
import com.ensa.gestionProjet.services.ProfesseurService;

@CrossOrigin("*")
@RestController
public class GestionUtilisateurController {
	
	@Autowired
	private ProfesseurService professeurService;
	
	
	@RequestMapping(value="/test")
	public List<Utilisateur> test(){
		
		Professeur prof = new Professeur();
		prof.setEmail("prof@prof.com");
		prof.setMotDePasse("123456");
		prof.setNom("prof");
		prof.setPrenom("prof");
		prof.setTel("0987654321");
		prof.setDateNaissance(new Date());
		
		
		professeurService.addUser(prof);
		
		List<Utilisateur> u = new ArrayList<Utilisateur>();
		u.add(prof);
		return u;
	}
	
	@RequestMapping(value="/utilisateurs/add",method = RequestMethod.GET)
	public Utilisateur addUser(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom
			,@RequestParam("email") String email, @RequestParam("tel") String tel
			,@RequestParam("filiere") String filiere ,@RequestParam("password") String password
			,@DateTimeFormat(pattern="dd-MM-yyyy") Date dateNaissance){
		Etudiant etudiant = new Etudiant();
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setEmail(email);
		etudiant.setMotDePasse(password);
		etudiant.setTel(tel);
		etudiant.setDateNaissance(dateNaissance);
		return professeurService.updateUser(etudiant);
	}
	
	
	@RequestMapping(value="/utilisateurs/remove/{id}", method = RequestMethod.GET)
	public boolean removeUser(@PathVariable Long id){
		return professeurService.removeUser(id);
	}
	
	
	@RequestMapping(value="/utilisateurs/update",method = RequestMethod.POST)
	public Utilisateur updateUser(@RequestBody Utilisateur user){
		return professeurService.updateUser(user);
	}
	
	
	@RequestMapping(value="/utilisateurs/nom/{nom}", method = RequestMethod.GET)
	public List<Utilisateur> searchUsersByNom(@PathVariable String nom){
		return professeurService.search(nom);
	}
	
	
	@RequestMapping(value="/utilisateurs/id/{id}", method = RequestMethod.GET)
	public Utilisateur searchUserById(@PathVariable Long id){
		return professeurService.getUser(id);
	}
	
	
	
	@RequestMapping(value="/utilisateurs", method = RequestMethod.GET)
	public @ResponseBody  List<Utilisateur> getAllUser(){
		return professeurService.getAllUser();
	}
	

}
