package com.ders4;

import com.ders4.hatalar.HesapKapali;
import com.ders4.hatalar.OzelHata;

public class BankaUygulamasi {

	public static void main(String[] args) throws HesapKapali   {
		
		MaasKontrol bankaHesabi = new MaasKontrol();

		try {
			System.out.println("Maa� yat�r�l�yor! 1000 TL");
			bankaHesabi.setMaas(1000);
			System.out.println("300 tl �ekiliyor...");
			bankaHesabi.cekimYap(300);
			System.out.println("200 tl �ekiliyor...");
			bankaHesabi.cekimYap(200);
			System.out.println("600 tl �ekiliyor...");
			bankaHesabi.cekimYap(600);
		} catch (OzelHata hata) {
			
			System.out.println("�zg�n�z, hesap bakiyesi "
					+ "yetersiz ! Limit art�r�m� "
					+ "istermisiniz ? Art�r�m oran�:"
					+ hata.getMaas());
		}catch (HesapKapali e) {
			System.out.println("Dikkat ! Hesap kapat�lm��t�r !");

		}
		
		
	}

}
