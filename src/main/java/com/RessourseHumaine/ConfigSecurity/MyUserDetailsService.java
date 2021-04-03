package com.RessourseHumaine.ConfigSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RessourseHumaine.Entity.Utilisateur;
import com.RessourseHumaine.Repository.UtilisateurRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UtilisateurRepository utilisateurRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	Utilisateur utilisateur = utilisateurRepository.findByEmail(username);
 
        return utilisateur;
    }


}
