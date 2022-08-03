package com.selcukuzunsoy.restendpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selcukuzunsoy.models.Personel;
import com.selcukuzunsoy.services.PersonelService;

@RestController
@RequestMapping("/rest")
public class PersonelRestService {

	@Autowired
	PersonelService personelService;

	@GetMapping("/personel/list")
	public List<Personel> personelleriVer() {

		return personelService.personelleriVer();

	}

}
