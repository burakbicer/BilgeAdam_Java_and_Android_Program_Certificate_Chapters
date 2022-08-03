package com.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.entities.Egitim;

public class EgitimDAO implements IBaseDao<Egitim> {

	EntityManagerFactory emf;
	EntityManager em;

	public EgitimDAO() {

		emf = Persistence.createEntityManagerFactory("ORMDers2");
		em = emf.createEntityManager();

	}

	@Override
	public void create(Egitim entity) {
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
	public Egitim read(Long id) {
		try {
			Egitim egitim = em.find(Egitim.class, id);
			return egitim;
		} catch (Exception e) {
			System.out.println("Hata Oluþtu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	@Override
	public void update(Egitim entity) {

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
	public void delete(Egitim entity) {

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
