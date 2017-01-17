package com.ensa.gestionProjet.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionProjet.entities.Livrable;
import com.ensa.gestionProjet.entities.Projet;
import com.ensa.gestionProjet.entities.Rendezvous;
import com.ensa.gestionProjet.entities.Utilisateur;
import com.ensa.gestionProjet.repositories.DocumentRespository;
import com.ensa.gestionProjet.repositories.LivrableRespository;
import com.ensa.gestionProjet.repositories.ProjetRespository;
import com.ensa.gestionProjet.repositories.RendezVousRespository;
import com.ensa.gestionProjet.repositories.UtilisateurRespository;
import com.ensa.gestionProjet.services.EtudiantService;

@Service
public class EtudiantServiceImpl implements EtudiantService{

	@Autowired
	UtilisateurRespository userRepo;
	@Autowired
	RendezVousRespository rendezVousRepo;
	@Autowired
	LivrableRespository livrableRepo;
	@Autowired
	DocumentRespository docRepo;
	@Autowired
	ProjetRespository projetRepo;
	
	
	@Override
	public Utilisateur updateUser(Utilisateur user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
		return user;
	}

	@Override
	public Utilisateur getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepo.getOne(id);
	}

	@Override
	public List<Rendezvous> getAllMyRendezVous(int idUser) {
		// TODO Auto-generated method stub
		 return null;
		//return rendezVousRepo.getAllRendezVousByUser(idUser);
	}

	@Override
	public List<Projet> getAllMyprojet(int idUser) {
		// TODO Auto-generated method stub
		return projetRepo.getAllMyProject(idUser);
	}

	@Override
	public List<Livrable> getLivrableByProject(int idProjet) {
		// TODO Auto-generated method stub
		return projetRepo.findOne(idProjet).getLivrables();
	}

	@Override
	public boolean uploadLivrable(Livrable livrable) {
		if(livrableRepo.save(livrable) != null )
			return true;
		else 
			return false;
		
	}

	@Override
	public Utilisateur getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

}
