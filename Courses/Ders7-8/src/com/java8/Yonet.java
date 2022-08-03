package com.java8;

public class Yonet {

	public static void main(String[] args) {

		matematikIslemi toplama = (int sayi1, int sayi2) -> sayi1 + sayi2;
		matematikIslemi cikartma = (int sayi1, int sayi2) -> sayi1-sayi2;
		
		System.out.println("Toplam:"+ new Yonet().islemYap(10, 30, toplama));
		System.out.println("Çýkartma:"+ new Yonet().islemYap(10, 30, cikartma));
		
		
	}

	interface matematikIslemi {

		int islem(int sayi1, int sayi2);

	}

	private int islemYap(int sayi1, int sayi2, matematikIslemi matIs) {

		return matIs.islem(sayi1, sayi2);
	}

}
