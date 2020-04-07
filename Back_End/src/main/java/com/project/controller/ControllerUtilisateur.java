package com.project.controller;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import com.project.MyProjectSpringApplication;
import com.project.model.Role;
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

		Date dateInscription = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		String datePourInscription = formatter.format(dateInscription);
		String password = utilisateur.getPassword();
		password = MyProjectSpringApplication.getpce().encode(password);
		utilisateur.setPassword(password);
		utilisateur.setDateInscription(datePourInscription);

		List<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		role.setId(2L);
		roles.add(role);

		utilisateur.setRoles(roles);

		return su.addOrModifyUtilisateur(utilisateur);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public Utilisateur modify(@RequestBody Utilisateur u) {

		// ceci car @JsonInclude(JsonInclude.Include.NON_NULL) ne fonctionne pas,
		// hibernate n'ignore pas les fields null
		Utilisateur user = su.findByid(u.getId());

		if (u.getLogin() == null) {
			u.setLogin((user.getLogin()));
		}

		if (u.getPseudo() == null) {
			u.setPseudo((user.getPseudo()));
		}

		if (u.getPassword() == null) {
			u.setPassword((user.getPassword()));
		}else {
			String password = MyProjectSpringApplication.getpce().encode(u.getPassword());
			u.setPassword(password);
		}

		if (u.getNom() == null) {
			u.setNom((user.getNom()));
		}

		if (u.getPrenom() == null) {
			u.setPrenom((user.getPrenom()));
		}

		if (u.getAdresse() == null) {
			u.setAdresse((user.getAdresse()));
		}

		if (u.getDateInscription() == null) {
			u.setDateInscription((user.getDateInscription()));
		}

		if (u.getDescription() == null) {
			u.setDescription((user.getDescription()));
		}

		if (u.getNbenfant() == null) {
			u.setNbenfant((user.getNbenfant()));
		}

		if (u.getImage() == null) {
			u.setImage((user.getImage()));
		}

		if (u.getRoles() == null) {
			u.setRoles((user.getRoles()));
		}

		// if(u.isAdherent() == null){ u.setAdherent((user.isAdherent())) ;}

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

	@RequestMapping(value = "/retrievepseudo/{login}", method = RequestMethod.GET)
	public String retrievepseudo(@PathVariable("login") String login) {

		String pseudo = su.retrievepseudo(login);

		if (pseudo != null) {
			return pseudo;
		} else {
			return null;
		}
	}

}