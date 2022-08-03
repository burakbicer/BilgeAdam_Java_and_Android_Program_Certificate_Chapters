package com.ders4;

/**
 * Nested Classes
 * 		Inner Classes
 * 			Inner Classes
 * 			Method Local Inner Classes
 * 			Anonymous Inner Classes 
 * 		Static Nested Classes	
 * 
 * @author selcuk
 *
 */



public class OrnekSinif {

	private class innerClass{
		
		public void print() {
			
			System.out.println("Bu bir i� s�n�f !");
			
		}		
	}
	
	void calistir() {
		innerClass ic = new innerClass();
		ic.print();
	}
	
	public static void main(String[] args) {
		OrnekSinif disSinif = new OrnekSinif();
		disSinif.calistir();
		
		new OrnekSinif().new innerClass().print();
		
		System.out.println("��z�n�rl�k:"+Ayarlar.GoruntuAyarlari.cozunurluk);
		System.out.println("Ses seviyesi:"+Ayarlar.SesAyarlari.sesMiktari);
		
	}	
}
