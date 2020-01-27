package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTAIRE")
public class Commentaire {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMMENTAIRE")
	int id;

	private String titre;
	private String texte;
	private String date;
	private String pseudo;
	
	int note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", titre=" + titre + ", texte=" + texte + ", date=" + date + ", pseudo="
				+ pseudo + ", note=" + note + "]";
	}
	public Commentaire(int id, String titre, String texte, String date, String pseudo, int note) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
		this.date = date;
		this.pseudo = pseudo;
		this.note = note;
	}
	public Commentaire() {
		super();
	}
	
	
	
}
