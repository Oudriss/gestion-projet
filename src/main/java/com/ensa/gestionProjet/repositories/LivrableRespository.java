package com.ensa.gestionProjet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.gestionProjet.entities.Livrable;


public interface LivrableRespository extends JpaRepository<Livrable, Integer>{

}
