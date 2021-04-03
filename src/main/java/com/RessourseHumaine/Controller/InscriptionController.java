package com.RessourseHumaine.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RessourseHumaine.Object.UserDTO;
import com.RessourseHumaine.Services.InscriptionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class InscriptionController {
	
	private final InscriptionService inscriptionService;

	@Autowired
	public InscriptionController(InscriptionService inscriptionService) {
		super();
		this.inscriptionService = inscriptionService;
	}
	
	
	@PostMapping("/register")
	public String save(@RequestBody /*@Valid*/ UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		//check if the user exists
		if(inscriptionService.userExists(userDTO.getEmail())) {
			bindingResult.addError(new FieldError("userDTO", "email", "Email address already in use"));
			return "Email address already in use";
		}
		
		//check if the password match
		if(userDTO.getPassword() != null && userDTO.getRpassword() != null) {
			if(!userDTO.getPassword().equals(userDTO.getRpassword())) {
				bindingResult.addError(new FieldError("userDTO", "rpassword", "password must match"));
				return "password must match";
			}	
		}
		
		
		if(bindingResult.hasErrors()) {
			return "register echec";
		}
		//show success message
		redirectAttributes.addFlashAttribute("message", "Success! A verification email has been sent to your email address.");
		inscriptionService.register(userDTO);
		return "Success! redirect:/login";
	}

}
