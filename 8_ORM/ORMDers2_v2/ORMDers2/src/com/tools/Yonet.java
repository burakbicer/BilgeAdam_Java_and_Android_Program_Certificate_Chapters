package com.tools;

import com.daos.KisiDAO;
import com.entities.Kisi;

public class Yonet {

	
	public static void main(String[] args) {
		
		Kisi kisi = new Kisi();
		kisi.setAd("Sel�uk");
		kisi.setSoyad("Uzunsoy");
		kisi.setTc("458634875");		
		//new KisiDAO().create(kisi);
		
		Kisi kisim = new KisiDAO().readFind(1L);
		System.out.println("Kisim:"+kisi.getAd());
		
		kisim.setAd("Mr.Sel�uk");
		new KisiDAO().update(kisim);
		
		new KisiDAO().delete(kisim);
	}
	
	
}
