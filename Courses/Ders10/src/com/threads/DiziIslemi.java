package com.threads;

import java.util.ArrayList;
import java.util.List;

public class DiziIslemi {

	public static List<String> dizi = new ArrayList<>();

	public void ready() throws InterruptedException {
		System.out.println("Dizi i�leme haz�rlan�yor");
		dizi.clear();
		for (int i = 0; i < 1000; i++) {
			
			dizi.add(i + ". Ad�m");
		}
		System.out.println("Dizi i�leme tamamland� !");
	}

	
	
	
	
}
