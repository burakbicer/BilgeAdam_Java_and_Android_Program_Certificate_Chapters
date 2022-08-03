package com.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.models.AramaBilgileri;
import com.models.Personel;

public class AramaDAO {

	private EntityManager em;
	private EntityManagerFactory emf;

	public AramaDAO() {
		emf = Persistence.createEntityManagerFactory("PersonelTakipModal");
		em = emf.createEntityManager();
	}

	public List<Personel> ara(AramaBilgileri aramaBilgileri) {
		try {			
			StringBuilder sorgu = 
					new StringBuilder("SELECT P FROM Personel P WHERE 1=1 ");			
			if(!aramaBilgileri.getAd().isEmpty()) {
				sorgu.append(" and P.ad=:pad");				 
			}			
			if(!aramaBilgileri.getSoyad().isEmpty()) {
				sorgu.append(" and P.soyad =:psoyad");	 			
		    }						
			if(aramaBilgileri.getTc()!= null) {
				sorgu.append(" and P.tc=:ptc");				 
			}
			Query q = em.createQuery(sorgu.toString());
			System.out.println("Sorgu:"+sorgu.toString());
			if(!aramaBilgileri.getAd().isEmpty()) {
				q.setParameter("pad", aramaBilgileri.getAd());
			}			
			if(!aramaBilgileri.getSoyad().isEmpty()) {
				q.setParameter("psoyad", aramaBilgileri.getSoyad());			
			}						
			if(aramaBilgileri.getTc()!= null) {
				q.setParameter("ptc", aramaBilgileri.getTc());
			}			
			List<Personel> sonuclar = q.getResultList();		
			
			return sonuclar;
			
/*
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Personel> c = cb.createQuery(Personel.class);
			Root<Personel> cr = c.from(Personel.class);
			
			ParameterExpression<String> ad = cb.parameter(String.class);
			ParameterExpression<String> soyad = cb.parameter(String.class);
			ParameterExpression<Integer> tc = cb.parameter(Integer.class);

			c.where(cb.like(cr.get("ad"), ad), 
					cb.like(cr.get("soyad"), soyad), 
					cb.equal(cr.get("tc"), tc));
			
			c.select(cr);
			
			TypedQuery<Personel> que = em.createQuery(c);
			
			if(!aramaBilgileri.getAd().isEmpty()) {
				que.setParameter("ad", aramaBilgileri.getAd());
			}
			
			if(!aramaBilgileri.getSoyad().isEmpty()) {
				que.setParameter("soyad", aramaBilgileri.getSoyad());			
						}
						
			if(aramaBilgileri.getTc()!= null) {
				que.setParameter("tc", aramaBilgileri.getTc());
			}

			List<Personel> sonuclar = que.getResultList();		
					
			return sonuclar;
			*/
			
			// JPQL
			// "SELECT P FROM Personel P WHERE P.ad=:pad and P.soyad =:psoyad and P.tc
			// =:ptc";

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (em.isOpen())
				em.close();
		}

		return null;

	}

}
