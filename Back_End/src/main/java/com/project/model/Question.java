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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "question")
public class Question {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_QUESTION")
	int id;

	private String titre;
	private String texte;
	private String date;
	private boolean repondu;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="ID_UTILISATEUR")
	private Utilisateur user;
	
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "question")
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="QUESTION_REPONSE", joinColumns={@JoinColumn(name="ID_QUESTION", referencedColumnName="ID_QUESTION")}, inverseJoinColumns={@JoinColumn(name="ID_REPONSE", referencedColumnName="ID_REPONSE")})
	private List<Reponse> reponses;
	
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

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", titre=" + titre + ", texte=" + texte + ", date=" + date + ", repondu="
				+ repondu + ", user=" + user + ", reponses=" + reponses + "]";
	}

	public Question(int id, String titre, String texte, String date, Utilisateur user, List<Reponse> reponses) {
		super();
		this.id = id;
		this.titre = titre;
		this.texte = texte;
		this.date = date;
		this.user = user;
		this.reponses = reponses;
	}

	public Question() {
		super();
	}

	public boolean isRepondu() {
		return repondu;
	}

	public void setRepondu(boolean repondu) {
		this.repondu = repondu;
	}
	
	
	
}
