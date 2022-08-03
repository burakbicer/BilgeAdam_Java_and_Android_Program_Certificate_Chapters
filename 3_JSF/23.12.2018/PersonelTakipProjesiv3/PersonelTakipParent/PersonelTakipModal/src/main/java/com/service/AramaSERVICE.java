package com.service;

import java.util.List;

import com.daos.AramaDAO;
import com.models.AramaBilgileri;
import com.models.Personel;

public class AramaSERVICE {

	public List<Personel> ara(AramaBilgileri aramaBilgileri) {

		return new AramaDAO().ara(aramaBilgileri);

	}

}
