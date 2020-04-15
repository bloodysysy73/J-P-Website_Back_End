package com.project.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Reponse;
import com.project.service.ServiceReponse;



@RestController
@CrossOrigin
@RequestMapping(value = "/reponse")
public class ControllerReponse {

	@Autowired
	ServiceReponse su;
		
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Reponse addormodify(@RequestBody Reponse reponse)
	{
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");  
		String strDate = dateFormat.format(date);  
		reponse.setDate(strDate);
		
		return su.addOrModifyReponse(reponse);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public void deleteplayer(@PathVariable("id")int id) {
		su.deletebyid(id);
	}
	
	@RequestMapping(value="/findbyid/{id}",method=RequestMethod.GET)
	public Optional<Reponse> findbyId(@PathVariable("id")int id)
	{
		return su.findById(id);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Reponse> getAll()
	{
		return su.getAllReponse();
	}
	
	
	
	
	


}