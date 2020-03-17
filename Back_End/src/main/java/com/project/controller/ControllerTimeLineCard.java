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

import com.project.model.TimeLineCard;
import com.project.model.Role;
import com.project.service.ServiceTimeLineCard;



@RestController
@CrossOrigin
@RequestMapping(value = "/timelinecard")
public class ControllerTimeLineCard {

	@Autowired
	ServiceTimeLineCard su;
		
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public TimeLineCard addormodify(@RequestBody TimeLineCard timeLineCard)
	{
		Date poste_le = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");  
		String strDate = dateFormat.format(poste_le);  
		timeLineCard.setPoste_le(strDate);
		
		//if(timeLineCard.getNote()==0) {timeLineCard.setNote(null);}
		return su.addOrModifyTimeLineCard(timeLineCard);
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.PATCH)
	public TimeLineCard modify(@RequestBody TimeLineCard timeLineCard)
	{
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");  
		String strDate = dateFormat.format(date);  
		timeLineCard.setDate(strDate);
		
		//if(timeLineCard.getNote()==0) {timeLineCard.setNote(null);}
		return su.addOrModifyTimeLineCard(timeLineCard);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public void deleteplayer(@PathVariable("id")int id) {
		su.deletebyid(id);
	}
	
	
	
	
	@RequestMapping(value="/findbyid/{id}",method=RequestMethod.GET)
	public Optional<TimeLineCard> findbyId(@PathVariable("id")int id)
	{
		return su.findById(id);
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<TimeLineCard> getAll()
	{
		return su.getAllTimeLineCard();
	}
	
	
	
	
	


}