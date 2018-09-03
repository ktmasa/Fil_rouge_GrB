package com.SpringBoot.loncotoBack.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.SpringBoot.loncotoBack.metier.Materiel;

@RestResource
public interface IMaterielRepository extends PagingAndSortingRepository<Materiel, Integer> {
	
	public Page<Materiel> findByClient_Id(int id, Pageable pr);
	

}
