package com.SpringBoot.loncotoBack.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.jpa.criteria.compile.CriteriaQueryTypeQueryAdapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBoot.loncotoBack.metier.Client;
import com.SpringBoot.loncotoBack.metier.Intervention;
import com.SpringBoot.loncotoBack.metier.Materiel;

public class InterventionRepository implements IInterventionRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public List<Intervention> findFromClient(int clientid) {
		TypedQuery<Materiel> q1 = em.createQuery("select m from Materiel m  where m.client.id = :id ",Materiel.class);
		q1.setParameter("id", clientid);
		List<Materiel> materiels = q1.getResultList();
		List<Intervention> interventions = new ArrayList<Intervention>();
		for(Materiel m : materiels) {
			interventions.addAll(m.getInterventions());
		}
		return interventions;
	}
	
	

	@Override
	public Iterable<Intervention> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Intervention> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Intervention arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Intervention> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Intervention> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Intervention> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Intervention findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Intervention> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Intervention> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
