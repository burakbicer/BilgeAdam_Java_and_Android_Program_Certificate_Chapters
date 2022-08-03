package com.tools;

import java.util.Calendar;
import java.util.List;

import com.daos.KisiDAO;
import com.entities.Adres;
import com.entities.Egitim;
import com.entities.Kisi;
import com.enums.ADRESTIP;

public class Yonet {

	
	public static void main(String[] args) {
		
		Kisi kisi = new Kisi();
		kisi.setAd("Selçuk");
		kisi.setSoyad("Uzunsoy");
		kisi.setTc("134632");		
		//new KisiDAO().create(kisi);
		
		Adres adres = new Adres();
		adres.setAcikAdres("Ankara");
		adres.setAdresTip(ADRESTIP.EV);
		adres.setEmail("uzunsoy55@yandex.com");
		kisi.getAdresBilgileri().add(adres);
		
		Egitim egitim = new Egitim();
		egitim.setBolum("BM");
		egitim.setGirisTarihi(Calendar.getInstance());
		egitim.setMezun(false);
		egitim.setOkulAdi("GÜ");
		
		kisi.getEgitimListesi().add(egitim);
		
		new KisiDAO().create(kisi);
		/*
		Kisi kisim = new KisiDAO().read(2L); 
		@SuppressWarnings("unused")
		List<Adres> adresList = kisim.getAdresBilgileri();
		System.out.println("Kiþi:"+kisim);
		*/
		//Kisi kisim = new KisiDAO().readFind(1L);
		//System.out.println("Kisim:"+kisi.getAd());
		
		//kisim.setAd("Mr.Selçuk");
		//new KisiDAO().update(kisim);
		
		//new KisiDAO().delete(kisim);
	/*
		Adres adres = new Adres();
		adres.setAcikAdres("Ankara");
		adres.setAdresTip(ADRESTIP.EV);
		adres.setEmail("uzunsoy@yandex.com");
		*/
		//new AdresDAO(); //.create(adres);
	
	
	
	
	
	}
	
	
}
