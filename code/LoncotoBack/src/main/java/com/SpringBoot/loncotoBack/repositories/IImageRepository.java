package com.SpringBoot.loncotoBack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.SpringBoot.loncotoBack.metier.Image;

public interface IImageRepository extends PagingAndSortingRepository<Image, Long> {

	@Query("select i.id from Image i where i.intervention.id = :id")
	List<Image> findByIntervention(@Param("id") int id);
	

}
