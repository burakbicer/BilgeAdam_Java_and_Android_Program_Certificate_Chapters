package com.service;

import java.util.List;

import com.daos.PersonelDAO;
import com.daos.PersonelTakipHata;
import com.models.Personel;

public class PersonelSERVICE implements IBaseService<Personel> {

	@Override
	public void create(Personel entity) throws PersonelTakipHata {
		new PersonelDAO().create(entity);
	}

	@Override
	public Personel read(Long id) throws PersonelTakipHata {
		return new PersonelDAO().read(id);
	}

	@Override
	public void update(Personel entity) throws PersonelTakipHata {
		new PersonelDAO().update(entity);
	}

	@Override
	public void delete(Personel entity) throws PersonelTakipHata {
		new PersonelDAO().delete(entity);
	}

	public List<Personel> personelListesiGetir() throws PersonelTakipHata {		
		return new PersonelDAO().personelListesiniGetir();
	}

}
