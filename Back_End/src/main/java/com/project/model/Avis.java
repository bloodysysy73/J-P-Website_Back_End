package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ID_AVIS")
	private int idavis;

	private String titre;

	private String description;

	private double note;

	private String date;

	private String login;

	public int getIdavis() {
		return idavis;
	}

	public void setIdavis(int idavis) {
		this.idavis = idavis;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}





	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Avis [idavis=" + idavis + ", titre=" + titre + ", description=" + description + ", note=" + note
				+ ", date=" + date + ", login=" + login + "]";
	}

	public Avis(int idavis, String titre, String description, double note, String date, String login) {
		super();
		this.idavis = idavis;
		this.titre = titre;
		this.description = description;
		this.note = note;
		this.date = date;
		this.login = login;
	}

	public Avis() {
		super();
	}
	
	

}
