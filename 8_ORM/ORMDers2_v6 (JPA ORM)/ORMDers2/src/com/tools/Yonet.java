package com.tools;

import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import com.daos.KisiDAO;
import com.entities.Adres;
import com.entities.Egitim;
import com.entities.Kisi;
import com.entities.Meslek;
import com.enums.ADRESTIP;
import com.enums.ISTIP;

public class Yonet {

	
	public static void main(String[] args) {
		atla:{
		if(true) break atla;
		
		try {
		
		Kisi kisi = new Kisi();
		kisi.setAd("Selçuk");
		kisi.setSoyad("Uzunsoy");
		kisi.setTc("67856765");		
		//new KisiDAO().create(kisi);
		
		Adres adres = new Adres();
		adres.setAcikAdres("Ankara");
		adres.setAdresTip(ADRESTIP.EV);
		adres.setEmail("346346435@yandex.com");
		kisi.getAdresBilgileri().add(adres);
		
		Egitim egitim = new Egitim();
		egitim.setBolum("BM");
		egitim.setGirisTarihi(Calendar.getInstance());
		egitim.setMezun(false);
		egitim.setOkulAdi("GÜ");
		
		Meslek mes = new Meslek();
		mes.setFirmaAdi("TURKSAT");
		mes.setGorevTanimi("MIMAR");
		mes.setIsTip(ISTIP.FULL);
		mes.setPozisyonAdi("MIMAR");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 1, 10);
		mes.setGirisTarihi(cal);
		
		kisi.getIsListesi().add(mes);
		
		
		kisi.getEgitimListesi().add(egitim);
		JOptionPane.showMessageDialog(null, "Kiþi Kayýt Edildi :) ");
		
		new KisiDAO().create(kisi);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kiþi Kayýt Edilemedi !");
		}
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
	/*
	Kisi kisi = new Kisi();
	kisi.setAd("Selçuk");
	kisi.setSoyad("Uzunsoy");
	kisi.setTc("134632");		
	new KisiDAO().create(kisi);*/
	//Kisi kisi = new KisiDAO().read(1L);
	//new KisiDAO().deleteSoft(kisi);
	//new KisiDAO();
	 
	List<Kisi> veriler = new KisiDAO().kisileriGetir();
	System.out.println("Kiþiler:"+veriler);
	}
	
	
}
