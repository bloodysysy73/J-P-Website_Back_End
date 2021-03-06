package com.project.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Publication;
import com.project.model.TimeLineCard;
import com.project.model.Utilisateur;
import com.project.service.ServicePublication;

@RestController
@CrossOrigin
@RequestMapping("/publication")
public class ControllerPublication {

	@Autowired
	ServicePublication servicePublication;

	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Publication ajouter_modifier(@RequestBody Publication publication) {

		String pattern = "dd-MM-yyyy à HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.FRANCE);
		String date = simpleDateFormat.format(new Date());

		publication.setDate(date);
		return servicePublication.addOrModify(publication);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public Publication modify(@RequestBody Publication Publication) {
		// ceci car @JsonInclude(JsonInclude.Include.NON_NULL) ne fonctionne pas,
		// hibernate n'ignore pas les fields null
		Publication pbct = servicePublication.findByid(Publication.getId());

		if (Publication.getTitle() == null) {
			Publication.setTitle((pbct.getTitle()));
		}
		if (Publication.getDescription() == null) {
			Publication.setDescription((pbct.getDescription()));
		}
		if (Publication.getImageName() == null) {
			Publication.setImageName((pbct.getImageName()));
		}
		if (Publication.getTitle2() == null) {
			Publication.setTitle2((pbct.getTitle2()));
		}
		if (Publication.getDescription2() == null) {
			Publication.setDescription2((pbct.getDescription2()));
		}
		if (Publication.getHeure() == null) {
			Publication.setHeure((pbct.getHeure()));
		}
		if (Publication.getPoste_le() == null) {
			Publication.setPoste_le((pbct.getPoste_le()));
		}
		if (Publication.getLogin() == null) {
			Publication.setLogin((pbct.getLogin()));
		}
		if (Publication.getIcone_name() == null) {
			Publication.setIcone_name((pbct.getIcone_name()));
		}
		if (Publication.getDate() == null) {
			Publication.setDate((pbct.getDate()));
		}
		if (Publication.getImgBlob() == null) {
			Publication.setImgBlob((pbct.getImgBlob()));
		}

		return servicePublication.addOrModify(Publication);
	}

	// @PreAuthorize()
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/updateBlobImg", method = RequestMethod.PUT)
	public Publication updateBlobImg(@RequestBody Publication p) {

		Publication publi = servicePublication.findByid(p.getId());
		String str = p.getImgBlob();
		publi.setImageName(p.getImageName());
		publi.setImgBlob(str);

		return servicePublication.addOrModify(publi);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void supprimer_Publication(@PathVariable("id") int id) {
		servicePublication.deleteById(id);
	}

	@RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
	public Publication findPublicationById(@PathVariable("id") int id) {
		return servicePublication.findByid(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Publication> getAll() {
		return servicePublication.getAll();
	}

	@RequestMapping(value = "/getByUser/{login}", method = RequestMethod.GET)
	public List<Publication> getByUser(@PathVariable("login") String login) {
		return servicePublication.getPublicationByUser(login);
	}

}
