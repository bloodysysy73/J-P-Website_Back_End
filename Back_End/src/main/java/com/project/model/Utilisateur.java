package com.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ID_UTILISATEUR")
	private int id;
	
	private String login;
	
	private String pseudo ;

	private String password ;
	
	private String nom;
	
	private String prenom;
	
	private String adresse ;
	
	private String dateInscription ; 	
	
	boolean isAdherent ;
	
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "UTILISATEUR_ROLE", joinColumns = @JoinColumn(name = "FK_UTILISATEUR_ID", referencedColumnName = "ID_UTILISATEUR"), inverseJoinColumns = @JoinColumn(name = "FK_ROLE_ID", referencedColumnName = "ID_ROLE"))
	private List<Role> roles;
	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", pseudo=" + pseudo + ", password=" + password + ", nom="
				+ nom + ", prenom=" + prenom + ", adresse=" + adresse + ", dateInscription=" + dateInscription
				+ ", isAdherent=" + isAdherent + ", roles=" + roles + "]";
	}
	public boolean isAdherent() {
		return isAdherent;
	}
	public void setAdherent(boolean isAdherent) {
		this.isAdherent = isAdherent;
	}
	public Utilisateur(int id, String login, String pseudo, String password, String nom, String prenom, String adresse,
			String dateInscription, boolean isAdherent, List<Role> roles) {
		super();
		this.id = id;
		this.login = login;
		this.pseudo = pseudo;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateInscription = dateInscription;
		this.isAdherent = isAdherent;
		this.roles = roles;
	}
	public Utilisateur() {
		super();
	}
	
	
	

	


}
