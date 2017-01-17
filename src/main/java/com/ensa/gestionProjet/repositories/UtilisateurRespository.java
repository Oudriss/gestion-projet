package com.ensa.gestionProjet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.gestionProjet.entities.Utilisateur;

public interface UtilisateurRespository extends JpaRepository<Utilisateur, Long>{

	public List<Utilisateur> findByNom(String nom);
	public Utilisateur findByEmail(String email);
	
	
}
