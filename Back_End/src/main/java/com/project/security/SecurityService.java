package com.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Question;
import com.project.model.Utilisateur;
import com.project.service.ServiceQuestion;

@Service
public class SecurityService {

	@Autowired
	ServiceQuestion su;

	public boolean canDeleteResponse(String login, int responseId) {
		Question qst = su.findByid(responseId);
		Utilisateur user = new Utilisateur();
		user = qst.getUser();

		System.out.println("login du vrai user " + user.getLogin());
		System.out.println("login du tryer " + login);

		
		if (login.equals(user.getLogin())){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean canEditUser(String principal, String login) {


		System.out.println("principal " + principal);
		System.out.println("login " + login);

		
		if (login.equals(principal)){
			return true;
		} else {
			return false;
		}
	}
	
}