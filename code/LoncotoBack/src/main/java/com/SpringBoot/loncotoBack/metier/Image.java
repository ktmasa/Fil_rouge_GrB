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

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"intervention"})
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
	
	
	
	
	

}
