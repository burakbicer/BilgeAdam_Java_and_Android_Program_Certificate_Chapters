package com.corecollection;

import java.awt.print.Book;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.print.attribute.standard.PrinterLocation;

public class Yonet {

	public static void main(String[] args) {

		atla: {
			if (true)
				break atla;

			List<Integer> dizi1 = new ArrayList<>();
			dizi1.add(1);
			dizi1.add(2);
			dizi1.add(3);

			ArrayList<Integer> dizi2 = new ArrayList<>();
			dizi2.add(1);
			dizi2.add(2);
			dizi2.add(3);

			for (Integer sayi : dizi1)
				System.out.println("Deðer:" + sayi);

			for (Integer sayi : dizi2)
				System.out.println("Deðer 2:" + sayi);

			List<String> dizi3 = new ArrayList<>();
			dizi3.add("1");
			dizi3.add("2");
			dizi3.add("3");

			for (String string : dizi3) {
				System.out.println("Bilgi:" + string);
			}
			System.out.println("----------------------");
			Set<Integer> dizi4 = new HashSet<>();
			dizi4.add(1);
			dizi4.add(2);
			dizi4.add(3);

			dizi4.remove(3);

			for (Integer integer : dizi4) {
				System.out.println("Bilgi Set:" + integer);
			}

			System.out.println("----------------------");
			Map<String, Integer> map = new HashMap<>();
			map.put("bir", 1);
			map.put("iki", 2);
			map.put("üç", 3);

			if (map.containsKey("iki")) {
				System.out.println("Ýki key var");
			} else {
				System.out.println("Ýki key yok");
			}

			// map.clear();

			Integer sonuc = map.remove("bir");
			System.out.println("Sonuç:" + sonuc);
			map.remove("üç");
			map.remove("iki");

			if (map.containsKey("iki")) {
				System.out.println("Ýki key var");
			} else {
				System.out.println("Ýki key yok");
			}

			if (map.isEmpty()) {
				System.out.println("Dizi Boþ");
			} else {
				System.out.println("Dizi Dolu");
			}

			System.out.println("Map:" + map.get("bir"));

			// Iterator ve MAp.Entry Yöntemi
			Iterator<Map.Entry<String, Integer>> ite = map.entrySet().iterator();
			while (ite.hasNext()) {
				Map.Entry<String, Integer> bilgi = ite.next();
				System.out.println("Key:" + bilgi.getKey() + "  Value:" + bilgi.getValue());
			}

			// Foreach ve Map.Entry
			for (Map.Entry<String, Integer> bilgi : map.entrySet()) {
				System.out.println("2 Key:" + bilgi.getKey() + " 2 Value :" + bilgi.getValue());
			}

			// keySet ve Foreach
			for (String key : map.keySet()) {
				System.out.println("3 Key:" + key + "3 Value: " + map.get(key));
			}

			// Java 8
			map.forEach((k, v) -> {
				System.out.println("Key:" + k + " Value:" + v);
			});

			// Java 8 Stream
			map.entrySet().stream()
					.forEach(deger -> System.out.println("Key:" + deger.getKey() + " Value:" + deger.getValue()));

			// Java 8 Stream Api Parallel
			map.entrySet().stream().parallel()
					.forEach(deger -> System.out.println("Key:" + deger.getKey() + " Value:" + deger.getValue()));

			System.out.println("------------------------");

			SortedSet<Integer> srtset = new TreeSet<>();
			srtset.add(5);
			srtset.add(10);
			srtset.add(1);
			srtset.add(2);
			srtset.add(6);
			srtset.add(11);
			for (Integer deger : srtset) {
				System.out.println("Deger:" + deger);
			}

			Iterator<Integer> iter = srtset.iterator();
			while (iter.hasNext()) {
				Integer deger = iter.next();
				System.out.println("Bilgi:" + deger);
			}

			SortedSet<String> srtsetstr = new TreeSet<>();
			srtsetstr.add("a");
			srtsetstr.add("z");
			srtsetstr.add("i");
			srtsetstr.add("b");
			srtsetstr.add("c");
			// Java 8 Delegation ile görev atama
			srtsetstr.forEach(System.out::println);
			srtsetstr.forEach(bilgi -> System.out.println(bilgi));

			Deque<Integer> dq = new ArrayDeque<>();
			dq.add(1);
			dq.add(2);
			dq.add(3);
			dq.add(4);
			dq.add(5);
			dq.add(6);
			dq.forEach(System.out::println);

			Integer deger = dq.poll();
			System.out.println("Deðer:" + deger);
			dq.forEach(System.out::println);

			Integer deger2 = dq.peek();
			System.out.println("Deger 2:" + deger2);
			dq.forEach(System.out::println);

			Integer deger3 = dq.peekFirst();
			System.out.println("Deger 3:" + deger3);
			dq.forEach(System.out::println);

			dq.descendingIterator().forEachRemaining(bilgi -> {
				System.out.println("Bilgi:" + bilgi);
			});

			Map<GUNLER, String> gunler = new EnumMap(GUNLER.class);
			gunler.put(GUNLER.PAZARTESI, "Pazartesi");
			gunler.put(GUNLER.PERSEMBE, "Perþembe");
			gunler.put(GUNLER.PAZAR, "Pazar");

			gunler.forEach((anahtar, veri) -> {
				System.out.println("Bilgi:" + veri);
			});

			SortedMap<String, Integer> map2 = new TreeMap();
			map2.put("a", 1);
			map2.put("b", 2);
			map2.put("c", 3);
			map2.put("d", 4);
			map2.put("e", 5);
			SortedMap<String, Integer> map3 = map2.subMap("a", "e"); // map.tailMap("iki");//map.headMap("iki");
			map2.forEach((key, val) -> {
				System.out.println(val);
			});

			LinkedList<Integer> linlist = new LinkedList<>();
			linlist.add(1);
			linlist.add(2);
			linlist.add(20);
			linlist.add(11);
			linlist.add(8);
			linlist.addFirst(0);
			linlist.addLast(9);

			linlist.forEach(bilgi -> {
				System.out.println("Bilgi:" + bilgi);
			});

			linlist.remove(3);

			linlist.forEach(bilgi -> {
				System.out.println("Bilgi:" + bilgi);
			});

			linlist.removeFirst();
			linlist.removeLast();

			linlist.forEach(bilgi -> {
				System.out.println("Bilgi:" + bilgi);
			});

			linlist.add(1, 99);
			linlist.forEach(bilgi -> {
				System.out.println("Bilgi:" + bilgi);
			});

			LinkedHashMap<String, Kisi> kisiler = new LinkedHashMap<>();

			kisiler.put("12345678901", new Kisi("Bilge", "Adam", "12345678901"));
			kisiler.put("12345678902", new Kisi("Bilge", "Adam", "12345678902"));

			System.out.println("Kiþi:" + kisiler.get("12345678901").getAd());

			// Java 8
			kisiler.forEach((key, bilgi) -> {
				System.out.println("Kiþi ad:" + bilgi.getAd());
				System.out.println("Kiþi soyad:" + bilgi.getSoyad());
			});

			// Java 7
			Set set = kisiler.entrySet();
			Iterator i = set.iterator();
			while (i.hasNext()) {
				Map.Entry me = (Map.Entry) i.next();
				System.out.println("Tc:" + me.getKey());
				System.out.println("Ad:" + ((Kisi) me.getValue()).getAd());
			}

			IdentityHashMap<String, Kisi> idenHash = new IdentityHashMap<>();
			idenHash.put("12353425", new Kisi("Bilge", "Adam", "76984697594756"));

			Kisi kisi = idenHash.getOrDefault("12353425", new Kisi("Selçuk", "Uzunsoy", "983476983769"));
			System.out.println("Kiþi Ad:" + kisi.getAd());

			if (idenHash.containsKey("12353425")) {
				kisi = idenHash.get("12353425");
			} else {
				kisi = new Kisi("Selçuk", "Uzunsoy", "983476983769");
			}
			// Short-case/if
			Kisi kisim = idenHash.containsKey("12353425") ? idenHash.get("12353425")
					: new Kisi("Selçuk", "Uzunsoy", "983476983769");

		}

		new Yonet().siralamalar();

	}

