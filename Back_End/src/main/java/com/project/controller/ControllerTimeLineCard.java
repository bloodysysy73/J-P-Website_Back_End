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
import com.project.model.Utilisateur;
import com.project.model.Role;
import com.project.service.ServiceTimeLineCard;



@RestController
@CrossOrigin
@RequestMapping(value = "/timelinecard")
public class ControllerTimeLineCard {

	@Autowired
	ServiceTimeLineCard su;
		
	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public TimeLineCard addormodify(@RequestBody TimeLineCard timeLineCard)
	{
		String pattern = "dd-MM-yyyy à HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());

		timeLineCard.setPoste_le(date);
		
		return su.addOrModifyTimeLineCard(timeLineCard);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value="/edit",method=RequestMethod.PUT)
	public TimeLineCard modify(@RequestBody TimeLineCard timeLineCard)
	{
			
		//ceci car  @JsonInclude(JsonInclude.Include.NON_NULL) ne fonctionne pas, hibernate n'ignore pas les fields null
		TimeLineCard tlc = su.findByid(timeLineCard.getId());
		
		if(timeLineCard.getTitle() == null){ timeLineCard.setTitle((tlc.getTitle())) ;}
		if(timeLineCard.getDescription() == null){ timeLineCard.setDescription((tlc.getDescription())) ;}
		if(timeLineCard.getImageName() == null){ timeLineCard.setImageName((tlc.getImageName())) ;}
		if(timeLineCard.getTitle2() == null){ timeLineCard.setTitle2((tlc.getTitle2())) ;}
		if(timeLineCard.getDescription2() == null){ timeLineCard.setDescription2((tlc.getDescription2())) ;}
		if(timeLineCard.getHeure() == null){ timeLineCard.setHeure((tlc.getHeure())) ;}
		if(timeLineCard.getPoste_le() == null){ timeLineCard.setPoste_le((tlc.getPoste_le())) ;}
		if(timeLineCard.getIcone_name() == null){ timeLineCard.setIcone_name((tlc.getIcone_name())) ;}

		
		return su.addOrModifyTimeLineCard(timeLineCard);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') ")
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