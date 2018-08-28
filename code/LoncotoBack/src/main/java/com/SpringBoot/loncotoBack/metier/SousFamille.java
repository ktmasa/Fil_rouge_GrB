package com.SpringBoot.loncotoBack.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"famille","articles"})
@Entity
public class SousFamille {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@ManyToOne private Famille famille;
	@OneToMany(mappedBy = "sousFamille")private Set<Article> articles;
	
	public SousFamille(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	

}
