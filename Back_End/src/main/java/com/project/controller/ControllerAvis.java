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

import com.project.model.Avis;
import com.project.service.ServiceAvis;

@RestController
@CrossOrigin
@RequestMapping("/avis")
public class ControllerAvis {
	
	@Autowired
	ServiceAvis serviceAv ; 
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Avis ajouter_modifier(@RequestBody Avis avis)
	{
		LocalDateTime date = LocalDateTime.now();  
		String strDate = date.toString();
		avis.setDate(strDate);
		serviceAv.addOrModify(avis);
			  
		 
		return avis;
		     
		     
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public void supprimer_Avis(@PathVariable("id")int id) {
		serviceAv.deleteById(id);
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Avis> getAll()
	{
		return serviceAv.getAll();
	}
	
	@RequestMapping(value="/getByUser/{login}",method=RequestMethod.GET)
	public List<Avis> getByUser(@PathVariable("login") String login)
	{
		return serviceAv.getAvisByUser(login);
	}

}
