package com.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.internal.jpa.metadata.sequencing.GeneratedValueMetadata;

import com.models.Tumuni;

public class TumUniDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public TumUniDAO() {
		emf = Persistence.createEntityManagerFactory("PersonelTakipModal");
		em = emf.createEntityManager();

	}

	public List<Tumuni> universiteleriGetir() {

		try {
			return em.createQuery("SELECT TU FROM Tumuni TU").getResultList();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	public  Tumuni  universiteGetir(Long id) {

		try {
			Query q = em.createQuery("SELECT TU FROM Tumuni TU WHERE TU.ID =:TID");
			q.setParameter("TID", id);
			List<Tumuni> sonuc = q.getResultList();
			return sonuc.isEmpty() ? null : sonuc.get(0);
		
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

		
	
	
	
	
}
