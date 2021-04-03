package com.RessourseHumaine.Entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_Attachment")
public class Attachement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "size")
	private long size;
	
	@Column(name = "extension")
	private String extension;
	
	@Column(name = "file_content")
	@Lob
	private byte[] fileContent;
	


	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "id_utilisateur", referencedColumnName = "id")
	private Utilisateur utilisateur;
	
	
	public Attachement() {
		
	}

	public Attachement(String name, Long size, String extension, byte[] fileContent) {
		super();
		this.name = name;
		this.size = size;
		this.extension = extension;
		this.fileContent = fileContent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}


	
	
	
	
}
