package com.SpringBoot.loncotoBack.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.SpringBoot.loncotoBack.repositories.IBatimentRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @Getter @Setter @ToString(exclude = {"etages","site"})
@Entity
public class Batiment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToOne private Site site;
	@OneToMany(mappedBy ="batiment") private Set<Etage> etages;
	public Batiment(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	
	

}
