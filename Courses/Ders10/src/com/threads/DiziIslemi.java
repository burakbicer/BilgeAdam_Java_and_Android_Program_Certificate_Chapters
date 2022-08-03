package com.threads;

import java.util.ArrayList;
import java.util.List;

public class DiziIslemi {

	public static List<String> dizi = new ArrayList<>();

	public void ready() throws InterruptedException {
		System.out.println("Dizi iþleme hazýrlanýyor");
		dizi.clear();
		for (int i = 0; i < 1000; i++) {
			
			dizi.add(i + ". Adým");
		}
		System.out.println("Dizi iþleme tamamlandý !");
	}

	
	
	
	
}
