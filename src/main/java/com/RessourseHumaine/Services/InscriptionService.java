package com.RessourseHumaine.Services;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.RessourseHumaine.Entity.Compte;
import com.RessourseHumaine.Entity.Utilisateur;
import com.RessourseHumaine.Object.UserDTO;
import com.RessourseHumaine.Repository.CompteRepository;
import com.RessourseHumaine.Repository.UtilisateurRepository;

@Service
public class InscriptionService {
	
	private final UtilisateurRepository utilisateurRepository;
	private final ModelMapper modelMapper;
	private final BCryptPasswordEncoder passwordEncoder;
	private final SessionService sessionService;
	private EmailService emailService;
	private final CompteRepository compteRepository;
	

	
	public InscriptionService(UtilisateurRepository utilisateurRepository, ModelMapper modelMapper,
			BCryptPasswordEncoder passwordEncoder, SessionService sessionService, EmailService emailService,
			CompteRepository compteRepository) {
		super();
		this.utilisateurRepository = utilisateurRepository;
		this.modelMapper = modelMapper;
		this.passwordEncoder = passwordEncoder;
		this.sessionService = sessionService;
		this.emailService = emailService;
		this.compteRepository = compteRepository;
	}

	@Transactional
	public Optional<Utilisateur> findUserByEmail(String email){
		return utilisateurRepository.findUserByEmail(email);
	}
	
	public boolean userExists(String email) {
		return findUserByEmail(email).isPresent();
	}


	@Transactional
	public Utilisateur save(Utilisateur user) {
		return utilisateurRepository.save(user);
	}
	
	
	

	public Utilisateur register(UserDTO userDTO) {
		//password encryption
		String password = passwordEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(password);
		
		Utilisateur user = new Utilisateur();
		Compte compte = new Compte();		

	//	Role role = roleRepository.findByLibelle("Administrator");
		
		user.setCompte(compte);
	//	user.setRole(role);
		
		//disable new user before activation
		user.setStatus(false);

		//map userDTO to user, account
		modelMapper.map(userDTO, user);
		modelMapper.map(userDTO, compte);
		
		
		Optional<Utilisateur> saved = Optional.of(save(user));
		
		//create and save verification token if the user is saved
		saved.ifPresent(u -> {
			try {
				String token = UUID.randomUUID().toString();
				sessionService.save(saved.get(), token);
				
				//send verification  email
				emailService.sendHtmlMail(u);
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		return saved.get();
	}



}
