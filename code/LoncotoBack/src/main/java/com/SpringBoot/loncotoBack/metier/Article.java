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

@Setter @Getter @NoArgsConstructor @ToString(exclude = {"materiels","sousFamille"})
@Entity
public class Article {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String description;
	private String ficheTechnique;
	@ManyToOne private SousFamille sousFamille;
	@OneToMany(mappedBy="materiel") private Set<Materiel> materiels;
	
}
