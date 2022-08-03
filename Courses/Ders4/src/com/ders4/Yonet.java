package com.ders4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Yonet {

	/**
	 * java.lang Object Throwable Error Exceptions Runtime Exceptions Other
	 * Exceptions
	 * 
	 */

	private void islem1() {

		System.out.println("hat 1");
		try {

			int a = 1;
			int b = 0;
			double sonuc = a / b;

		} catch (Exception e) {
			System.out.println("Hata oluþtu:" + e.getMessage());
		}

		System.out.println("hat 2");

	}

	private void islem2() {
		try {
			int sayi[] = new int[2];
			sayi[0] = 1;
			sayi[1] = 2;
			System.out.println("Bilgi:" + sayi[3]);

		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	private void islem3() {
		try {
 
			FileInputStream file =new FileInputStream("C:/Deneme/deneme.txt");
			byte bilgi = (byte) file.read();
				
		}catch (FileNotFoundException e) {
			
			System.out.println("Dosya bulunamadý !");
					
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	private void islem4() {
		
		try{
			
			Integer deger = null;
			Integer islem = 10;
			islem +=deger;
			
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			System.out.println("Finally Bloðu !");
		}
		
		
	}
	
	private double toplama(Integer a, Integer b) {
		
		double toplam=0;
		try {
			toplam =  (a + b);	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			toplam += toplam*0.18;			
			System.out.println("Toplama % 18 kdv eklendi !");
			
		}
		return toplam;
		
	}
	
	private double indirim(Double a, Double b, Double indirimorani) {
		
		double indirim=0,indirimy=0;
		try {
			indirim =  (a + b);	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
			//  Deger = Deger - Deger * 20/100  
			indirimy  = indirim - (indirim * (indirimorani /100));
			//indirim = indirim*((100-indirimorani)/100);			
			System.out.printf("Toplama %f kdv eklendi !",indirimorani);
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return indirimy;
		
	}
	
	private void anaHataKontrolu()  {
	
		try {
			System.out.println("L1");
			islem6();
			System.out.println("L4");
		} catch (Exception e) {
			System.out.println("LE2");
			e.printStackTrace();
			throw e;
		}
		System.out.println("L5");	 	
	}	
	private void islem6()  {
		System.out.println("L2");
		try {
			int a =1;
			int b = 0;
			int sonuc = a / b;
		} catch (Exception e) {
			System.out.println("LE1");
			e.printStackTrace();
			throw e;
		}		
		System.out.println("L3");
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {

		// new Yonet().islem1();
		// new Yonet().islem2();
		// new Yonet().islem3();
		// new Yonet().islem4();
		// System.out.println("Toplam:"+new Yonet().toplama(50, 50));
		// System.out.println("Ýndirimli satýþ:"+new Yonet().indirim(50d, 50d, 20d));
		new Yonet().anaHataKontrolu();
	}

}
