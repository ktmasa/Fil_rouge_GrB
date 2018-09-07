package com.SpringBoot.loncotoBack.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.SpringBoot.loncotoBack.metier.Intervenant;


public interface IIntervenantRepository extends PagingAndSortingRepository<Intervenant, Integer> {
	
	//liste des intervenants disponibles une date donnée 
	@Query("select i.intervenant from Intervention i where i.dateRealisation<> :date and i.intervenant.specialite = :spe")
	Page<Intervenant> findWithFixedDateDispoIntervenant(@Param("spe") String spe,@Param("date") LocalDate creationDateTime,Pageable pr);
	
	/*
	//liste des intervenants disponibles entre 2 dates -> ne marche pas
	@Query("select emp from Intervenant emp where emp.specialite = :spe and emp.interventions.id NOT IN(select i.id from Intervention where i.dateRealisation Between :startDate and :endDate)")
	Page<Intervention> findBetweenDateDispoIntervenant(@Param("endDate") LocalDate endDateTime,@Param("startDate") LocalDate startDateTime, @Param("spe") String spe, @Param("interId")  int interId,Pageable pr);
    */
	
}
