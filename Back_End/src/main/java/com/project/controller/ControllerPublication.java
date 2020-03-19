package com.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Publication;
import com.project.service.ServicePublication;

@RestController
@CrossOrigin
@RequestMapping("/publication")
public class ControllerPublication {
	
	@Autowired
	ServicePublication servicePublication ; 
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Publication ajouter_modifier(@RequestBody Publication publication)
	{
		LocalDateTime date = LocalDateTime.now();  
		String strDate = date.toString();
		publication.setDate(strDate);
		servicePublication.addOrModify(publication);
			  
		 
		return publication;
		     
		     
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public void supprimer_Publication(@PathVariable("id")int id) {
		servicePublication.deleteById(id);
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Publication> getAll()
	{
		return servicePublication.getAll();
	}
	
	@RequestMapping(value="/getByUser/{login}",method=RequestMethod.GET)
	public List<Publication> getByUser(@PathVariable("login") String login)
	{
		return servicePublication.getPublicationByUser(login);
	}

}
