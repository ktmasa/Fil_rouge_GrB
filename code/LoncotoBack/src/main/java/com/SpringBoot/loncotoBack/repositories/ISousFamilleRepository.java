package com.SpringBoot.loncotoBack.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBoot.loncotoBack.metier.SousFamille;

public interface ISousFamilleRepository extends PagingAndSortingRepository<SousFamille, Integer> {

}
