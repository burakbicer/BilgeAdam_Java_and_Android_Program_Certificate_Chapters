package com.poli;

import com.pojos.Arac;
import com.pojos.IAracFonksiyonlari;
import com.pojos.arac.Audi;
import com.pojos.arac.BMW;
import com.pojos.arac.Mercedes;

public class Yonet {

	public static void main(String[] args) {

		IAracFonksiyonlari bmw = new BMW();
		IAracFonksiyonlari merc = new Mercedes();
		IAracFonksiyonlari audi = new Audi();
		camiAc(bmw);
		camiAc(audi);
		camiAc(merc);

		BMW bmw1 = new BMW();
		Mercedes merc1 = new Mercedes();
		Audi audi1 = new Audi();
		
		Arac ort;
		ort = bmw1;
		ort.aracMarkasi();
		
		ort = merc1;
		ort.aracMarkasi();
		
		ort = audi1;
		ort.aracMarkasi();
		
		
		
		
		
		
	}
	
	//Proxy Method
	public static void camiAc(IAracFonksiyonlari islm) {
		islm.camiAc();
	}

}
