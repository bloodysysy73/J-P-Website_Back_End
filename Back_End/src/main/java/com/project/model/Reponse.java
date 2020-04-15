package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name = "REPONSE")
public class Reponse {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID_REPONSE")
		int id;

		private String texte;
		private String date;
		

		@ManyToOne(fetch = FetchType.LAZY)
		@NotFound(action = NotFoundAction.IGNORE)
		@JoinColumn(name="ID_UTILISATEUR")
		private Utilisateur utilisateur;

		@ManyToOne(fetch = FetchType.LAZY)
		@NotFound(action = NotFoundAction.IGNORE)
		@JoinColumn(name="ID_QUESTION")
		private Question question;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public Question getQuestion() {
			return question;
		}

		public void setQuestion(Question question) {
			this.question = question;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Reponse [id=" + id + ", texte=" + texte + ", date=" + date + ", utilisateur=" + utilisateur
					+ ", question=" + question + "]";
		}


		public Reponse() {
			super();
		}

		public Utilisateur getUtilisateur() {
			return utilisateur;
		}

		public void setUtilisateur(Utilisateur utilisateur) {
			this.utilisateur = utilisateur;
		}

		public Reponse(int id, String texte, String date, Utilisateur utilisateur, Question question) {
			super();
			this.id = id;
			this.texte = texte;
			this.date = date;
			this.utilisateur = utilisateur;
			this.question = question;
		}
		 
		 
		
		
}
