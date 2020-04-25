package com.project.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Role;
import com.project.service.ServiceRole;



@RestController
@CrossOrigin
@RequestMapping("/role")
public class ControllerRole {
	
	@Autowired
	ServiceRole sr;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Role ajouter_modifier(@RequestBody Role role)
	{
		return sr.ajouter_modifier(role);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public void supprimer_role(@PathVariable("id")Long id) {
		sr.supprimer_role(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Role> getAll()
	{
		return sr.getAll();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/findone/{id}",method=RequestMethod.GET)
	public Optional<Role> findRole(@PathVariable("id")Long id)
	{
		return sr.findRole(id);
	}

}
