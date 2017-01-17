package com.ensa.gestionProjet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ensa.gestionProjet.entities.Rendezvous;

public interface RendezVousRespository extends JpaRepository<Rendezvous, Integer>{

	
	@Query(value="select r from Rendezvous r where r.etudiant.id=?1")
	public List<Rendezvous> getAllRendezVousByUser(int id);
	
}
