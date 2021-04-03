package com.RessourseHumaine.Entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "T_Calendrier")
public class Calendrier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String compagne;
	
	
	@OneToMany(mappedBy = "calendrier")
	private List<Reglage> reglage;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompagne() {
		return compagne;
	}

	public void setCompagne(String compagne) {
		this.compagne = compagne;
	}


	public Calendrier(long id, String compagne) {
		super();
		this.id = id;
		this.compagne = compagne;
	}

	public Calendrier() {
		super();
	}
	
	
}
