package com.SpringBoot.loncotoBack.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.SpringBoot.loncotoBack.metier.Intervention;


public interface IInterventionRepository extends PagingAndSortingRepository<Intervention, Integer> {

	
	//etant donnee une id materiel, renvoie la liste des intervention du materiel (sachant qu'un materiel appartient a un unique client)
	@Query("select i from Intervention i where i.materiel.id = :idmat")
	Page<Intervention> findInterventionByMateriel(@Param("idmat") int id,Pageable pr);
	
	
	//renvoie la liste des interventions de l'intervenant
	Page<Intervention> findByIntervenant_Id(int id, Pageable pr);
	
	/*
	//etant donnée un client number et un site renvoie la liste des interventions du client dans le site (sachant que un site peut avoir plusieurs
	//client, il nous faut l'id du client afin de pouvoir recuperer les intervention du client cible ). ----->NOT WORK
	@Query("select i from Intervention i where i.materiel.salle.etage.batiment.site.id = :idsite and i.materiel.client.id = :idclient")
	Page<Intervention> findInterventionByClientSite(@Param("idsite") int idsite, @Param("idclient") int idclient,Pageable pr);
	*/
	
	//etant donnee un client renvoie la liste des clients
	@Query("select i from Intervention i where i.materiel.client.id = :idclient")
	Page<Intervention> findInterventionByClient(@Param("idclient") int idclient,Pageable pr);
	
	
	// ***************************************************************************************
	// GLOBAL DATE
	// ***************************************************************************************
	
	//renvoie liste des intervention order par date.
	Page<Intervention> findAllByOrderByDateRealisation(Pageable pr);
	
	//liste des interventions d'une date de realisation donnée.
	Page<Intervention> findByDateRealisation(LocalDate date,Pageable pr);
	
	//liste des intervention entre 2 dates données.
	Page<Intervention> findByDateRealisationBetween(LocalDate dateStart,LocalDate dateEnd,Pageable pr);
	
	
	// ***************************************************************************************
	// OPERATEUR DATE
	// ***************************************************************************************
	
	@Query("select i from Intervention i where i.dateRealisation <= :dateRealisation")
    Page<Intervention> findAllWithFixedDateTimeBefore(@Param("dateRealisation") LocalDate dateRealisation,Pageable pr);
	
	@Query("select i from Intervention i where i.dateRealisation >= :dateRealisation")
    Page<Intervention> findAllWithFixedDateTimeAfter(@Param("dateRealisation") LocalDate dateRealisation,Pageable pr);
	
	
	// ***************************************************************************************
	// INTERVENANT DATE
	// ***************************************************************************************
	
	
	//intervenant -> liste des intervention effectuée, non effectué et d'une date fixe et order by date et between
	
	@Query("select i from Intervention i where i.dateRealisation <= :creationDateTime and i.intervenant.id = :interId ORDER BY i.dateRealisation")
	Page<Intervention> findWithFixedDateBeforeOfIntervenant(@Param("creationDateTime") LocalDate creationDateTime, @Param("interId")  int interId,Pageable pr);
	
	@Query("select i from Intervention i where i.dateRealisation >= :creationDateTime and i.intervenant.id = :interId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithFixedDateAfterOfIntervenant(@Param("creationDateTime") LocalDate creationDateTime, @Param("interId")  int interId,Pageable pr);
	
	@Query("select i from Intervention i where i.dateRealisation = :creationDateTime and i.intervenant.id = :interId")
	Page<Intervention> findAllWithFixedDateOfIntervenant(@Param("creationDateTime") LocalDate creationDateTime, @Param("interId")  int interId,Pageable pr);
	
	@Query("select i from Intervention i where i.dateRealisation >= :startDateTime and i.dateRealisation <= :endDateTime and i.intervenant.id = :interId ORDER BY i.dateRealisation")
	Page<Intervention> findAllBetweendDateOfIntervenant(@Param("startDateTime") LocalDate startDateTime, @Param("endDateTime") LocalDate  endDateTime, @Param("interId")  int interId,Pageable pr);
	
	@Query("select i from Intervention i where i.intervenant.id = :interId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithIntervenantOrder(@Param("interId")  int interId,Pageable pr);
	
	// ***************************************************************************************
	//CLIENT DATE
	// ***************************************************************************************
	
	//client -> liste des intervention effectuée, non effectué et d'une date fixe et between
	@Query("select i from Intervention as i where i.dateRealisation <= :creationDateTime and i.materiel.client.id = :clientId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithFixedDateBeforeOfClient(@Param("creationDateTime") LocalDate creationDateTime, @Param("clientId")  int clientId,Pageable pr);
	
	@Query("select i from Intervention as i where i.dateRealisation >= :creationDateTime and i.materiel.client.id = :clientId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithFixedDateAfterOfClient(@Param("creationDateTime") LocalDate creationDateTime, @Param("clientId")  int clientId,Pageable pr);
	
	@Query("select i from Intervention as i where i.dateRealisation = :creationDateTime and i.materiel.client.id = :clientId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithFixedDateOfClient(@Param("creationDateTime") LocalDate creationDateTime, @Param("clientId")  int clientId,Pageable pr);
	
	@Query("select i from Intervention as i where i.dateRealisation >= :startDateTime and i.dateRealisation <= :endDateTime and i.materiel.client.id = :clientId ORDER BY i.dateRealisation")
	Page<Intervention> findAllBetweenDateOfClient(@Param("startDateTime") LocalDate startDateTime, @Param("endDateTime") LocalDate  endDateTime, @Param("clientId")  int clientId,Pageable pr);
	
	@Query("select i from Intervention as i where i.materiel.client.id = :clientId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithClientOrder(@Param("clientId")  int clientId,Pageable pr);
	
}
