package com.RessourseHumaine.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "T_Compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "society")
	private String society;
	
	@Column(name = "activity")
	private String activity;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private int phone;

	@Column(name = "mobile_phone")
	private int mobilePhone;
	
	@OneToMany(mappedBy = "compte")
	private List<Utilisateur>utilisateurs;
	
	
	public Compte() {
		
	}


	public Compte(long id, String society, String activity, String address, int phone, int mobilePhone,
			List<Utilisateur> utilisateurs) {
		super();
		this.id = id;
		this.society = society;
		this.activity = activity;
		this.address = address;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.utilisateurs = utilisateurs;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getSociety() {
		return society;
	}


	public void setSociety(String society) {
		this.society = society;
	}


	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public int getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(int mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}


	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	
	

}
