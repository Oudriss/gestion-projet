package com.ensa.gestionProjet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ensa.gestionProjet.entities.Projet;

public interface ProjetRespository extends JpaRepository<Projet, Integer>{

	@Query(value="select p from Projet p")
	public List<Projet> getAllMyProject(int id);
}
