package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Karsilastirma {

	static List<Kisi> kisiListesi = kisileriOlustur();

	public void main2(String[] args) {

		kisiListesi.sort(new Comparator<Kisi>() {
			@Override
			public int compare(Kisi o1, Kisi o2) {

				return o1.getYas() - o2.getYas();
			}
		});

		kisiListesi.forEach(kisi -> {
			System.out.println("Yaþ:  " + kisi.getYas() + "  Kiþi Ad:" + kisi.getAd());
		});

		// Lambda exp. tanýmlama ile sýralamayý
		// daha efektif gerçekleþtirirsek sonuç þöyle olur:
		kisiListesi.sort((kisi1, kisi2) -> kisi2.getMaas() - kisi1.getMaas());

		kisiListesi.forEach(kisi -> {
			System.out.println("Maaþ:  " + kisi.getMaas() + "  Kiþi Ad:" + kisi.getAd());
		});

		kisiListesi.sort((kisi1, kisi2) -> kisi1.getAd().toUpperCase().compareTo(kisi2.getAd().toUpperCase()));

		kisiListesi.forEach(kisi -> {
			System.out.println("Maaþ:  " + kisi.getMaas() + "  Kiþi Ad:" + kisi.getAd());
		});

		// filter()
		// collect()
		// findAny()
		// orElse()
		System.out.println("--------------------------------------");
		kisiListesi = kisileriOlustur();
		// Deðiþkeni atýyoruz, liste öðesi tipine dönüþüyor

		kisiListesi = kisiListesi.stream().filter(kisi -> "Ali".equals(kisi.getAd())).collect(Collectors.toList());

		List<Kisi> liste2 = kisileriOlustur();
		liste2 = liste2.stream().filter(kisi -> 88888 < kisi.getMaas()).collect(Collectors.toList());

		liste2.forEach(kisi -> {
			System.out.println("Maaþý 88888 den büyük Kiþiler :" + kisi.getAd());
		});
		System.out.println("--------------------------------------");
		kisiListesi.forEach(kisi -> {
			System.out.println("Kiþi: " + kisi.getAd());
		});

		List<Kisi> liste3 = kisileriOlustur();
		Kisi kisim = liste3.stream().sorted((kisi1, kisi2) -> kisi1.getYas() - kisi2.getYas()).filter(k -> {
			if (10 < k.getYas()) {
				return true;
			}
			return false;
		}).findAny().orElse(new Kisi("Selçuk", 999999, 30));

		System.out.println("Kiþim:" + ((kisim == null) ? "" : kisim.getAd()));

		List<Kisi> liste4 = kisileriOlustur();

		List<String> isimler = liste4.stream().map(Kisi::getAd).collect(Collectors.toList());

		isimler.forEach(System.out::println);

		Deque<String> isimler2 = new LinkedList<String>();
		isimler2.add("A");
		isimler2.add("B");
		isimler2.add("C");
		isimler2.add("D");
		isimler2.add("B");
		isimler2.add("C");
		isimler2.add("D");

		liste4.stream().forEach(kisi -> {
			kisi.setAd(isimler2.pop());
		});
		liste4.forEach(kisi -> {
			System.out.println("Bilgi:" + kisi.getAd());
		});

		List<String> arabalar = Arrays.asList("Mercedes", "Bmw", "Audi", "Mercedes", "Ferrari", "Mercedes", "Bmw",
				"Bmw", "Mercedes");

		Map<String, Long> sonuclar = arabalar.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("Sonuç:" + sonuclar);

		// TODO Sýralý halde listelemeyi son derse býrak.

		List<Kisi> kisilerListesi = kisileriOlustur();

		Map<String, Integer> sonucListesi = kisilerListesi.stream()
				.collect(Collectors.groupingBy(Kisi::getAd, Collectors.summingInt(Kisi::getMaas)));

		System.out.println("Ýsimlere göre maaþ toplamlarý:" + sonucListesi);

		Map<String, Integer> ornekMap = new HashMap<>();
		ornekMap.put("k", 1);
		ornekMap.put("m", 2);
		ornekMap.put("a", 3);
		ornekMap.put("c", 4);
		ornekMap.put("f", 5);
		ornekMap.put("h", 6);

		System.out.println("Sýralamadan gösterim:" + ornekMap);

		Map<String, Integer> sonuc = ornekMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors
						.toMap(Map.Entry::getKey, Map.Entry::getValue, (deger1, deger2) -> deger1, LinkedHashMap::new));

		System.out.println("Sonuç: " + sonuc);

		/*
		 * Map<String, Integer> sonuc2 = ornekMap.entrySet().stream()
		 * .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
		 * .forEachOrdered(deger -> sonuc2.put(deger.getKey(), deger.getValue()));
		 * 
		 */

	}

	private static List<Kisi> kisileriOlustur() {
		List<Kisi> liste = new ArrayList<Kisi>();
		liste.add(new Kisi("Ali", 99999, 30));
		liste.add(new Kisi("Ali", 66999, 50));
		liste.add(new Kisi("Ali", 77999, 55));
		liste.add(new Kisi("Bilge", 88888, 32));
		liste.add(new Kisi("Bilge", 99999, 32));
		liste.add(new Kisi("Ayþe", 777777, 34));
		liste.add(new Kisi("Zeynep", 9999999, 15));
		return liste;

	}

	//Java 7
	public Integer rastgeleSayi() {

		Integer sayi = new Random().nextInt(10); // [0..10)
		return sayi;

	}
	
	//Java 8
	public Integer rastgeleSayi2() {
		return  new Random().ints(0, 3).findFirst().getAsInt();
		
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i<100; i++) {
		
		System.out.println("Sayý:"+ new Karsilastirma().rastgeleSayi2());
		
		}
	}
	

}
