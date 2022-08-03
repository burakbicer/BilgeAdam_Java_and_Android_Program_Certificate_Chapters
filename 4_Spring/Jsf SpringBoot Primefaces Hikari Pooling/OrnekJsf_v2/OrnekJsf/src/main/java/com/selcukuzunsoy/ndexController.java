package com.selcukuzunsoy;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.selcukuzunsoy.models.Personel;
import com.selcukuzunsoy.services.PersonelService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@Scope(value = "session")
@Controller(value = "ndexController")
public class ndexController {

	@Getter
	@Setter
	private Personel personel;

	@Autowired
	BaseController baseController;

	@Autowired
	PersonelService personelService;

	@Getter
	private List<Personel> personelListesi = new ArrayList<>();

	@PostConstruct
	private void init() {
		personel = new Personel();
		personelleriListele();
	}

	public void kaydet() {
		try {
			personelService.kaydet(personel);
			personel = new Personel();
			personelleriListele();
			baseController.mesajVer("İşlem Başarılı", TIP.BILGI);
		} catch (Exception e) {
			baseController.mesajVer("İşlem Yapılamadı", TIP.HATA);
		}
	}

	public void personelleriListele() {
		personelListesi = personelService.personelleriVer();
	}

}