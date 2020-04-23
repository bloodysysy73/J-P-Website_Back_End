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
		private String loginUser;
		

//		@ManyToOne(fetch = FetchType.LAZY)
//		@NotFound(action = NotFoundAction.IGNORE)
//		@JoinColumn(name="ID_UTILISATEUR")
//		private Utilisateur utilisateur;

//		@ManyToOne(fetch = FetchType.LAZY)
//		private Question question;


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


		public String getLoginUser() {
			return loginUser;
		}


		public void setLoginUser(String loginUser) {
			this.loginUser = loginUser;
		}



		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		@Override
		public String toString() {
			return "Reponse [id=" + id + ", texte=" + texte + ", date=" + date + ", loginUser=" + loginUser
					;
		}


		public Reponse(int id, String texte, String date, String loginUser) {
			super();
			this.id = id;
			this.texte = texte;
			this.date = date;
			this.loginUser = loginUser;
		}


		public Reponse() {
			super();
		}
		
		

}
