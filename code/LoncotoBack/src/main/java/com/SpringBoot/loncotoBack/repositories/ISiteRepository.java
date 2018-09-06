package com.SpringBoot.loncotoBack.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.SpringBoot.loncotoBack.metier.Site;

public interface ISiteRepository extends PagingAndSortingRepository<Site, Integer> {

	@Query("select c.sites from Client as c where c.id = :id")
	public Page<Site> findSiteByClientId(@Param("id") int id, Pageable pr);
	
	
	
}
