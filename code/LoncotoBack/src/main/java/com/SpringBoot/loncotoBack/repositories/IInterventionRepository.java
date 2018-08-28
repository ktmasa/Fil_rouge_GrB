package com.SpringBoot.loncotoBack.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.SpringBoot.loncotoBack.metier.Client;
import com.SpringBoot.loncotoBack.metier.Intervention;

@RestResource
public interface IInterventionRepository extends PagingAndSortingRepository<Intervention, Integer> {

	List<Intervention> findFromClient(int id);
}
