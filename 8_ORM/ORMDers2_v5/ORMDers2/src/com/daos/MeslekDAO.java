package com.daos;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Meslek;

public class MeslekDAO implements IBaseDao<Meslek> {

	EntityManagerFactory emf;
	EntityManager em;

	public MeslekDAO() {
		// TODO Auto-generated constructor stub
		emf = Persistence.createEntityManagerFactory("ORMDers2");
		em = emf.createEntityManager();
	}

	@Override
	public void create(Meslek entity) {
		// TODO Auto-generated method stub

		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.flush();
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			if (em.isOpen())
				em.close();
		}

	}

	@Override
	public Meslek read(Long id) {
		// TODO Auto-generated method stub

		try {

			Meslek secilenMes = em.find(Meslek.class, id);
			return secilenMes;

		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
			System.out.println("Kullanýcý Bulunamadý " + id);
		} finally {
			if (em.isOpen())
				em.close();
		}

		return null;
	}

	@Override
	public void update(Meslek entity) {
		// TODO Auto-generated method stub

		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.flush();
			em.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Güncellenemedi !");
			throw e;
		} finally {
			if (em.isOpen())
				em.close();
		}

	}

	@Override
	public void delete(Meslek entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			if (!em.contains(entity))
				entity = em.merge(entity);
			em.remove(entity);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Silinemedi !");
			throw e;
		} finally {
			if (em.isOpen())
				em.close();
		}
	}

	@Override
	public void deleteSoft(Meslek entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			entity.setDeletedDate(Calendar.getInstance());
			entity.setSilindi(true);
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Silinemedi !");
			throw e;
		} finally {
			if (em.isOpen())
				em.close();
		}
	}
}
