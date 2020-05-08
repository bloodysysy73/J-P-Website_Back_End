package com.project.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.MyProjectSpringApplication;
import com.project.model.Role;
import com.project.model.Utilisateur;
import com.project.security.SecurityConstants;
import com.project.service.ServiceUtilisateur;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

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
		} else {
			// génère password aléatoire de length 20
			// FIXME : envoyer par mail

			Random r = new Random();
			String alphabet = "123456789azertyuiopqsdfghjklmwxcvbn?!*-+";
			StringBuilder passwordrandom = new StringBuilder();

			for (int i = 0; i < 20; i++) {
				passwordrandom.append(alphabet.charAt(r.nextInt(alphabet.length())));
			}
			password = passwordrandom.toString();
			password = MyProjectSpringApplication.getpce().encode(password);
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

	@PreAuthorize("hasRole('ROLE_ADMIN') or  @securityService.canEditUser(principal, #u.login)")
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
		} else {
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

		if (u.getImgBlob() == null) {
			u.setImgBlob((user.getImgBlob()));
		}

		if (u.getRoles() == null) {
			u.setRoles((user.getRoles()));
		}

		// if(u.isAdherent() == null){ u.setAdherent((user.isAdherent())) ;}

		return su.addOrModifyUtilisateur(u);
	}

	// @PreAuthorize()
	@PreAuthorize("hasRole('ROLE_ADMIN') or  @securityService.canEditUser(principal, #u.login)")
	@RequestMapping(value = "/updateBlobImg", method = RequestMethod.PUT)
	public Utilisateur updateBlobImg(@RequestBody Utilisateur u) {

		Utilisateur user = su.findbylogin(u.getLogin());
		String str = u.getNom();
		user.setImage(u.getImage());
		user.setImgBlob(str);

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

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
	public Optional<Utilisateur> findbyId(@PathVariable("id") int id) {
		return su.findById(id);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or  @securityService.canEditUser(principal, #login)")
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
	public String checkgoogletoken(@RequestBody String googleIdToken) throws GeneralSecurityException, IOException {

		System.out.println(googleIdToken);
		HttpTransport transport = new NetHttpTransport();
		JsonFactory mJFactory = new JacksonFactory();

		// TODO : vérifier le token google. Si il est OK
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, mJFactory)
				.setAudience(Collections
						.singletonList("479915262149-5mfpd5lv59q93scecehcbdtin9ovie1c.apps.googleusercontent.com"))
				.build();

		GoogleIdToken idToken = verifier.verify(googleIdToken);

		String jwt = "";

		if (idToken != null) {
			Payload payload = idToken.getPayload();

			String userMail = payload.getEmail();

			User springUser = (User) new User(userMail, "", true, true, true, true,
					AuthorityUtils.createAuthorityList("USER"));

			jwt = Jwts.builder().setSubject(springUser.getUsername())
					.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
					.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
					.claim("roles", springUser.getAuthorities()).compact();

		} else {
			System.out.println("Invalid ID token.");
		}

		return "Bearer " + jwt;
	}

}