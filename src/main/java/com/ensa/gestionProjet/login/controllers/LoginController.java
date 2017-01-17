package com.ensa.gestionProjet.login.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensa.gestionProjet.entities.Utilisateur;
import com.ensa.gestionProjet.services.EtudiantService;

@CrossOrigin("*")
@RestController
public class LoginController {

	@Autowired
	EtudiantService etudiantService;
	
	private HttpSession session;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public Utilisateur login(@RequestParam("email")String email,@RequestParam("password")String password){
		Utilisateur user = etudiantService.getUserByEmail(email); 
		if( user != null && user.getEmail().equals(email) && user.getMotDePasse().equals(password)){
			//session=request.getSession();
			//session.setAttribute("user", user);
			System.out.println("**************************************************"+user.getMotDePasse());
			return user;
		}else{
			return null;
		}
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String deconnexion(HttpSession session){
		Utilisateur user=(Utilisateur) session.getAttribute("user");
		session.invalidate();
		return "dec"+user.getNom();
	}
}
