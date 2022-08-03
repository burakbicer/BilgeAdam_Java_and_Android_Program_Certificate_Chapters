package com.ders4;

import com.ders4.hatalar.HesapKapali;
import com.ders4.hatalar.OzelHata;

public class BankaUygulamasi {

	public static void main(String[] args) throws HesapKapali   {
		
		MaasKontrol bankaHesabi = new MaasKontrol();

		try {
			System.out.println("Maaþ yatýrýlýyor! 1000 TL");
			bankaHesabi.setMaas(1000);
			System.out.println("300 tl çekiliyor...");
			bankaHesabi.cekimYap(300);
			System.out.println("200 tl çekiliyor...");
			bankaHesabi.cekimYap(200);
			System.out.println("600 tl çekiliyor...");
			bankaHesabi.cekimYap(600);
		} catch (OzelHata hata) {
			
			System.out.println("Üzgünüz, hesap bakiyesi "
					+ "yetersiz ! Limit artýrýmý "
					+ "istermisiniz ? Artýrým oraný:"
					+ hata.getMaas());
		}catch (HesapKapali e) {
			System.out.println("Dikkat ! Hesap kapatýlmýþtýr !");

		}
		
		
	}

}
