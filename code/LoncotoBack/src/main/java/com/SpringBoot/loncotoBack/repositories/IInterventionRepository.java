package com.SpringBoot.loncotoBack.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestBody;

import com.SpringBoot.loncotoBack.metier.Intervention;


public interface IInterventionRepository extends PagingAndSortingRepository<Intervention, Integer> {

	
	//etant donnee une id materiel, renvoie la liste des intervention du materiel (sachant qu'un matos appartient a un unique client)
	@Query("select i from Intervention i where i.materiel.id = :idmat")
	List<Intervention> findInterventionByMateriel(@Param("idmat") int id);
	
	//etant donnée un client number et un site renvoie la liste des interventions du client dans le site (sachant que un site peut avoir plusieurs
	//client, il nous faut l'id du client afin de pouvoir recuperer les intervention du client cible ).
	@Query("select i from Intervention i where i.materiel.salle.etage.batiment.site.id = :idsite and i.materiel.client.id = :idclient")
	List<Intervention> findInterventionBySite(@Param("idsite") int idsite, @Param("idclient") int idclient);
	
	//renvoie la liste des interventions de l'intervenant
	Page<Intervention> findByIntervenant_Id(int id, Pageable pr);
	
	//renvoie liste des intervention order par date 
	Page<Intervention> findAllByOrderByDateRealisation(Pageable pr);
	
	//liste des interventions d'une date de realisation donnée
	Page<Intervention> findByDateRealisation(LocalDate date,Pageable pr);
	
	//liste des intervention entre 2 dates données
	Page<Intervention> findAllDateRealisationBetween(LocalDate dateStart,LocalDate dateEnd,Pageable pr);
	
	//operateur
	
	@Query("select i from Intervention i where i.dateRealisation <= :dateRealisation")
    Page<Intervention> findAllWithFixedDateTimeBefore(@Param("dateRealisation") LocalDate dateRealisation);
	
	@Query("select i from Intervention i where i.dateRealisation >= :dateRealisation")
    Page<Intervention> findAllWithFixedDateTimeAfter(@Param("dateRealisation") LocalDate dateRealisation);
	
	//intervenant -> liste des intervention effectuée, non effectué et d'une date fixe et order by date
	
	@Query("select i from Intervention i where i.dateRealisation <= :creationDateTime and i.intervenant.id = :interId ORDER BY i.dateRealisation")
	Page<Intervention> findWithFixedDateBeforeOfIntervenant(@Param("creationDateTime") LocalDate creationDateTime, @Param("interId")  int interId,Pageable pr);
	
	@Query("select i from Intervention i where i.dateRealisation >= :creationDateTime and i.intervenant.id = :interId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithFixedDateAfterOfIntervenant(@Param("creationDateTime") LocalDate creationDateTime, @Param("interId")  int interId,Pageable pr);
	
	@Query("select i from Intervention i where i.dateRealisation = :creationDateTime and i.intervenant.id = :interId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithFixedDateOfIntervenant(@Param("creationDateTime") LocalDate creationDateTime, @Param("interId")  int interId,Pageable pr);
	
	@Query("select i from Intervention i where i.intervenant.id = :interId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithIntervenantOrder(@Param("interId")  int interId,Pageable pr);
	
	
	
	//client -> liste des intervention effectuée, non effectué et d'une date fixe 
	@Query("select i from Intervention as i join Materiel as mat join Client as c where i.dateRealisation <= :creationDateTime and mat.id = i.materiel.id and mat.client.id = :clientId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithFixedDateBeforeOfClient(@Param("creationDateTime") LocalDate creationDateTime, @Param("clientId")  int interId,Pageable pr);
	
	@Query("select i from Intervention as i join Materiel as mat join Client as c where i.dateRealisation >= :creationDateTime and mat.id = i.materiel.id and mat.client.id = :clientId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithFixedDateAfterOfClient(@Param("creationDateTime") LocalDate creationDateTime, @Param("clientId")  int interId,Pageable pr);
	
	@Query("select i from Intervention as i join Materiel as mat join Client as c where i.dateRealisation = :creationDateTime and mat.id = i.materiel.id and mat.client.id = :clientId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithFixedDateOfClient(@Param("creationDateTime") LocalDate creationDateTime, @Param("clientId")  int interId,Pageable pr);
	
	@Query("select i from Intervention as i join Materiel as mat join Client as c where mat.id = i.materiel.id and mat.client.id = :clientId ORDER BY i.dateRealisation")
	Page<Intervention> findAllWithClientOrder(@Param("clientId")  int interId,Pageable pr);
}
