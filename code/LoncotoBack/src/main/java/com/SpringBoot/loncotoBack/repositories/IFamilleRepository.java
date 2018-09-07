package com.SpringBoot.loncotoBack.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBoot.loncotoBack.metier.Famille;

public interface IFamilleRepository extends PagingAndSortingRepository<Famille, Integer> {

}
