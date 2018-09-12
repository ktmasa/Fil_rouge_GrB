package com.SpringBoot.loncotoBack.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.SpringBoot.loncotoBack.metier.Client;

@RestResource
public interface IClientRepository extends PagingAndSortingRepository<Client, Integer> {
	
	public Page<Client> findByEntreprise(String entreprise, Pageable pr);
	
	public Page<Client> findBySiret(String siret, Pageable pr);
	
	public List<Client> findByMail(String mail);
	

}
