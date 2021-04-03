package com.RessourseHumaine.Entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_Reglage")
public class Reglage {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "notification_signfie")
	private String notification_signfie;
	
	@Column(name = "affichage")
	private String affichage ;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name= "id_utilisateur")
	private Utilisateur utilisateur;

	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "id_calendrier", referencedColumnName = "id")
	private Calendrier calendrier;

	
	public Reglage(long id, String notification_signfie, String affichage) {
		super();
		this.id = id;
		this.notification_signfie = notification_signfie;
		this.affichage = affichage;
	}

	public Reglage() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNotification_signfie() {
		return notification_signfie;
	}

	public void setNotification_signfie(String notification_signfie) {
		this.notification_signfie = notification_signfie;
	}

	public String getAffichage() {
		return affichage;
	}

	public void setAffichage(String affichage) {
		this.affichage = affichage;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



}
