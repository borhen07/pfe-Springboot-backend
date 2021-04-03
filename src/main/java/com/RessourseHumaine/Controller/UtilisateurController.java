package com.RessourseHumaine.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RessourseHumaine.Entity.Utilisateur;
import com.RessourseHumaine.Repository.UtilisateurRepository;
import com.RessourseHumaine.Services.UtlisateurService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/api/user"})
public class UtilisateurController {
	
	final private UtilisateurRepository utilisateurRepository;
	final private UtlisateurService utlisateurService;
	



	@Autowired
	public UtilisateurController(UtilisateurRepository utilisateurRepository, UtlisateurService utlisateurService) {
		super();
		this.utilisateurRepository = utilisateurRepository;
		this.utlisateurService = utlisateurService;
	}


	//Create User 
    @PostMapping("/addUser")
    public ResponseEntity<Utilisateur>addUser(@RequestBody Utilisateur user) {  	
    	utlisateurService.addUser(user);
        return ResponseEntity.noContent().build();
    }


}
