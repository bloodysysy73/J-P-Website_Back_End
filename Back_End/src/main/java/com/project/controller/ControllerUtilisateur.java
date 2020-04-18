package com.project.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

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

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;


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
		if (password != null) {
			password = MyProjectSpringApplication.getpce().encode(password);
		}else {
			password = MyProjectSpringApplication.getpce().encode("azertyuiop123456789?!");
		}
		utilisateur.setPassword(password);
		utilisateur.setDateInscription(datePourInscription);

		List<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		role.setId(2L);
		roles.add(role);

		utilisateur.setRoles(roles);

		return su.addOrModifyUtilisateur(utilisateur);
	}

	//@PreAuthorize()
	//TODO authorize current user
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
		
		if (u.getImgFile() == null) {
			u.setImgFile((user.getImgFile()));
		}

		if (u.getRoles() == null) {
			u.setRoles((user.getRoles()));
		}

		// if(u.isAdherent() == null){ u.setAdherent((user.isAdherent())) ;}

		return su.addOrModifyUtilisateur(u);
	}
	
	//@PreAuthorize()
		//TODO authorize current user
		@RequestMapping(value = "/updateImg", method = RequestMethod.PUT)
		public Utilisateur updateImg(@RequestBody Utilisateur u) {

			Utilisateur user = su.findbylogin(u.getLogin());
			
			//transformer le dataURL en bufferedImage
			String str = u.getImage();
			File imgFile = new File(u.getNom());
			
			byte[] imagedata = java.util.Base64.getDecoder().decode(str.substring(str.indexOf(",") + 1));
			BufferedImage bufferedImage = null;
			try {
				bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
			} catch (IOException e) {
				System.out.println("erreur 1 transformation IMG to blob");
				e.printStackTrace();
			}
			
			try {
				ImageIO.write(bufferedImage, "png", imgFile);
			} catch (IOException e) {
				System.out.println("erreur 2 transformation IMG to blob");
				e.printStackTrace();
			}
			
			System.out.println("the bufferedImage : " + bufferedImage);
			
			System.out.println("the file : " + imgFile);
			user.setImgFile(imgFile);
			user.setImage(u.getNom());
			
			return su.addOrModifyUtilisateur(user);
		}
		
		@RequestMapping(value = "/getimg/{login}", method = RequestMethod.GET)
		public String getimg(@PathVariable("login") String login) {

			
			return su.getimg(login);
		}

	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deleteplayer(@PathVariable("id") int id) {
		su.deletebyid(id);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Utilisateur> getAll() {
		return su.getAllUtilisateur();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') ")
	@RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
	public Optional<Utilisateur> findbyId(@PathVariable("id") int id) {
		return su.findById(id);
	}

	@RequestMapping(value = "/findbylogin/{login}", method = RequestMethod.GET)
	public Utilisateur findbyId(@PathVariable("login") String login) {
		return su.findbylogin(login);
	}

	@RequestMapping(value = "/loginexist/{login}", method = RequestMethod.GET)
	public boolean loginexist(@PathVariable("login") String login) {
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
	
	@RequestMapping(value = "/googletoken", method = RequestMethod.POST)
	public Utilisateur checkgoogletoken(@RequestBody Utilisateur utilisateur) {

	//	TODO : vérifier le token google. Si il est OK : coonecter le user et renvoyer un token valide
//		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
//			    // Specify the CLIENT_ID of the app that accesses the backend:
//			    .setAudience(Collections.singletonList("479915262149-5mfpd5lv59q93scecehcbdtin9ovie1c.apps.googleusercontent.com")).build();
//
//		
//

		return utilisateur;
	}

}