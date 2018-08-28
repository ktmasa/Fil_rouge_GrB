package com.SpringBoot.loncotoBack.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"sousFamilles"})
@Entity
public class Famille {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@OneToMany(mappedBy="famille") private Set<SousFamille> sousFamilles;
	
	public Famille(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	
	

}
