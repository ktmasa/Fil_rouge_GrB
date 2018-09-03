package com.SpringBoot.loncotoBack.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBoot.loncotoBack.metier.Intervenant;

public interface IIntervenantRepository extends PagingAndSortingRepository<Intervenant, Integer> {

}
