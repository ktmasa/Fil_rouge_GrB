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

@NoArgsConstructor @ToString(exclude = {"materiel","intervenant","images"})
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDatePlanification() {
		return datePlanification;
	}

	public void setDatePlanification(LocalDate datePlanification) {
		this.datePlanification = datePlanification;
	}

	public LocalDate getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(LocalDate dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommentaireIntervenant() {
		return commentaireIntervenant;
	}

	public void setCommentaireIntervenant(String commentaireIntervenant) {
		this.commentaireIntervenant = commentaireIntervenant;
	}

	public String getDescriptionPanne() {
		return descriptionPanne;
	}

	public void setDescriptionPanne(String descriptionPanne) {
		this.descriptionPanne = descriptionPanne;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public Intervenant getIntervenant() {
		return intervenant;
	}

	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}
	
	
	

}
