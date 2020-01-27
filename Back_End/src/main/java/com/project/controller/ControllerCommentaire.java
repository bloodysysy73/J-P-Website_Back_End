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

import com.project.model.Commentaire;
import com.project.model.Role;
import com.project.service.ServiceCommentaire;



@RestController
@CrossOrigin
@RequestMapping(value = "/commentaire")
public class ControllerCommentaire {

	@Autowired
	ServiceCommentaire su;
		
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Commentaire addormodify(@RequestBody Commentaire commentaire)
	{
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");  
		String strDate = dateFormat.format(date);  
		commentaire.setDate(strDate);
		
		//if(commentaire.getNote()==0) {commentaire.setNote(null);}
		return su.addOrModifyCommentaire(commentaire);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public void deleteplayer(@PathVariable("id")int id) {
		su.deletebyid(id);
	}
	
	
	
	
	@RequestMapping(value="/findbyid/{id}",method=RequestMethod.GET)
	public Optional<Commentaire> findbyId(@PathVariable("id")int id)
	{
		return su.findById(id);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Commentaire> getAll()
	{
		return su.getAllCommentaire();
	}
	
	
	
	
	


}