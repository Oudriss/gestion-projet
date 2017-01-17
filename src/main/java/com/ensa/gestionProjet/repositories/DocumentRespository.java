/**
 * 
 */
package com.ensa.gestionProjet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.gestionProjet.entities.Document;

/**
 * @author hamza
 *
 */
public interface DocumentRespository extends JpaRepository<Document, Integer>{
 
}
