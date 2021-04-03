package com.RessourseHumaine.Object;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;


public class UserDTO {
	
	//Utilisateur
		@NotBlank(message = "Enter your email")
		@Email(message = "Enter a valid email address")
		private String email;
		@NotBlank(message = "Enter your password")
		@Length(min = 6, message = "Password must be at least 6 characters")
		private String password;

		@NotBlank(message = "Re-enter your password")
		private String rpassword;
		@NotBlank(message = "Enter your first name")
		private String nom;
		@NotBlank(message = "Enter your last name")
		private String prenom;
		//compte
		private String society;
		private String activity;
		private String address;
		private int phone;
		private int mobilePhone;
		
		public UserDTO() {
	
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRpassword() {
			return rpassword;
		}

		public void setRpassword(String rpassword) {
			this.rpassword = rpassword;
		}

		public String getnom() {
			return nom;
		}

		public void setnom(String nom) {
			this.nom = nom;
		}

		public String getprenom() {
			return prenom;
		}

		public void setprenom(String prenom) {
			this.prenom = prenom;
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
		
		



}
