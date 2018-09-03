package com.SpringBoot.loncotoBack.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBoot.loncotoBack.metier.Image;

public interface IImageRepository extends PagingAndSortingRepository<Image, Long> {

	List<Image> findByIntervention_Id(int id);
	

}
