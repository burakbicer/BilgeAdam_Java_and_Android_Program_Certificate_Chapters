package com.ders4;

import com.ders4.hatalar.BoyutKontrolHatasi;

public class DiziKontrol {

	public void diziUzunluguKontrol(Integer[] liste) {

		if (liste.length > 10) {
			throw new BoyutKontrolHatasi("Dizi Uzunluðu gereðinden fazla büyük !, "
					+ "Lütfen dizi boyutunu 10 dan küçük belirleyin !");
		}

	}

	public static void main(String[] args) {
		DiziKontrol dk = new DiziKontrol();
		Integer[] listem = new Integer[20];
		dk.diziUzunluguKontrol(listem);

	}

}
