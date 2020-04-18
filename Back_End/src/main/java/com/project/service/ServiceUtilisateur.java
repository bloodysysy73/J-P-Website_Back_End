package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Utilisateur;



public interface ServiceUtilisateur {
	
	public Utilisateur addOrModifyUtilisateur(Utilisateur u);
//	public Utilisateur addOrModifyUtilisateurbyid
	public void deleteUtilisateur(Utilisateur p);
	public List<Utilisateur> getAllUtilisateur();
	public Optional<Utilisateur> findById(int id);
	public List<Utilisateur> findByName(String nom);
	public void deletebyid(int id);
	public Utilisateur findByLogin(String login); // pour le security
	public Utilisateur findbylogin(String login); // pour l'utilisateur
	public Utilisateur findByid(int id);
	public String retrievepseudo(String login);
	public String getimg(String login);


}
