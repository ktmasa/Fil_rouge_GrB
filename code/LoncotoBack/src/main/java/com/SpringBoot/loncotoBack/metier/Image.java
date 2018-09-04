package com.SpringBoot.loncotoBack.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @ToString(exclude = {"intervention"})
@Entity
public class Image {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String storageName;
	private String fileName;
	private String contentType;
	@ManyToOne private Intervention intervention;
	
	public Image(long id, String storageName, String fileName, String contentType) {
		super();
		this.id = id;
		this.storageName = storageName;
		this.fileName = fileName;
		this.contentType = contentType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Intervention getIntervention() {
		return intervention;
	}

	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	
	
	
	
	

}
