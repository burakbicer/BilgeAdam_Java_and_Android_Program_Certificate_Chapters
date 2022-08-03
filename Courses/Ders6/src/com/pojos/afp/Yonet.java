package com.pojos.afp;

public class Yonet {

	public void islem() {

		AracFabrikasiYoneticisi afy = new AracFabrikasiYoneticisi(new Mercedes());
		AracFabrikasi<Arac> af = afy.getAracFabrikasi();
		System.out.println("Bilgi:" + af.getArac().getAd());

		afy = new AracFabrikasiYoneticisi(new Bmw());
		af = afy.getAracFabrikasi();
		System.out.println("Bilgi:" + af.getArac().getAd());
	}

	public static void main(String[] args) {

		new Yonet().islem();

	}

}
