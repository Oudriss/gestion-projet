package com.ensa.gestionProjet.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.gestionProjet.entities.Etudiant;
import com.ensa.gestionProjet.entities.Livrable;
import com.ensa.gestionProjet.entities.Professeur;
import com.ensa.gestionProjet.entities.Projet;
import com.ensa.gestionProjet.entities.Rendezvous;
import com.ensa.gestionProjet.entities.Utilisateur;
import com.ensa.gestionProjet.repositories.ProjetRespository;
import com.ensa.gestionProjet.repositories.RendezVousRespository;
import com.ensa.gestionProjet.repositories.UtilisateurRespository;
import com.ensa.gestionProjet.services.ProfesseurService;


@Service
public class ProfesseurServiceImpl implements ProfesseurService {

	
	@Autowired
	private UtilisateurRespository utilisateurRepository;
	@Autowired
	private ProjetRespository projetRepository;
	@Autowired
	private RendezVousRespository rendezvousRepository;
	
	@Override
	public boolean addUser(Utilisateur user) {
		if(utilisateurRepository.save(user) == null )
			return false;
		else 
			return true;
	}

	@Override
	public boolean removeUser(Long id) {
		utilisateurRepository.delete(id);
		return true;
	}

	@Override
	public Utilisateur updateUser(Utilisateur user) {
		return utilisateurRepository.save(user);
	}

	@Override
	public Utilisateur getUser(Long id) {
		return utilisateurRepository.findOne(id);
	}

	@Override
	public List<Utilisateur> getAllUser() {
		return utilisateurRepository.findAll();
	}

	@Override
	public List<Utilisateur> search(String nom) {
		return utilisateurRepository.findByNom(nom);
	}

	@Override
	public boolean addProjet(Projet projet, Long idEtudiant) {
		List<Utilisateur> etudiants = new ArrayList<Utilisateur>();
		etudiants.add(utilisateurRepository.findOne(idEtudiant));
		projet.setEtudiants(etudiants);
		if( projetRepository.save(projet) != null )
			return true;
		else
			return false;
	}

	@Override
	public boolean removeProjet(int id) {
		projetRepository.delete(id);
		return true;
	}

	@Override
	public Projet updateProjet(Projet projet) {
		return projetRepository.save(projet);
	}

	@Override
	public Projet getProjet(int id) {
		return projetRepository.findOne(id);
	}

	@Override
	public List<Projet> getAllProjet() {
		return projetRepository.findAll();
	}

	@Override
	public boolean affectProjetToUser(int idProjet, Long idUser) {
		Projet projet = projetRepository.findOne(idProjet);
		Utilisateur user = utilisateurRepository.findOne(idUser);
		projet.getEtudiants().add((Etudiant) user);
		if(projetRepository.save(projet) != null )
			return true;
		else 
			return false;
	}

	@Override
	public boolean diviserLivarbles(int idProjet, List<Livrable> livrables) {
		Projet projet = projetRepository.findOne(idProjet);
		projet.setLivrables(livrables);
		projetRepository.save(projet);
		if(projetRepository.save(projet) != null )
			return true;
		else 
			return false;
	}

	@Override
	public boolean preciseRendezVous(Long idUser, Date dateRendezVous, String description) {
		Utilisateur etudiant = utilisateurRepository.findOne(idUser);
		Rendezvous rdv = new Rendezvous();
		rdv.setDateRendezVous(dateRendezVous);
		rdv.setDescription(description);
		rdv.setEtudiant(etudiant);
		if(rendezvousRepository.save(rdv) != null )
			return true;
		else
			return false;
	}

	@Override
	public List<Rendezvous> getAllRdvs() {
		return rendezvousRepository.findAll();
	}

	@Override
	public void removeRdv(int id) {
		rendezvousRepository.delete(id);
	}
	
	

}
