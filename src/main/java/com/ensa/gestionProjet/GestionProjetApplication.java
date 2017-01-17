package com.ensa.gestionProjet;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import com.ensa.gestionProjet.entities.Professeur;



@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class GestionProjetApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(GestionProjetApplication.class, args);
	
	}
}
