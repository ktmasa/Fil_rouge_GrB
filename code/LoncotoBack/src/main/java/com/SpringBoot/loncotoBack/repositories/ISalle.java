package com.SpringBoot.loncotoBack.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBoot.loncotoBack.metier.Salle;

public interface ISalle extends PagingAndSortingRepository<Salle, Integer> {

}
