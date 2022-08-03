package com.ebys.islemler;

import java.util.Date;

import com.ebys.GelenEvrak;
import com.ebys.GidenEvrak;

public class Yonet {

	public static void main(String[] args) {

		DokumanUretici<GelenEvrak> du = new DokumanUretici<GelenEvrak>();
		du.setDokuman(new GelenEvrak());

		GelenEvrak ge = du.getDokuman();
		ge.setGeldigimakam("Baþbakanlýk");
		ge.setKonu("Örnek Baþlýk");
		ge.setMakam("Ýç iþleri bakanlýðý");
		ge.setNo(834756837265L);
		ge.setOlusmaTarihi(new Date());

		DokumanUretici<GidenEvrak> du2 = new DokumanUretici<GidenEvrak>();
		du2.setDokuman(new GidenEvrak());

		GidenEvrak ge2 = du2.getDokuman();
		ge2.setGidecekMakam("Cumhurbaþkanlýðý");
		ge2.setKonu("Baþlýk");
		ge2.setMakam("Saðlýk Bakanlýðý");
		ge2.setNo(8768769876876L);
		ge2.setOlusmaTarihi(new Date());
		
		
		GelenEvrak gelenEvrak  = 
		(GelenEvrak) new DokumanUreticisi2<GelenEvrak>().dokumanYarat().getEvrak();
		
		GidenEvrak gidenEvrak = 
		(GidenEvrak) new DokumanUreticisi2<GidenEvrak>().dokumanYarat().getEvrak();
		
		
		
		

	}

}
