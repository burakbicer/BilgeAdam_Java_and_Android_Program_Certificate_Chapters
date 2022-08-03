package com.daos;

import java.util.List;

import javax.persistence.Query;

import com.models.Birim;

public class BirimDAO extends BaseDAO<Birim> {

	@Override
	public void create(Birim entity) throws PersonelTakipHata {
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
			throw new PersonelTakipHata("Birim Kayýt Edilemedi");
		} finally {
			if(getEm().isOpen()) getEm().close();
		}

	}

	@Override
	public Birim read(Long id) throws PersonelTakipHata {
		try {
			return getEm().find(Birim.class, id);
		} catch (Exception e) {
			throw new PersonelTakipHata("Birim Alýnamadý");
		}
	}

	@Override
	public void update(Birim entity) throws PersonelTakipHata {
		try {
			getEm().getTransaction().begin();
			getEm().merge(entity);
			getEm().flush();
			getEm().clear();
			getEm().getTransaction().commit();			
		} catch (Exception e) {
			getEm().getTransaction().rollback();
			throw new PersonelTakipHata("Birim Güncellenemedi");
		} finally {
			if(getEm().isOpen()) getEm().close();
		}
	}

	@Override
	public void delete(Birim entity) throws PersonelTakipHata {
		try {
			getEm().getTransaction().begin();
			getEm().remove(entity);
			getEm().flush();
			getEm().clear();
			getEm().getTransaction().commit();			
		} catch (Exception e) {
			getEm().getTransaction().rollback();
			throw new PersonelTakipHata("Birim Silinemedi");
		} finally {
			if(getEm().isOpen()) getEm().close();
		}
	}

	public List<Birim> birimListesiniGetir() throws PersonelTakipHata {
			try {
				 Query q = getEm().createQuery("SELECT B FROM Birim B ORDER BY B.id DESC");
				 return q.getResultList();
			} catch (Exception e) {
				throw new PersonelTakipHata("Birim Alýnamadý");
			} finally {
				if(getEm().isOpen()) getEm().close();
			} 
		}

}
