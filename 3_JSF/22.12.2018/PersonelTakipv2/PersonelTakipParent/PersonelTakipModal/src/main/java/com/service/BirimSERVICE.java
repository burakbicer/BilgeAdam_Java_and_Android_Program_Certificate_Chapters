package com.service;

import java.util.List;

import com.daos.BirimDAO;
import com.daos.PersonelDAO;
import com.daos.PersonelTakipHata;
import com.models.Birim;
import com.models.Personel;

public class BirimSERVICE implements IBaseService<Birim> {

	@Override
	public void create(Birim entity) throws PersonelTakipHata {
		new BirimDAO().create(entity);
	}

	@Override
	public Birim read(Long id) throws PersonelTakipHata {
		return new BirimDAO().read(id);
	}

	@Override
	public void update(Birim entity) throws PersonelTakipHata {
		new BirimDAO().update(entity);
	}

	@Override
	public void delete(Birim entity) throws PersonelTakipHata {
		new BirimDAO().delete(entity);
	}

	public List<Birim> birimListesiGetir() throws PersonelTakipHata {		
		return new BirimDAO().birimListesiniGetir();
	}

}
