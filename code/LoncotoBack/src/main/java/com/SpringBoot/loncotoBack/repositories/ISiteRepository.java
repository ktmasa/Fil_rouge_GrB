package com.SpringBoot.loncotoBack.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBoot.loncotoBack.metier.Site;

public interface ISiteRepository extends PagingAndSortingRepository<Site, Integer> {

	public Page<Site> findSiteByClients_Id(int id, Pageable pr);
	
	
	
}