	private void siralamalar() {

		String[] araclar = { "Mercedes", "Bmw", "Audi" };
		Integer[] sayilar = new Integer[] { 10, 22, 1, 5, 6, 99, 3 };
		Arrays.sort(araclar);
		Arrays.sort(sayilar);
		
		//Java 7
		for (String arac : araclar) {
			System.out.println("Araç:" + arac);
		}
		 			
		for (Integer sayi : sayilar) {
			System.out.println("Sayý:" + sayi);

		}
		
		List<String> araclar2 = new ArrayList<>();
		araclar2.add("Mercedes");
		araclar2.add("Bmw");
		araclar2.add("Audi");
		
		//Java 8
		Collections.sort(araclar2);
		araclar2.forEach(arac -> {
			System.out.println("Araç:"+arac);
		});
		

		Arac[] araclar3 = new Arac[] {
				new Arac("Mercedes", "a180", 150000),
				new Arac("Bmw", "318d", 200000),
				new Arac("Audi","A6",240000)				
		};
		
		Arrays.sort(araclar3, Arac.ismeGoreListeleComp);		
		for(Arac arac : araclar3) {
			System.out.println("Marka:"+ arac.getAracAdi()
			+" Model:"+arac.getAracModel()
			+" Fiyat:"+arac.getFiyat()
					);
		}
		
		Personel[] personels = {
				new Personel("Ali", "Bilir", 30, 4000),
				new Personel("Veli", "Bilir", 50, 2000),
				new Personel("Bilgin", "Bilir", 35, 6000)
		};
		Arrays.sort(personels);
		for(Personel per : personels) {
			System.out.println("Ad:"+per.getIsim()
			+" Yaþ:"+ per.getYas()
			+" Maaþ:"+per.getMaas()
					);
		}
				
		Arrays.sort(personels, Personel.maasKiyaslaComp);
		for(Personel per : personels) {
			System.out.println("Ad:"+per.getIsim()
			+" Yaþ:"+ per.getYas()
			+" Maaþ:"+per.getMaas()
					);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
