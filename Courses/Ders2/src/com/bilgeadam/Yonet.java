package com.bilgeadam;

import java.util.Locale;

public class Yonet {

	private void islem(int sayi) {

		if (sayi < 10) {
			System.out.println("10 dan küçük");

		} else {
			System.out.println("10dan büyük veya 10 a eşit");

		}

		if (sayi < 10) {
			System.out.println("10 dan küçük");

		} else if (sayi >= 10 && sayi < 20) {
			System.out.println("10 dan büyük veya eşit, 20 den küçük");

		} else {
			System.out.println("20 den büyük veya eşit");

		}

	}

	private void islem2() {

		Integer sayi = 5;
		sayi += 5;
		sayi -= 2;
		sayi /= 2;
		sayi *= 10;
		int sayi2 = sayi;// Unboxing
		Integer sayi3 = sayi2;// Boxing
		System.out.println("Sayı:" + sayi);

	}

	private void islem3(Integer sayi) {

		String msg = sayi > 10 ? "Sayı 10 dan büyük" : "Sayı 10 dan küçük";
		String msg2 = sayi > 10 && sayi < 20 ? "Sayı 10 ile 20 arasında" : "Sayı istenen aralıkta değil.";

		System.out.println("Bilgi:" + msg);
		System.out.println("Bilgi:" + msg2);

	}

	private void islem4() {

		String isim = "BilgeAdam";
		boolean sonuc1 = (1 < 20);// Short if kullanımına bir örnek
		boolean sonuc2 = (Integer) 6 instanceof Integer;// Değişkenin Tipini kontrol etmek

		Integer deger1 = 6;
		Integer deger = new Integer(6);// Kurucu sınıf ile ilk değer atama
		boolean sonuc = isim instanceof String;// Değişken tipinin kontrolü sağlanıyor.

		if (deger == 6) {
			System.out.println("Doğru");
		} else {
			System.out.println("Yanlış");
		}

	}

	private void islem5(String parametre) {

		Integer deger = 0;

		switch (parametre) {
		case "bir":
			deger = 1;
			break;

		case "iki":
			deger = 2;
			break;

		case "uc":
			deger = 3;
			break;

		default:
			deger = 0;
			break;
		}

		System.out.println("Sonuç:" + deger);

	}

	private void islem6(GUNLER gun) {

		switch (gun) {
		case PAZARTESI:
			System.out.println("Pazartesi işlerini yap");
			break;
		case SALI:
			System.out.println("Salı işlerini yap");
			break;
		case CARSAMBA:
			System.out.println("Çarşamba işlerini yap");
			break;
		case PERSEMBE:
			System.out.println("Perşembe işlerini yap");
			break;
		case CUMA:

			System.out.println("Cuma işlerini yap");
			break;
		case CUMARTESI:

			System.out.println("Cumartesi işlerini yap");
			break;
		}

	}

	private void islem7() {

		int sayac = 0;
		while (sayac <= 10 && false) {

			System.out.println("Sayaç :" + sayac);

			sayac++;
		}

		int toplam = 100;
		do {

			toplam--;
			System.out.println("Toplam:" + toplam);

		} while (toplam > 30);

	}

	private void islem8() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Sayac:" + i);
		}

		int j = 0;
		for (; j < 10; j++) {
			System.out.println("Sayaç:" + j);

		}
		// Sonsuz döngü
		/*
		 * for(;;){
		 * 
		 * }
		 */
		// For ile iç method kullanımı
		for (int a = 0; kontrol(a); a++) {
			System.out.println("Bilgi:" + a);
		}

		String veri = "";
		String[] dizi_paketi = { "Bilgi ", "Güçtür, ", "Kontrol ", "Gereklidir" };

		for (String text : dizi_paketi) {
			System.out.print(text);
		}
		System.out.println("");
		System.out.println("----------------------------");

		for (int i = 0; i < dizi_paketi.length; i++)
			System.out.print(dizi_paketi[i]);
		
		System.out.println("");
		System.out.println("----------------------------");

		int i = 0;
		while (i < dizi_paketi.length) {
			System.out.print(dizi_paketi[i]);
			i++;
		}
	}

	private void islem9() {		
		char a = 'A';		
		System.out.println("Char Bilgisi:"+a);
		
		char b ='\u0061';
		System.out.println("Char Bilgisi:"+b);
		
		int ascii = (int) a;
		System.out.println("Ascii Karşılığı:"+ascii);
		
		String isim = "BilgeAdam";
		isim = isim.concat(" Eğitim Merkezi");
		System.out.println("Açıklama:"+isim);
		
		isim = isim.toUpperCase();
		System.out.println("Açıklama:"+isim);
		
		isim = isim.toLowerCase();
		System.out.println("Açıklama:"+isim);
		
		isim = isim.toLowerCase(new Locale("tr"));
		System.out.println("Açıklama:"+isim);
		
	    String bilgi =Character.isUpperCase('a') ? "Büyük Harf":"Küçük Harf"; 
	    System.out.println("Açıklama:"+bilgi);
		
	    System.out.printf("Yıllık gelir ortalaması %f tl, bu değerin yüzde %d miktarı vergidir."
	    		,30000f,10);
	    
	    System.out.println("");
	    System.out.println("-----------------------------");
	    
	    
	    String text = "Bilgi güçtür, konrol gereklidir.";
	    String ilk_text = text.substring(0,13).toUpperCase(new Locale("tr", "TR"));
	    String ikinci_text = text.substring(14).toUpperCase(new Locale("tr", "TR"));
	    System.out.println("ilk t:"+ilk_text);
	    System.out.println("İkinci t:"+ikinci_text);
	    
	    String arapca = "صياد مسن";
	    System.out.println("Bilgi:"+arapca.toUpperCase(new Locale("ar", "DZ")));
	    
	    String cince = "例子";
	    System.out.println("Bilgi:"+cince.toUpperCase(new Locale("zh","CN")));
	    
	    String bilgi2 = "Deneme 1,2,3";
	    int konum = bilgi2.indexOf("2,");
	    System.out.println("Konum:"+konum);
	    
	    bilgi2 = bilgi2.replace("1,", "0,");
	    System.out.println("Konum:"+bilgi2);
	    
	    bilgi2 = bilgi2.replaceAll(",", "#");
	    System.out.println("Konum:"+bilgi2);
	    
	}
	
	
	private boolean kontrol(int deger) {
		return deger < 10;
	}

	public static void main(String[] args) {

		// new Yonet().islem(25);
		// new Yonet().islem2();
		// new Yonet().islem3(40);
		// new Yonet().islem3(10);
		// new Yonet().islem4();
		// new Yonet().islem5("bir");
		// new Yonet().islem5("iki");
		// new Yonet().islem5("uc");
		// new Yonet().islem6(GUNLER.CUMA);
		// new Yonet().islem7();
		// new Yonet().islem8();
		new Yonet().islem9();
	}

}
