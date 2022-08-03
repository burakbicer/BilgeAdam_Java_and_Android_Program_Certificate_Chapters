package com.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.entities.Kisi;

public class KisiDAO implements IBaseDao<Kisi> {

	EntityManagerFactory emf;
	EntityManager em;
	
	
	
	
	@Override
	public void create(Kisi entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Kisi read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Kisi entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Kisi entity) {
		// TODO Auto-generated method stub

	}

}
