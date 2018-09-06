package com.SpringBoot.loncotoBack.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @ToString(exclude = {"materiels","sousFamille"})
@Entity
public class Article {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String description;
	private String ficheTechnique;
	@ManyToOne private SousFamille sousFamille;
	@JsonIgnore @OneToMany(mappedBy="article") private Set<Materiel> materiels;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFicheTechnique() {
		return ficheTechnique;
	}
	public void setFicheTechnique(String ficheTechnique) {
		this.ficheTechnique = ficheTechnique;
	}
	public SousFamille getSousFamille() {
		return sousFamille;
	}
	public void setSousFamille(SousFamille sousFamille) {
		this.sousFamille = sousFamille;
	}
	public Set<Materiel> getMateriels() {
		return materiels;
	}
	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}
	
	
}
