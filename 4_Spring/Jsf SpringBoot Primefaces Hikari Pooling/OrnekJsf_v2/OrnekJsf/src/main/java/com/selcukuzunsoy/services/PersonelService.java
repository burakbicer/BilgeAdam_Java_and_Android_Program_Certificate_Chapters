package com.selcukuzunsoy.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.selcukuzunsoy.daos.PersonelRepository;
import com.selcukuzunsoy.models.Personel;

@Service
@Transactional
public class PersonelService {

	@Autowired
	PersonelRepository personelRepository;

	public void kaydet(Personel personel) {
		personelRepository.save(personel);
	}

	public List<Personel> personelleriVer(String ad) {

		return personelRepository.findByAdReturnStream(ad).collect(Collectors.toList());

	}

	public List<Personel> personelleriVer(){
		Iterable<Personel> ite = personelRepository.findAll();
		List<Personel> hedef = new ArrayList<>();
		ite.forEach(hedef::add);
		return hedef;
	}
	
	
}
