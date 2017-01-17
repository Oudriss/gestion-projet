package com.ensa.gestionProjet.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ensa.gestionProjet.entities.Livrable;
import com.ensa.gestionProjet.entities.Projet;
import com.ensa.gestionProjet.entities.Rendezvous;
import com.ensa.gestionProjet.entities.Utilisateur;
@Service
public interface ProfesseurService {

	public boolean addUser(Utilisateur user);
	public boolean removeUser(Long id);
	public Utilisateur updateUser(Utilisateur user);
	public Utilisateur getUser(Long id);
	public List<Utilisateur> getAllUser();
	public List<Utilisateur> search(String nom);
	
	public boolean addProjet(Projet projet, Long idEtudiant);
	public boolean removeProjet(int id);
	public Projet updateProjet(Projet projet);
	public Projet getProjet(int id);
	public List<Projet> getAllProjet();
	public boolean affectProjetToUser(int idProjet,Long idUser);
	
	public boolean diviserLivarbles(int idProjet,List<Livrable> livrables);
	public boolean preciseRendezVous(Long idUser,Date dateRendezVous, String description);
	public List<Rendezvous> getAllRdvs();
	public void removeRdv(int id);





	
}
