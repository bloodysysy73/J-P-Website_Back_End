package com.project.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Message;
import com.project.service.ServiceMessage;
import com.project.service.serviceimp.EmailServiceImpl;



@RestController
@CrossOrigin
@RequestMapping("/message")
public class ControllerMessage {
	
	@Autowired
	ServiceMessage sm;
	
	@Autowired
	public SimpleMailMessage template;
	
	@Autowired
	EmailServiceImpl es;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Message ajouter_modifier(@RequestBody Message message)
	{
		LocalDateTime date = LocalDateTime.now();  
		String strDate = date.toString();
		message.setDate(strDate);
		sm.addOrModify(message);
			  
		 
		return message;
		     
		     
	}

	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public void supprimer_Message(@PathVariable("id")int id) {
		sm.deleteById(id);
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Message> getAll()
	{
		return sm.getAll();
	}
	
	@RequestMapping(value="/mail",method=RequestMethod.POST)
	public void mail(@RequestBody Message message)
	{
		String text = message.getTexte();  
		String to = "sylvain.guehria@gmail.com";
		String subject = message.getObjet();
		es.sendSimpleMessage(to, subject, text);
		 		     
		     
	}
	

}
