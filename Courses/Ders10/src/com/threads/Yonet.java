package com.threads;

import java.util.List;

public class Yonet {
	
	//Ana thread
	public static void main(String[] args) throws InterruptedException {
		/*System.out.println("---------------"); 
		
		//Alt Thread
		Thread th1 = new Thread(new TemelOrnek());
		th1.setPriority(Thread.MAX_PRIORITY);
		th1.start();
		
		Thread th2 = new Thread(new TemelOrnek());
		th2.start();
		 
		Thread.sleep(1000);
		System.out.println("----------------");
		*/
		
		DiziIslemi di = new DiziIslemi();
		di.ready();
		Long timeStamp1 = System.currentTimeMillis();
		System.out.println("Baþlama Saati:"+timeStamp1);
		
		List<String>  d1 = di.dizi.subList(0, 249);
		List<String>  d2 = di.dizi.subList(245, 499);
		List<String>  d3 = di.dizi.subList(500, 749);
		List<String>  d4 = di.dizi.subList(750, 1000);
		
		new DiziDuzenleyicisi(d1, timeStamp1).run();
		new DiziDuzenleyicisi(d2, timeStamp1).run();
		new DiziDuzenleyicisi(d3, timeStamp1).run();
		new DiziDuzenleyicisi(d4, timeStamp1).run();
		
		
		
		
	}

}
