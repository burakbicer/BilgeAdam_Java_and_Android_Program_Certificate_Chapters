package com.yonetim;

import com.pojo.Araba;

public class Yonet {

	public static void main(String[] args) {
		  
	   Araba araba = new Araba();
	   
	   System.out.println("Araba rengi:"+araba.getRenk());  
	   
	   araba.setRenk("KIRMIZI");
	   
	   System.out.println("Araba rengi:"+araba.getRenk());
		
	   Araba araba2 = new Araba();
	   araba2 = araba;
	   
	   System.out.println("Araba rengi 2 :"+araba2.getRenk());
	   
	   int sayi = 5;
	   
	   Integer sayi2 = 5; 
	   
	   araba.setAgirlik(5);
	     
	   
	}

}
