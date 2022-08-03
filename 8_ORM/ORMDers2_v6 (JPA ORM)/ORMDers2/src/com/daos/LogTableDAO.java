package com.daos;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.LogTable;

public class LogTableDAO implements IBaseDao<LogTable> {

	EntityManagerFactory emf;
	EntityManager em;
	
	public LogTableDAO() {
		// TODO Auto-generated constructor stub
	emf = Persistence.createEntityManagerFactory("ORMDers2");
	em = emf.createEntityManager();
	}

	@Override
	public void create(LogTable entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {

			em.getTransaction().rollback();
			System.out.println("Hata Oluþtu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}
	}

	@Override
	public LogTable read(Long id) {
		try {
			LogTable adres = em.find(LogTable.class, id);
			return adres;
		} catch (Exception e) {
			System.out.println("Hata Oluþtu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	@Override
	public void update(LogTable entity) {
		// TODO Auto-generated method stub

		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {

			em.getTransaction().rollback();
			System.out.println("Hata Oluþtu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}
	}

	@Override
	public void delete(LogTable entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			if (!em.contains(entity))
				entity = em.merge(entity);
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {

			em.getTransaction().rollback();
			System.out.println("Hata Oluþtu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}

	}

	@Override
	public void deleteSoft(LogTable entity) {
		// TODO Auto-generated method stub

		try {
			em.getTransaction().begin();
			entity.setSilindi(true);
			entity.setDeletedDate(Calendar.getInstance());
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {

			em.getTransaction().rollback();
			System.out.println("Hata Oluþtu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}
	}

}
