package com.RessourseHumaine.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "T_Action")
public class Action {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "date_debut")
	private Date dateDebut;
	
	@Column(name = "date_fin")
	private Date dateFin;
	
	@Column(name = "type_action")
	private String typeAction;
	
	@Column(name = "statut_action")
	private String statutAction;
	
	@Column(name = "subjectif")
	private String subjectif;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "id_utilisateur", referencedColumnName = "id")
	private Utilisateur utilisateur;

	
	public Action() {
		super();
	}
	
	

	public Action(long id, Date dateDebut, Date dateFin, String typeAction, String statutAction) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.typeAction = typeAction;
		this.statutAction = statutAction;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubjectif() {
		return subjectif;
	}

	public void setSubjectif(String subjectif) {
		this.subjectif = subjectif;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public Date getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}



	public Date getDateFin() {
		return dateFin;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	public String getTypeAction() {
		return typeAction;
	}



	public void setTypeAction(String typeAction) {
		this.typeAction = typeAction;
	}



	public String getStatutAction() {
		return statutAction;
	}



	public void setStatutAction(String statutAction) {
		this.statutAction = statutAction;
	}
	
	
	
}
