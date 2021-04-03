package com.RessourseHumaine.Services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.RessourseHumaine.Entity.Action;
import com.RessourseHumaine.Entity.Utilisateur;
import com.RessourseHumaine.Repository.ActionRepository;
import com.RessourseHumaine.Repository.UtilisateurRepository;

@Service
public class ActionService {

	final private ActionRepository actionRepository;
	final private UtilisateurRepository utilisateurRepository;
	
	public ActionService(ActionRepository actionRepository,UtilisateurRepository utilisateurRepository) {
		super();
		this.actionRepository = actionRepository;
		this.utilisateurRepository = utilisateurRepository;

	}
	
	@Transactional
	public Action addAction(Action action) {		
		return actionRepository.save(action);	
	}
	
	public List<Action> getAllaction() {
		return (List<Action>) actionRepository.findAll();
	}
	
	@Transactional
	public void deleteActionById(long actionId) {
		Action action = actionRepository.findById(actionId).get();
		actionRepository.delete(action);
		
	}
	
	public Action getActionById(long actionId) {
		return actionRepository.findById(actionId).get();
	}
	
	@Transactional
	public void updateAction(Date dateDebut, Date dateFin,String typeAction,String statutAction,String subjectif, long actionId) {
		actionRepository.updateActionJPQL(dateDebut, dateFin, typeAction, statutAction, subjectif, actionId);
	}
	
	@Transactional
	public void affecterActionAUtilisateur(long actionId, long UserId) {
		Utilisateur utilisateurManagedEntity = utilisateurRepository.findById(UserId).get();
		Action actionManagedEntity = actionRepository.findById(actionId).get();
		
		actionManagedEntity.setUtilisateur(utilisateurManagedEntity);
		actionRepository.save(actionManagedEntity);
		
	}
	
	
	
	
	
}
