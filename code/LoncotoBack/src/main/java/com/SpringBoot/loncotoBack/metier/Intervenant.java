package com.SpringBoot.loncotoBack.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"interventions"})
@Entity
public class Intervenant {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String specialite;
	private int telephone;
	private int cvId;
	
	@JsonIgnore @OneToMany(mappedBy="intervenant")private Set<Intervention> interventions;

	public Intervenant(int id, String nom, String prenom, String mail, String specialite, int telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.specialite = specialite;
		this.telephone = telephone;
	}
	
	
	
	

}
