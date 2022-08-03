package com.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.models.BaseEntity;

public abstract class BaseDAO<T extends BaseEntity> {

	private EntityManagerFactory emf;
	private EntityManager em;

	public BaseDAO() {
		emf = Persistence.createEntityManagerFactory("PersonelTakipModal");
		em = emf.createEntityManager();
	}

	public abstract void create(T entity) throws PersonelTakipHata;

	public abstract T read(Long id) throws PersonelTakipHata;

	public abstract void update(T entity) throws PersonelTakipHata;

	public abstract void delete(T entity) throws PersonelTakipHata;

	public EntityManager getEm() {
		return em;
	}

}
