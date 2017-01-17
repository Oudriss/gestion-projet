package com.ensa.gestionProjet.services;

import org.springframework.stereotype.Service;

@Service
public interface SharedServices {

	public boolean login(String email,String password);
}
