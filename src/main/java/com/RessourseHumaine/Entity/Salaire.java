package com.RessourseHumaine.Entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_Salaire")
public class Salaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "avance")
	private boolean avance;
	
	@Column(name = "salaire_generale")
	private double salaireGenerale;
	
	@Column(name = "prix_avance")
	private double prixAvance;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name= "id_user")
	private Utilisateur utilisateur;
	

	public Salaire() {
		super();
	}
	

	public Salaire(long id, boolean avance, double salaireGenerale, double prixAvance) {
		super();
		this.id = id;
		this.avance = avance;
		this.salaireGenerale = salaireGenerale;
		this.prixAvance = prixAvance;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAvance() {
		return avance;
	}

	public void setAvance(boolean avance) {
		this.avance = avance;
	}



	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	
	
}
