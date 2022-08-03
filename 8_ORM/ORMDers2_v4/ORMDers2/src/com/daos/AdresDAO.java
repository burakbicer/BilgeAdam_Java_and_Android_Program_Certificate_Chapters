package com.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Adres;

public class AdresDAO implements IBaseDao<Adres> {

	EntityManagerFactory emf;
	EntityManager em;

	public AdresDAO() {

		emf = Persistence.createEntityManagerFactory("ORMDers2");
		em = emf.createEntityManager();

	}

	@Override
	public void create(Adres entity) {

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
	public Adres read(Long id) {
		try {
			Adres adres = em.find(Adres.class, id);
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
	public void update(Adres entity) {

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
	public void delete(Adres entity) {
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

}
