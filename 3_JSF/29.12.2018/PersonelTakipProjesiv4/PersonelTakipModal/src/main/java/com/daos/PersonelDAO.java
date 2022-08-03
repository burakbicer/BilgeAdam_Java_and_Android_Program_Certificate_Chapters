package com.daos;

import java.util.List;

import javax.persistence.Query;

import com.models.Personel;

public class PersonelDAO extends BaseDAO<Personel>  {

	@Override
	public void create(Personel entity) throws PersonelTakipHata  {
		try {
			getEm().getTransaction().begin();			
			if(!getEm().contains(entity)) 
				getEm().merge(entity);			
			getEm().persist(entity);
			getEm().flush();
			getEm().clear();
			getEm().getTransaction().commit();			
		} catch (Exception e) {
			getEm().getTransaction().rollback();
			throw new PersonelTakipHata("Personel Kayýt Edilemedi");
		} finally {
			if(getEm().isOpen()) getEm().close();
		}
	}

	@Override
	public Personel read(Long id)  throws PersonelTakipHata {
		try {
			return getEm().find(Personel.class, id);
		} catch (Exception e) {
			throw new PersonelTakipHata("Personel Alýnamadý");
		} 
	}

	@Override
	public void update(Personel entity) throws PersonelTakipHata {
		try {
			getEm().getTransaction().begin();
			getEm().merge(entity);
			getEm().flush();
			getEm().clear();
			getEm().getTransaction().commit();			
		} catch (Exception e) {
			getEm().getTransaction().rollback();
			throw new PersonelTakipHata("Personel Güncellenemedi");
		} finally {
			if(getEm().isOpen()) getEm().close();
		}
	}

	@Override
	public void delete(Personel entity) throws PersonelTakipHata {
		try {
			getEm().getTransaction().begin();
			if(!getEm().contains(entity)) entity=getEm().merge(entity);
			getEm().remove(entity);
			getEm().flush();
			getEm().clear();
			getEm().getTransaction().commit();			
		} catch (Exception e) {
			getEm().getTransaction().rollback();
			throw new PersonelTakipHata("Personel Silinemedi");
		} finally {
			if(getEm().isOpen()) getEm().close();
		}
	}

	public List<Personel> personelListesiniGetir() throws PersonelTakipHata {
		try {
			 Query q = getEm().createQuery("SELECT P FROM Personel P ORDER BY P.id DESC");
			 return q.getResultList();
		} catch (Exception e) {
			throw new PersonelTakipHata("Personel Alýnamadý");
		} finally {
			if(getEm().isOpen()) getEm().close();
		} 
	}

}
