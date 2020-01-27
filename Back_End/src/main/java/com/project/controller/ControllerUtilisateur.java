package com.project.controller;

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

import com.project.MyProjectSpringApplication;
import com.project.model.Utilisateur;
import com.project.service.ServiceUtilisateur;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class ControllerUtilisateur {

	@Autowired
	ServiceUtilisateur su;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Utilisateur addormodify(@RequestBody Utilisateur utilisateur) {
		String password = utilisateur.getPassword();
		password = MyProjectSpringApplication.getpce().encode(password);
		utilisateur.setPassword(password);
		return su.addOrModifyUtilisateur(utilisateur);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public Utilisateur modify(@RequestBody Utilisateur u) {

		return su.addOrModifyUtilisateur(u);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deleteplayer(@PathVariable("id") int id) {
		su.deletebyid(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Utilisateur> getAll() {
		return su.getAllUtilisateur();
	}

	@RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
	public Optional<Utilisateur> findbyId(@PathVariable("id") int id) {
		return su.findById(id);
	}

	@RequestMapping(value = "/findbylogin/{login}", method = RequestMethod.GET)
	public Utilisateur findbyId(@PathVariable("login") String login) {
		return su.findbylogin(login);
	}

	@RequestMapping(value = "/pseudoexist/{login}", method = RequestMethod.GET)
	public boolean pseudoexist(@PathVariable("login") String login) {
		if (su.findbylogin(login) != null) {
			return true;
		} else {
			return false;
		}
	}

}