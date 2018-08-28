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

@Getter @Setter @NoArgsConstructor @ToString(exclude = {"interventions","salle","client","article"})
@Entity
public class Materiel {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String serialNumber;
	@ManyToOne private Salle salle;
	@ManyToOne private Client client;
	@ManyToOne private Article article;
	@JsonIgnore @OneToMany(mappedBy="materiel") private Set<Intervention> interventions;
	
	public Materiel(int id, String serialNumber) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
	}

	
}
