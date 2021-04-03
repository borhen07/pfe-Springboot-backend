package com.RessourseHumaine.Services;

import java.sql.Timestamp;
import java.util.Calendar;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RessourseHumaine.Entity.Session;
import com.RessourseHumaine.Entity.Utilisateur;
import com.RessourseHumaine.Repository.SessionRepository;

@Service
public class SessionService {
	
	private final SessionRepository sessionRepository;

	@Autowired
	public SessionService(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}
	
	@Transactional
	public Session findByToken(String token) {
		return sessionRepository.findByToken(token);
	}
	
	@Transactional
	public Session findByUser(Utilisateur utilisateur) {
		return sessionRepository.findByUtilisateur(utilisateur);
	}
	
	@Transactional
	public void save(Utilisateur utilisateur, String token) {
		Session session = new Session(token, utilisateur);
		//set expiry date to 24 hours
		session.setLastConnection(calculateExpiryDate(24*60));
		sessionRepository.save(session);
	}
	
	// Calculate expiry date 
	private Timestamp calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Timestamp(cal.getTime().getTime());
	}



}
