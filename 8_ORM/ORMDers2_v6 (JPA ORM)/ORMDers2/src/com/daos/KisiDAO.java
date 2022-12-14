package com.daos;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entities.Kisi;

public class KisiDAO implements IBaseDao<Kisi> {

	private EntityManagerFactory emf;
	private EntityManager em;

	public KisiDAO() {
		emf = Persistence.createEntityManagerFactory("ORMDers2");
		em = emf.createEntityManager();

	}

	@Override
	public void create(Kisi entity) {

		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {

			em.getTransaction().rollback();
			System.out.println("Hata Olu?tu !" + e.getMessage());
			throw e;
		} finally {
			if (em.isOpen())
				em.close();
		}

	}

	@Override
	public Kisi read(Long id) {

		try {

			em.getTransaction().begin();
			Query kisiler = em.createNamedQuery("Kisi.findById");
			kisiler.setParameter("kid", id);
			List<Kisi> kisilerListe = kisiler.getResultList();

			em.getTransaction().commit();

			if (!kisilerListe.isEmpty()) {
				return kisilerListe.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Hata Olu?tu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	public List<Kisi> kisileriGetir() {

		try {
			Query q = em.createNamedQuery("Kisi.findAllData");
			List<Kisi> liste = q.getResultList();
			return liste;

		} catch (Exception e) {
			System.out.println("??lem Ba?ar?s?z !");
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;

	}

	public Kisi readFind(Long id) {
		try {
			Kisi kisi = em.find(Kisi.class, id);
			return kisi;
		} catch (Exception e) {
			System.out.println("Hata Olu?tu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	@Override
	public void update(Kisi entity) {

		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {

			em.getTransaction().rollback();
			System.out.println("Hata Olu?tu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}

	}

	/**
	 * Hard-Delete: KES?NL?KLE YAPILMAZ
	 */
	@Override
	public void delete(Kisi entity) {

		try {
			em.getTransaction().begin();

			if (!em.contains(entity))
				entity = em.merge(entity);
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {

			em.getTransaction().rollback();
			System.out.println("Hata Olu?tu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}
	}

	public void deleteSoft(Kisi entity) {

		try {
			em.getTransaction().begin();
			entity.setSilindi(true);
			entity.setDeletedDate(Calendar.getInstance());
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {

			em.getTransaction().rollback();
			System.out.println("Hata Olu?tu !" + e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}

	}

}
