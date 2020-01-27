package com.project.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Utilisateur;
import com.project.repository.UtilisateurRepository;
import com.project.service.ServiceUtilisateur;


@Service
public class ServiceUtilisateurImp implements ServiceUtilisateur {

	@Autowired // injection du repository
	UtilisateurRepository utilisateurrep;
	
	@Override
	public Utilisateur addOrModifyUtilisateur(Utilisateur p) {
		return utilisateurrep.save(p);
	}

	@Override
	public void deleteUtilisateur(Utilisateur p) {
		utilisateurrep.delete(p);
		 return;			
	}

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		List<Utilisateur> Utilisateur = utilisateurrep.findAll();
		return Utilisateur;
	}

	@Override
	public Optional<Utilisateur> findById(int id) {
		return utilisateurrep.findById(id);
	}

	@Override
	public List<Utilisateur> findByName(String nom) {
		List<Utilisateur> players = utilisateurrep.findByName(nom);
		return players;	
		}

	@Override
	public void deletebyid(int id) {
		utilisateurrep.deleteById(id);
	}

	@Override
	public Utilisateur findByLogin(String login) {
		return utilisateurrep.findByLogin(login);
	}

	@Override
	public Utilisateur findbylogin(String login) {
		return utilisateurrep.findbylogin(login);
	}



	@Override
	public Utilisateur findByid(int id) {
		return utilisateurrep.findByid(id) ;
	}
	
	

}
