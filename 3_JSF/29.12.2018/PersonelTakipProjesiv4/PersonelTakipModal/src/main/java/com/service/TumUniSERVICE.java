package com.service;

import java.util.List;

import com.daos.TumUniDAO;
import com.models.Tumuni;

public class TumUniSERVICE {

	public List<Tumuni> universiteleriGetir() {
		return new TumUniDAO().universiteleriGetir();
	}

	public Tumuni universiteGetir(Long id) {
		return new TumUniDAO().universiteGetir(id);
	}

}
