package com.RessourseHumaine.Services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.RessourseHumaine.Entity.Utilisateur;
import com.RessourseHumaine.Repository.UtilisateurRepository;

@Service
public class UtlisateurService {
	
	final private UtilisateurRepository utilisateurRepository;
	
	
	
	
	
	public UtlisateurService(UtilisateurRepository utilisateurRepository) {
		super();
		this.utilisateurRepository = utilisateurRepository;
	}





	@Transactional
	public Utilisateur addUser(Utilisateur user) {		
		return utilisateurRepository.save(user);	
	}


}
