package com.RessourseHumaine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.RessourseHumaine.Entity.Action;
import com.RessourseHumaine.Services.ActionService;

@RestController
@RequestMapping({"/action"})
public class ActionController {

	final private ActionService actionService;

	@Autowired
	public ActionController(ActionService actionService) {
		super();
		this.actionService = actionService;
	}
	
	@PostMapping("/addAction")
	@ResponseBody
	public Action addAction(@RequestBody Action action) {
		actionService.addAction(action);
		return action;
	}
	
	@GetMapping(value = "/getActionById/{actionId}")
	@ResponseBody
	public Action getActionById(@PathVariable("actionId") long actionId) {
		return actionService.getActionById(actionId);
	}

	@GetMapping(value = "/getAllAction")
	@ResponseBody
	public List<Action> getAllAction() {

		return actionService.getAllaction();
	}

	@PutMapping(value = "/updateAction/{id}")
	@ResponseBody
	public void updateAction(@PathVariable("id") int ActionId, @RequestBody Action action) {
		actionService.updateAction(action.getDateDebut(), action.getDateFin(), action.getTypeAction(), action.getStatutAction(), action.getSubjectif(), ActionId);

	}

	@DeleteMapping("/deleteActionById/{ActionId}")
	@ResponseBody
	public void deleteActionById(@PathVariable("ActionId") int ActionId) {
		actionService.deleteActionById(ActionId);
	}

	@PutMapping(value = "/affecterActionAUser/{ActionId}/{userId}")
	public void affecterActionAuserGarten(@PathVariable("ActionId") int ActionId,
			@PathVariable("userId") int userId) {
		actionService.affecterActionAUtilisateur(ActionId, userId);

	}

	
	

}
