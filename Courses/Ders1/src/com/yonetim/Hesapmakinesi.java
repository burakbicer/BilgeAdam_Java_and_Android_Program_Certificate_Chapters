package com.yonetim;

public class Hesapmakinesi {

	private double sayi1=15;
	private double sayi2=10;
	private static final int degismez_deger = 4;
	
	//Overload
	public String islem(double sayi1, double sayi2) {

		// Toplama
		double toplam = sayi1 + sayi2;

		//��kartma
		double cikartim = sayi1 - sayi2;

		//B�lme
		double bol = sayi1 / sayi2;

		//�arpma
		double carp = sayi1 * sayi2;
		
		String sonuc = "Toplama:"+toplam;
		sonuc += "   ��kart:"+cikartim;
		sonuc += "   B�l:"+bol;
		sonuc += "   �arp:"+carp;
		
		return sonuc;

	}
	//Overload
	public Integer islem(double sayi1, double sayi2, String islem) {
		
		//TODO Bu alana if yap�s�n� anlatt�ktan sonra gerekli kodlar� yaz.
		
		return 0;		
	}
	

	public void deneme() {

		//islem();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		String out = new Hesapmakinesi().islem(15,10);
		System.out.println("Sonu�: "+ out);
		
		System.out.println("Sonu� 2: "+ new Hesapmakinesi().islem(25,10));
		
	}

}
