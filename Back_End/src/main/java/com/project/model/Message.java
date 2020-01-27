package com.project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author IN-LY-037
 *
 */
@Entity
public class Message implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ID_MESSAGE")
	int id;
	
	private String objet;
	private String texte;
	private String Date  ;
	private String email;
	private String pseudo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", objet=" + objet + ", texte=" + texte + ", Date=" + Date + ", email=" + email
				+ ", pseudo=" + pseudo + "]";
	}
	public Message(int id, String objet, String texte, String date, String email, String pseudo) {
		super();
		this.id = id;
		this.objet = objet;
		this.texte = texte;
		Date = date;
		this.email = email;
		this.pseudo = pseudo;
	}
	public Message() {
		super();
	}
	
}
