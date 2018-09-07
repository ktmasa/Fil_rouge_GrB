package com.SpringBoot.loncotoBack.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBoot.loncotoBack.metier.Batiment;

public interface IBatimentRepository extends PagingAndSortingRepository<Batiment, Integer> {

}