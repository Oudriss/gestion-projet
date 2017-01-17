package com.ensa.gestionProjet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ensa.gestionProjet.entities.Livrable;
import com.ensa.gestionProjet.entities.Projet;
import com.ensa.gestionProjet.entities.Rendezvous;
import com.ensa.gestionProjet.entities.Utilisateur;

@Service
public interface EtudiantService {

	public Utilisateur updateUser(Utilisateur user);
	public Utilisateur getUser(Long id);
	//modification
	public Utilisateur getUserByEmail(String email);

	public List<Rendezvous> getAllMyRendezVous(int idUser);
	public List<Projet> getAllMyprojet(int idUser);
	public List<Livrable> getLivrableByProject(int idProjet);
	public boolean uploadLivrable(Livrable livrable);
}
