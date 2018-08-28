package com.SpringBoot.loncotoBack.metier;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"batiments","clients"})
public class Site {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private double latitude;
	private double longitude;
	
	@ManyToMany(mappedBy = "sites")private Set<Client> clients;
	@OneToMany(mappedBy = "site") private Set<Batiment> batiments;
	
	public Site(int id, String nom, String adresse, double latitude, double longitude) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	
}
