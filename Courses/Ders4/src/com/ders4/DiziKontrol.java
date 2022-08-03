package com.ders4;

import com.ders4.hatalar.BoyutKontrolHatasi;

public class DiziKontrol {

	public void diziUzunluguKontrol(Integer[] liste) {

		if (liste.length > 10) {
			throw new BoyutKontrolHatasi("Dizi Uzunlu�u gere�inden fazla b�y�k !, "
					+ "L�tfen dizi boyutunu 10 dan k���k belirleyin !");
		}

	}

	public static void main(String[] args) {
		DiziKontrol dk = new DiziKontrol();
		Integer[] listem = new Integer[20];
		dk.diziUzunluguKontrol(listem);

	}

}
