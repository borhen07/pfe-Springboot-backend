package com.RessourseHumaine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RessourseHumaine.Entity.Session;
import com.RessourseHumaine.Entity.Utilisateur;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{
	
	Session findByToken(String token);
	Session findByUtilisateur(Utilisateur utilisateur);


}
