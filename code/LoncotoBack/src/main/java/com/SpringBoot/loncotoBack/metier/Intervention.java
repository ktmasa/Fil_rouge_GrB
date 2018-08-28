package com.SpringBoot.loncotoBack.metier;

import java.time.LocalDate;
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

@Setter @Getter @NoArgsConstructor @ToString(exclude = {"materiel","intervenant","images"})
@Entity
public class Intervention {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate datePlanification;
	private LocalDate dateRealisation;
	private String status;
	private String 	commentaireIntervenant;
	private String descriptionPanne;
	
	@ManyToOne private Materiel materiel;
	@ManyToOne private Intervenant intervenant;
	@JsonIgnore @OneToMany(mappedBy ="intervention") private Set<Image> images;
	
	public Intervention(int id, LocalDate datePlanification, LocalDate dateRealisation, String status,
			String commentaireIntervenant, String descriptionPanne) {
		super();
		this.id = id;
		this.datePlanification = datePlanification;
		this.dateRealisation = dateRealisation;
		this.status = status;
		this.commentaireIntervenant = commentaireIntervenant;
		this.descriptionPanne = descriptionPanne;
	}
	
	
	

}
