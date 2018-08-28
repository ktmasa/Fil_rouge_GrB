package com.SpringBoot.loncotoBack.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"materiels","sites"})
@Entity
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String entreprise;
	private String mail;
	private int telephone;
	private String siret;
	
	@OneToMany(mappedBy = "client") private Set<Materiel> materiels;
	//master of site-client relation
	@ManyToMany private Set<Site> sites;
	
	public Client(int id, String entreprise, String mail, int telephone, String siret) {
		super();
		this.id = id;
		this.entreprise = entreprise;
		this.mail = mail;
		this.telephone = telephone;
		this.siret = siret;
	}
	
	
	
}
