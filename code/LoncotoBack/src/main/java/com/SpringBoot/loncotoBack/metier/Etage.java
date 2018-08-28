package com.SpringBoot.loncotoBack.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.SpringBoot.loncotoBack.repositories.IBatimentRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString(exclude={"batiment","salles"})
@Entity
public class Etage {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int numero;
	
	@ManyToOne private IBatimentRepository batiment;
	@JsonIgnore @OneToMany(mappedBy = "etage")private Set<Salle> salles;
	
	public Etage(int id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
	}
	
	
	
}
