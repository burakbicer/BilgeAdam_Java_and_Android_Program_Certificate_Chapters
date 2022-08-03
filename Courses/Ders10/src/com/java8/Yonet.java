package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Yonet {

	public static void main(String[] args) {

		StreamOrnek.ornekPojo obj1 = new StreamOrnek().new ornekPojo();
		obj1.setAd("Bilge");
		obj1.setId(134623466L);
		obj1.setSoyad("Bilir");
		obj1.setTc("59348759837");

		StreamOrnek.ornekPojo obj2 = new StreamOrnek().new ornekPojo();
		obj2.setAd("Bilgin");
		obj2.setId(87687687686L);
		obj2.setSoyad("Ýleri");
		obj2.setTc("793745693486");

		List<StreamOrnek.ornekPojo> islemDizisi = Arrays.asList(obj1, obj2);
		Stream<StreamOrnek.ornekPojo> islemDizisiSt = islemDizisi.stream();

		Stream<StreamOrnek.ornekPojo> islemDizisiSt2 = Arrays.asList(obj1, obj2).stream();

		islemDizisiSt.forEach(bilgi -> {
			System.out.println("---------------------------");
			System.out.println("Ad:" + bilgi.getAd());
			System.out.println("Soyad:" + bilgi.getSoyad());
			System.out.println("Tc:" + bilgi.getTc());
			System.out.println("ID:" + bilgi.getId());

		});

		Predicate<StreamOrnek.ornekPojo> pd_ornek = data -> data.getAd().contains("Bilgi");
		
		Predicate<StreamOrnek.ornekPojo> pd_ornek2 = data -> data.getSoyad().contains("Ýleri");

		Predicate<StreamOrnek.ornekPojo> pd_ornek3 = data -> data.getId() < 99999999999L ;
		
		Stream<StreamOrnek.ornekPojo> filtreliHali = islemDizisiSt2.filter(pd_ornek);

		// 1. yol
		/*filtreliHali.forEach(bilgi -> {
			System.out.println("Bilgi" + bilgi.getAd());
		});*/
		
		filtreliHali.forEach(Yonet::yazdir);
		
		List<Integer> tekrarliDizi = 
				Arrays.asList(1,2,3,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6,6,6);
		tekrarliDizi.stream().distinct().
		forEach(bilgi -> { System.out.println("Bilgi:"+ bilgi);});
		
		List<Integer> tekrarliDizi2 = 
				Arrays.asList(111,22,3,313,312,32,444,43,423,423,543,55,53,5,54,6,56,678,65,63);
		tekrarliDizi2.stream().sorted().limit(5).
		forEach(bilgi -> { System.out.println("Bilgi 2:"+ bilgi);});
		
		
		
		

	}

	public static void yazdir(StreamOrnek.ornekPojo veri) {
		System.out.println("Veri: " + veri.getTc() + " -- " + veri.getAd());
	}
	
	
	

}
