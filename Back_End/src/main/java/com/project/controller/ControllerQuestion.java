package com.project.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Question;
import com.project.model.Utilisateur;
import com.project.service.ServiceQuestion;
import com.project.service.ServiceUtilisateur;



@RestController
@CrossOrigin
@RequestMapping(value = "/question")
public class ControllerQuestion {

	@Autowired
	ServiceQuestion su;
	
	@Autowired
	ServiceUtilisateur us;
		
	@PreAuthorize("isAuthenticated()")  
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Question addormodify(@RequestBody Question question)
	{
		System.out.println("QUESTION : " + question);
		Utilisateur user = new Utilisateur();
		Utilisateur user2 = new Utilisateur();
		user2 = question.getUser();

		user = us.findbylogin(user2.getLogin());
		
		question.setUser(user);
				
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");  
		String strDate = dateFormat.format(date);  
		question.setDate(strDate);
		
		return su.addOrModifyQuestion(question);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or  @securityService.canDeleteResponse(principal, #id)")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public void deleteplayer(@PathVariable("id")int id) {
		su.deletebyid(id);
	}
	
	@RequestMapping(value="/findbyid/{id}",method=RequestMethod.GET)
	public Question findbyId(@PathVariable("id")int id)
	{
		return su.findByid(id);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Question> getAll()
	{
		return su.getAllQuestion();
	}
	
	
	
	
	


}