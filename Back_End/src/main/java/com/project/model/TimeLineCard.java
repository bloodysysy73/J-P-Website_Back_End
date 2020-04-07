package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Evenement")
public class TimeLineCard {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIMELINECARD")
	int id;

	@Column(name="TITLE")
	String title;
	
	@Column(name="DESCRIPTION")
	String description;
	
	@Column(name="IMAGE")
	String imageName;
	
	@Column(name="TITLE2")
	String title2;
	
	@Column(name="DESCRIPTION2")
	String description2;
	
	@Column(name="DATE")
	String date;
	
	@Column(name="HEURE")
	String heure;

	@Column(name="POSTE_LE")
	String poste_le;
	
	@Column(name="ICONE")
	String icone_name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getDescription2() {
		return description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public TimeLineCard(int id, String title, String description, String imageName, String title2, String description2,
			String date, String heure, String poste_le) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageName = imageName;
		this.title2 = title2;
		this.description2 = description2;
		this.date = date;
		this.heure = heure;
		this.poste_le = poste_le;
	}

	@Override
	public String toString() {
		return "TimeLineCard [id=" + id + ", title=" + title + ", description=" + description + ", imageName="
				+ imageName + ", title2=" + title2 + ", description2=" + description2 + ", date=" + date + ", heure="
				+ heure + ", poste_le=" + poste_le + "]";
	}

	public String getPoste_le() {
		return poste_le;
	}

	public void setPoste_le(String poste_le) {
		this.poste_le = poste_le;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public TimeLineCard() {
		super();
	}

	public String getIcone_name() {
		return icone_name;
	}

	public void setIcone_name(String icone_name) {
		this.icone_name = icone_name;
	}
	
	
	
	
	
}
