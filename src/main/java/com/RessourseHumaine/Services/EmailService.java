package com.RessourseHumaine.Services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.RessourseHumaine.Entity.Session;
import com.RessourseHumaine.Entity.Utilisateur;

@Service
public class EmailService {
	
	private final SessionService sessionService;
	private final JavaMailSender javaMailSender;

	@Autowired
	public EmailService(SessionService sessionService, JavaMailSender javaMailSender) {
		this.sessionService = sessionService;
		this.javaMailSender = javaMailSender;
	}
	
	public void sendHtmlMail(Utilisateur utilisateur) throws MessagingException{
		Session session = sessionService.findByUser(utilisateur);
		//check if the user has a token
		
		if(session != null ) {
			String token = session.getToken();
//			Context context = new Context();
//			context.setVariable("title", "Verify your email address");
//			context.setVariable("link", "http://localhost:8080/activation?token="+token);
//			//create an HTML template and pass the variable to it
//			String body = templateEngine.process("verification", context);
			
			//send the verificatio email
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(utilisateur.getEmail());
			helper.setSubject("email address verification");
			helper.setText("http://localhost:8080/activation?token="+token, true);
			javaMailSender.send(message);
			
		}
	}



}
